package com.smartserve.watchapp.Views.fragments

import com.rapidzz.garageapp.ViewModels.MainFunctionsViewModel
import com.smartserve.watchapp.Models.DataModels.GeneralModels.NotificationItem
import com.smartserve.watchapp.R
import com.smartserve.watchapp.Utils.Application.getCurrentDate
import com.smartserve.watchapp.Utils.Application.showAlertDialog
import com.smartserve.watchapp.Views.adapters.BaseAdapter
import com.smartserve.watchapp.Views.adapters.NotificationAdapter
import com.smartserve.watchapp.Views.adapters.PaidBillAdapter
import kotlinx.android.synthetic.main.fragment_paid_bill.*
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
            paidBillsResponseLiveData.observe(viewLifecycleOwner) {
                it.getContentIfNotHandled()?.let {
                    bills.clear()
                    bills.addAll(it.data)
                    billPaidAdapter?.notifyDataSetChanged()
                    if(bills.isNullOrEmpty())
                    {
                        showAlertDialog("No paid bill notifications found")
                    }

                }
            }

            getPaidBills(getCurrentDate())
        }
    }

    override fun onItemClick(position: Int, data: Any) {

    }
}