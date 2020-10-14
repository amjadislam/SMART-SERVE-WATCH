package com.smartserve.watchapp.Views.adapters

import android.view.View
import com.smartserve.watchapp.R

class PaidBillAdapter(var data: ArrayList<String>, var callback: OnItemClicker) :
    BaseAdapter(callback, data, R.layout.waiter_message_list_item) {
    override fun View.bind(item: Any) {

    }
}