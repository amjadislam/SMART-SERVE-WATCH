package com.smartserve.watchapp.Views.adapters

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.view.View
import com.smartserve.watchapp.Models.DataModels.GeneralModels.UserModel.MenuModel
import com.smartserve.watchapp.R
import kotlinx.android.synthetic.main.row_main_menu_list.view.*


class HomeMenuAdapter(
    var menus: ArrayList<MenuModel>,
    var callback: OnItemClicker,
    var selectedPosition: Int
) : BaseAdapter(callback, menus, R.layout.row_main_menu_list) {
    @SuppressLint("ResourceType")
    override fun View.bind(item: Any, position: Int) {
        val model = item as MenuModel
        ivMenu.setImageResource(model.image)
        tvMenuTitle.text = model.title
    }

}