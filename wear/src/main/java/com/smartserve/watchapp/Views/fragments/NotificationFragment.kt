package com.smartserve.watchapp.Views.fragments

import com.smartserve.watchapp.R
import com.smartserve.watchapp.Views.adapters.BaseAdapter
import com.smartserve.watchapp.Views.adapters.NotificationAdapter
import kotlinx.android.synthetic.main.fragment_notification.*

class NotificationFragment : BaseFragment(R.layout.fragment_notification),
    BaseAdapter.OnItemClicker {
    override fun initViews() {
        rvNotification.adapter = NotificationAdapter(notifications,this)
    }

    var notifications = ArrayList<String>()
    override fun attachViewModel() {

    }

    override fun onItemClick(position: Int, data: Any) {

    }
}