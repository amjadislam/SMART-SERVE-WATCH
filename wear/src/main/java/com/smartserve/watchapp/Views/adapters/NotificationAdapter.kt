package com.smartserve.watchapp.Views.adapters

import android.view.View
import com.smartserve.watchapp.Models.DataModels.GeneralModels.NotificationItem
import com.smartserve.watchapp.R
import kotlinx.android.synthetic.main.waiter_message_list_item.view.*

class NotificationAdapter(var data: ArrayList<NotificationItem>, var callback: OnItemClicker) :
    BaseAdapter(callback, data, R.layout.waiter_message_list_item) {
    override fun View.bind(item: Any) {
        val data=item as NotificationItem
        this.tvTableName.text="Table # "+data.table_name
        this.tvMessage.text=data.message
        this.tvTitle.text=data.created_at
        this.rlRootView.setOnClickListener {
            callback.onItemClick(0,data)
        }
    }
}