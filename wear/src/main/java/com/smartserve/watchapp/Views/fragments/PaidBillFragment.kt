package com.smartserve.watchapp.Views.fragments

import android.util.Log
import androidx.lifecycle.observe
import com.rapidzz.garageapp.ViewModels.MainFunctionsViewModel
import com.smartserve.watchapp.Models.DataModels.GeneralModels.NotificationItem
import com.smartserve.watchapp.R
import com.smartserve.watchapp.Utils.Application.*
import com.smartserve.watchapp.Views.adapters.BaseAdapter
import com.smartserve.watchapp.Views.adapters.NotificationAdapter
import com.smartserve.watchapp.Views.adapters.PaidBillAdapter
import kotlinx.android.synthetic.main.fragment_notification.*
import kotlinx.android.synthetic.main.fragment_paid_bill.*
import kotlinx.android.synthetic.main.fragment_paid_bill.placeholder
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import org.koin.android.viewmodel.ext.android.viewModel

class PaidBillFragment : BaseFragment(R.layout.fragment_paid_bill), BaseAdapter.OnItemClicker {


    val viewModel: MainFunctionsViewModel by viewModel()

    var bills = ArrayList<NotificationItem>()

    private var billPaidAdapter: PaidBillAdapter? = null


    override fun initViews() {
        billPaidAdapter = PaidBillAdapter(bills, this)
        rvPaidBills.adapter = billPaidAdapter
    }


    override fun attachViewModel() {
        with(viewModel)
        {
            setupGeneralViewModel(this)
            notificationResponseLiveData.observe(viewLifecycleOwner) {
                it.getContentIfNotHandled()?.let {

                    bills.clear()
                    bills.addAll(it.data.filter { it.activity_type.equals("watch_new_order", true) })
                    if (bills.isNullOrEmpty().not()) {
                        placeholder.gone()
                        billPaidAdapter?.notifyDataSetChanged()
                    }else{
                        placeholder.visible()
                    }
                }
            }
            getNotifications(getCurrentDate())
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    open fun onMessageEvent(event: String) {
        //
        Log.e("notification", "received")
        viewModel.getNotifications(getCurrentDate())
    }

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    override fun onItemClick(position: Int, data: Any) {

    }
}