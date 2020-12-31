package com.smartserve.watchapp.Views.fragments

import com.rapidzz.garageapp.ViewModels.MainFunctionsViewModel
import com.smartserve.watchapp.R
import com.smartserve.watchapp.Utils.Application.getCurrentDate
import com.smartserve.watchapp.Views.adapters.BaseAdapter
import com.smartserve.watchapp.Views.adapters.NotificationAdapter
import com.smartserve.watchapp.Views.adapters.PaidBillAdapter
import kotlinx.android.synthetic.main.fragment_paid_bill.*
import org.koin.android.viewmodel.ext.android.viewModel

class PaidBillFragment : BaseFragment(R.layout.fragment_paid_bill), BaseAdapter.OnItemClicker {


    val viewModel: MainFunctionsViewModel by viewModel()


    override fun initViews() {
        rvPaidBills.adapter = PaidBillAdapter(bills, this)
    }

    var bills = ArrayList<String>()
    override fun attachViewModel() {

        with(viewModel)
        {
            setupGeneralViewModel(this)
            paidBillsResponseLiveData.observe(viewLifecycleOwner){
                it.getContentIfNotHandled()?.let {

                }
            }

            getPaidBills(getCurrentDate())
        }
    }

    override fun onItemClick(position: Int, data: Any) {

    }
}