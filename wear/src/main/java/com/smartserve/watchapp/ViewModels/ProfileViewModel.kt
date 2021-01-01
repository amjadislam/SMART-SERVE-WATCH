package com.rapidzz.garageapp.ViewModels


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.smartserve.watchapp.Models.DataModels.GeneralModels.UserModel.UserModel
import com.smartserve.watchapp.Models.DataModels.RequestModels.LoginRequestModel.LoginRequestModel
import com.smartserve.watchapp.Models.DataModels.RequestModels.LogoutRequestModel.LogoutRequestModel
import com.smartserve.watchapp.Models.DataModels.ResponseModels.GetNotificationResponse
import com.smartserve.watchapp.Models.DataModels.ResponseModels.GetPaidBillResponse
import com.smartserve.watchapp.Models.DataModels.ResponseModels.GetWaiterListResponse
import com.smartserve.watchapp.Models.DataModels.ResponseModels.LogoutResponseModel
import com.smartserve.watchapp.Models.Source.Repository.DataRepository
import com.smartserve.watchapp.Utils.GeneralUtils.OneShotEvent
import com.smartserve.watchapp.Utils.NetworkUtils.ResultWrapper
import com.smartserve.watchapp.ViewModels.BaseAndroidViewModel
import kotlinx.coroutines.launch


class ProfileViewModel(private val dataRepository: DataRepository) : BaseAndroidViewModel() {


    var userLiveData: MutableLiveData<OneShotEvent<UserModel>> = MutableLiveData()
    var userLogoutLiveData: MutableLiveData<OneShotEvent<LogoutResponseModel>> = MutableLiveData()



    fun loginUser(loginRequestModel: LoginRequestModel) {
        showProgressBar(true)
        viewModelScope.launch {
            dataRepository.userLogin(loginRequestModel)?.let { response ->
                showProgressBar(false)
                when (response) {
                    is ResultWrapper.Success ->
                        if (isSuccess(response.value)) {
                            userLiveData.value = OneShotEvent(response.value.data)
                        }
                    else -> handleErrorType(response)
                }
            }

        }

    }


    fun logoutUser(logoutRequestModel: LogoutRequestModel) {
        showProgressBar(true)
        viewModelScope.launch {
            dataRepository.userLogout(logoutRequestModel)?.let { response ->
                showProgressBar(false)
                when (response) {
                    is ResultWrapper.Success ->
                        if (isSuccess(response.value)) {
                            userLogoutLiveData.value = OneShotEvent(response.value)
                        }
                    else -> handleErrorType(response)
                }
            }

        }

    }




}