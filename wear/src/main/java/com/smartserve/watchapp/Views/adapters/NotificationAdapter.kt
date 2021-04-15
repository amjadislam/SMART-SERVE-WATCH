package com.smartserve.watchapp.Views.adapters

import android.view.View
import com.smartserve.watchapp.Models.DataModels.GeneralModels.NotificationItem
import com.smartserve.watchapp.R
import com.smartserve.watchapp.Utils.Application.dateToFullMothName
import com.smartserve.watchapp.Utils.GeneralUtils.DateTimeUtils
import kotlinx.android.synthetic.main.waiter_message_list_item.view.*
import java.util.*

class NotificationAdapter(var data: ArrayList<NotificationItem>, var callback: OnItemClicker) :
    BaseAdapter(callback, data, R.layout.waiter_message_list_item) {
    var dateTimeUnit: DateTimeUtils? = null
    override fun View.bind(item: Any, position: Int) {
        val data = item as NotificationItem
        dateTimeUnit = DateTimeUtils()
        this.tvTableName.text = "Table # " + data.table_name
        this.tvMessage.text = data.message
        var formattedDate = data.created_at.dateToFullMothName()
        this.tvTitle.text=data.date_time
        this.rlRootView.setOnClickListener {
            callback.onItemClick(0, data)
        }
    }


}