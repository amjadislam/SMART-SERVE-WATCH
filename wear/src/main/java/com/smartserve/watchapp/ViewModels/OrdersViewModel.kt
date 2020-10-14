package com.rapidzz.garageapp.ViewModels


import androidx.lifecycle.MutableLiveData
import com.smartserve.watchapp.Models.Source.Repository.DataRepository
import com.smartserve.watchapp.Utils.GeneralUtils.OneShotEvent
import com.smartserve.watchapp.ViewModels.BaseAndroidViewModel


class OrdersViewModel(private val dataRepositery: DataRepository) :
    BaseAndroidViewModel() {


    var userLogoutLiveData: MutableLiveData<OneShotEvent<Boolean>> = MutableLiveData()








//    fun userLogout() {
//        showProgressBar(true)
//        viewModelScope.launch {
//            dataRepositery.logoutUser()?.let { response ->
//                showProgressBar(false)
//                when (response) {
//                    is ResultWrapper.Success ->
//                        if (isSuccess(response.value)) {
//                            userLogoutLiveData.value = OneShotEvent(true)
//                        }
//                    else -> handleErrorType(response)
//                }
//            }
//
//        }
//
//    }




}