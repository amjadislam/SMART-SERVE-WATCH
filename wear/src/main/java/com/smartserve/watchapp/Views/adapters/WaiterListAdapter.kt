package com.smartserve.watchapp.Views.adapters

import android.view.View
import com.smartserve.watchapp.Models.DataModels.GeneralModels.WaiterModels.WaitStaff
import com.smartserve.watchapp.R
import com.smartserve.watchapp.Utils.Application.gone
import com.smartserve.watchapp.Utils.Application.visible
import kotlinx.android.synthetic.main.waiter_list_item.view.*

class WaiterListAdapter(var data: ArrayList<WaitStaff>, var callback: OnItemClicker) :
    BaseAdapter(callback, data, R.layout.waiter_list_item) {
    override fun View.bind(item: Any, position: Int) {
        if( data.size  == 1){
            this.viewLine.gone()
        }else if(position == data.size -1){
            this.viewLine.gone()
        }else{
            this.viewLine.visible()
        }
        val data = item as WaitStaff
        tvItem.text = data.name
    }
}