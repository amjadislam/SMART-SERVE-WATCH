package com.smartserve.watchapp.Views.adapters

import android.view.View
import com.smartserve.watchapp.Models.DataModels.GeneralModels.WaiterModels.WaitStaff
import com.smartserve.watchapp.R
import kotlinx.android.synthetic.main.waiter_list_item.view.*

class WaiterListAdapter(var data: ArrayList<WaitStaff>, var callback: OnItemClicker) :
    BaseAdapter(callback, data, R.layout.waiter_list_item) {
    override fun View.bind(item: Any) {
        val data = item as WaitStaff
        tvItem.text = data.name
    }
}