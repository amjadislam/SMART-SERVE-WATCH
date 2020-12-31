package com.smartserve.watchapp.Views.activities

import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import android.widget.ImageView
import androidx.navigation.NavController
import com.rapidzz.garageapp.ViewModels.ProfileViewModel
import com.smartserve.watchapp.Models.DataModels.RequestModels.LoginRequestModel.Device
import com.smartserve.watchapp.Models.DataModels.RequestModels.LoginRequestModel.LoginRequestModel
import com.smartserve.watchapp.R
import com.smartserve.watchapp.Utils.Application.getString
import com.smartserve.watchapp.Utils.Application.getUniqueAndroidId
import com.smartserve.watchapp.Utils.Application.showAlertDialog
import com.smartserve.watchapp.Utils.Application.showToast
import com.smartserve.watchapp.Utils.GeneralUtils.AppConstants
import com.smartserve.watchapp.Views.adapters.BaseAdapter
import com.smartserve.watchapp.Views.dialog.ConfirmationDialog
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.android.viewmodel.ext.android.viewModel

class LoginActivity : BaseActivity() {


    override fun getLayoutId(): Int {
        return R.layout.activity_registration_flow
    }


    override fun initViews() {

    }


}
