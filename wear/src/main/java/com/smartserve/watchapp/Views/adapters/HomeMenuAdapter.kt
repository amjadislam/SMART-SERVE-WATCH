package com.smartserve.watchapp.Views.adapters

import android.view.View
import com.smartserve.watchapp.Models.DataModels.GeneralModels.UserModel.MenuModel
import com.smartserve.watchapp.R
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.row_main_menu_list.view.*

class HomeMenuAdapter(var menus : ArrayList<MenuModel>,var callback:OnItemClicker) : BaseAdapter(callback,menus,R.layout.row_main_menu_list) {
    override fun View.bind(item: Any) {
        val model = item as MenuModel
        ivMenu.setImageResource(model.image)
        tvMenuTitle.text = model.title

    }
}