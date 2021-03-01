package com.smartserve.watchapp.Views.adapters

import android.view.View
import com.smartserve.watchapp.Models.DataModels.GeneralModels.NotificationItem
import com.smartserve.watchapp.R
import com.smartserve.watchapp.Utils.Application.dateToFullMothName
import com.smartserve.watchapp.Utils.GeneralUtils.DateTimeUtils
import kotlinx.android.synthetic.main.waiter_message_list_item.view.*

class PaidBillAdapter(var data: ArrayList<NotificationItem>, var callback: OnItemClicker) :
    BaseAdapter(callback, data, R.layout.waiter_message_list_item) {
    var dateTimeUnit : DateTimeUtils? = null
    override fun View.bind(item: Any, position: Int) {
        val data=item as NotificationItem
        dateTimeUnit =  DateTimeUtils()
        this.tvTableName.text="Table # "+data.table_name
        var date = data.created_at.substring(0,10)
        var time = data.created_at.substring(11,20)
        var formattedDate = data.created_at.dateToFullMothName()
        this.tvMessage.text=data.message
        this.tvTitle.text=formattedDate
    }
}