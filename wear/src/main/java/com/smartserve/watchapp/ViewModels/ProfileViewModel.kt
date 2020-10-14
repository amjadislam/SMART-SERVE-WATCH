package com.rapidzz.garageapp.ViewModels


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.smartserve.watchapp.Models.DataModels.GeneralModels.UserModel.UserModel
import com.smartserve.watchapp.Models.DataModels.RequestModels.LoginRequestModel.LoginRequestModel
import com.smartserve.watchapp.Models.DataModels.RequestModels.SignUpRequestModel.SignUpRequestModel
import com.smartserve.watchapp.Models.DataModels.ResponseModels.GetNotificationResponse
import com.smartserve.watchapp.Models.DataModels.ResponseModels.GetPaidBillResponse
import com.smartserve.watchapp.Models.DataModels.ResponseModels.GetWaiterListResponse
import com.smartserve.watchapp.Models.DataModels.UtilityModels.BaseResponse
import com.smartserve.watchapp.Models.Source.Repository.DataRepository
import com.smartserve.watchapp.Utils.GeneralUtils.OneShotEvent
import com.smartserve.watchapp.Utils.NetworkUtils.ResultWrapper
import com.smartserve.watchapp.ViewModels.BaseAndroidViewModel
import kotlinx.coroutines.launch


class ProfileViewModel(private val dataRepository: DataRepository) : BaseAndroidViewModel() {


    var userLiveData: MutableLiveData<OneShotEvent<UserModel>> = MutableLiveData()
    var forgotPassLiveData: MutableLiveData<OneShotEvent<Boolean>> = MutableLiveData()
    var verifyCodeLiveData: MutableLiveData<OneShotEvent<Boolean>> = MutableLiveData()
    var getNotificationResponse: MutableLiveData<OneShotEvent<GetNotificationResponse>> =
        MutableLiveData()
    var getPaidBillsResponse: MutableLiveData<OneShotEvent<GetPaidBillResponse>> = MutableLiveData()
    var getWaiterResponse: MutableLiveData<OneShotEvent<GetWaiterListResponse>> = MutableLiveData()


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


    fun signupUser(signUpRequestModel: SignUpRequestModel) {
        showProgressBar(true)
        viewModelScope.launch {
            dataRepository.userSignUp(signUpRequestModel)?.let { response ->
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


    fun getNotifications() {
        showProgressBar(true)
        viewModelScope.launch {
            dataRepository.getNotifications()?.let { response ->
                showProgressBar(false)
                when (response) {
                    is ResultWrapper.Success ->
                        if (isSuccess(response.value)) {
                            getNotificationResponse.value = OneShotEvent(response.value)
                        }
                    else -> handleErrorType(response)
                }
            }
        }
    }

    fun getWaiters() {
        showProgressBar(true)
        viewModelScope.launch {
            dataRepository.getWaiterList()?.let { response ->
                showProgressBar(false)
                when (response) {
                    is ResultWrapper.Success ->
                        if (isSuccess(response.value)) {
                            getWaiterResponse.value = OneShotEvent(response.value)
                        }
                    else -> handleErrorType(response)
                }
            }
        }
    }

    fun getPaidBills() {
        showProgressBar(true)
        viewModelScope.launch {
            dataRepository.getPaidBills()?.let { response ->
                showProgressBar(false)
                when (response) {
                    is ResultWrapper.Success ->
                        if (isSuccess(response.value)) {
                            getPaidBillsResponse.value = OneShotEvent(response.value)
                        }
                    else -> handleErrorType(response)
                }
            }
        }
    }


}