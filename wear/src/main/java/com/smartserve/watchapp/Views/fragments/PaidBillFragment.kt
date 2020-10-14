package com.smartserve.watchapp.Views.fragments

import com.smartserve.watchapp.R
import com.smartserve.watchapp.Views.adapters.BaseAdapter
import com.smartserve.watchapp.Views.adapters.NotificationAdapter
import com.smartserve.watchapp.Views.adapters.PaidBillAdapter
import kotlinx.android.synthetic.main.fragment_paid_bill.*

class PaidBillFragment : BaseFragment(R.layout.fragment_paid_bill), BaseAdapter.OnItemClicker {
    override fun initViews() {
        rvPaidBills.adapter = PaidBillAdapter(bills, this)
    }

    var bills = ArrayList<String>()
    override fun attachViewModel() {
    }

    override fun onItemClick(position: Int, data: Any) {

    }
}