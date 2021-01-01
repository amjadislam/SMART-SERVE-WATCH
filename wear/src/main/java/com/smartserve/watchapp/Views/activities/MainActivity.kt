package com.smartserve.watchapp.Views.activities

import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import android.widget.ImageView
import androidx.navigation.NavController
import com.rapidzz.garageapp.ViewModels.ProfileViewModel
import com.smartserve.watchapp.R
import com.smartserve.watchapp.Views.adapters.BaseAdapter
import com.smartserve.watchapp.Views.dialog.ConfirmationDialog

class MainActivity : BaseActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration





    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }





    override fun initViews() {
    }





}
