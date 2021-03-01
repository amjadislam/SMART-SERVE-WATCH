package com.smartserve.watchapp.Views.activities

import android.util.Log
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import android.widget.ImageView
import androidx.navigation.NavController
import com.google.firebase.iid.FirebaseInstanceId
import com.rapidzz.garageapp.ViewModels.ProfileViewModel
import com.smartserve.watchapp.Models.DataModels.RequestModels.LoginRequestModel.Device
import com.smartserve.watchapp.Models.DataModels.RequestModels.LoginRequestModel.Devices
import com.smartserve.watchapp.Models.Source.Repository.DataRepository
import com.smartserve.watchapp.Models.Source.ServerConnection.RetrofitClientInstance
import com.smartserve.watchapp.R
import com.smartserve.watchapp.Utils.Application.getUniqueAndroidId
import com.smartserve.watchapp.Utils.GeneralUtils.AppConstants
import com.smartserve.watchapp.Views.adapters.BaseAdapter
import com.smartserve.watchapp.Views.dialog.ConfirmationDialog
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : BaseActivity() {


    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }


    override fun initViews() {
        updateToken()
    }


    private fun updateToken()
    {
        FirebaseInstanceId.getInstance().instanceId.addOnCompleteListener {
            if(it.isSuccessful)
            {
                val token=it.result.token
                sessionManager.setFCMToken(it.result.token)
                Log.d("token", token)
                GlobalScope.launch {
                    DataRepository(sessionManager, RetrofitClientInstance(this@MainActivity)).updateFcmToken(
                        Devices(Device(AppConstants.DEVICE_TYPE, token, this@MainActivity.getUniqueAndroidId())))
                }
            }
        }
    }


}
