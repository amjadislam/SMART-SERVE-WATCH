package com.rapidzz.garageapp.ViewModels


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.smartserve.watchapp.Models.DataModels.GeneralModels.UserModel.UserModel
import com.smartserve.watchapp.Models.DataModels.RequestModels.LoginRequestModel.LoginRequestModel
import com.smartserve.watchapp.Models.DataModels.RequestModels.SignUpRequestModel.SignUpRequestModel
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
    var updatePasswordLiveData: MutableLiveData<OneShotEvent<BaseResponse>> = MutableLiveData()
    var changePasswordLiveData: MutableLiveData<OneShotEvent<Boolean>> = MutableLiveData()
    var userLogoutLiveData: MutableLiveData<OneShotEvent<Boolean>> = MutableLiveData()



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


    fun signupUser( signUpRequestModel: SignUpRequestModel) {
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


//    fun forgotPassword(email: String) {
//        showProgressBar(true)
//        viewModelScope.launch {
//            dataRepositery.forgotPassword(email)?.let { response ->
//                showProgressBar(false)
//                when (response) {
//                    is ResultWrapper.Success ->
//                        if (isSuccess(response.value)) {
//                            forgotPassLiveData.value = OneShotEvent(true)
//                        }
//                    else -> handleErrorType(response)
//                }
//            }
//
//        }
//
//    }
//
//
//    fun verifyPinCode(email: String,code:String) {
//        showProgressBar(true)
//        viewModelScope.launch {
//            dataRepositery.verifyCode(email,code)?.let { response ->
//                showProgressBar(false)
//                when (response) {
//                    is ResultWrapper.Success ->
//                        if (isSuccess(response.value)) {
//                            verifyCodeLiveData.value = OneShotEvent(true)
//                        }
//                    else -> handleErrorType(response)
//                }
//            }
//
//        }
//
//    }
//
//
//    fun updatePassword(email: String,newPassword:String) {
//        showProgressBar(true)
//        viewModelScope.launch {
//            dataRepositery.updatePassword(email,newPassword)?.let { response ->
//                showProgressBar(false)
//                when (response) {
//                    is ResultWrapper.Success ->
//                        if (isSuccess(response.value)) {
//                            updatePasswordLiveData.value = OneShotEvent(response.value)
//                        }
//                    else -> handleErrorType(response)
//                }
//            }
//
//        }
//
//    }
//
//
//    fun changePassword(oldPassword: String,newPassword:String) {
//        showProgressBar(true)
//        viewModelScope.launch {
//            dataRepositery.changePassword(oldPassword,newPassword)?.let { response ->
//                showProgressBar(false)
//                when (response) {
//                    is ResultWrapper.Success ->
//                        if (isSuccess(response.value)) {
//                            changePasswordLiveData.value = OneShotEvent(true)
//                        }
//                    else -> handleErrorType(response)
//                }
//            }
//
//        }
//
//    }
//
//
//    fun getProfile() {
//        showProgressBar(true)
//        viewModelScope.launch {
//            dataRepositery.getProfile()?.let { response ->
//                showProgressBar(false)
//                when (response) {
//                    is ResultWrapper.Success ->
//                        if (isSuccess(response.value)) {
//                            userLiveData.value = OneShotEvent(response.value.data)
//                        }
//                    else -> handleErrorType(response)
//                }
//            }
//
//        }
//
//    }
//
//
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