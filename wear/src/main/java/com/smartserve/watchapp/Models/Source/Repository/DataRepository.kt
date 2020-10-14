package com.smartserve.watchapp.Models.Source.Repository

import android.content.Context
import com.rapidzz.garageapp.ViewModels.ProfileViewModel
import com.smartserve.watchapp.Models.DataModels.RequestModels.LoginRequestModel.LoginRequestModel
import com.smartserve.watchapp.Models.DataModels.RequestModels.SignUpRequestModel.SignUpRequestModel
import com.smartserve.watchapp.Models.DataModels.ResponceModels.*

import com.smartserve.watchapp.Utils.NetworkUtils.ResultWrapper
import com.smartserve.watchapp.Utils.NetworkUtils.safeApiCall
import org.koin.dsl.koinApplication
import org.koin.dsl.module


class DataRepository(context: Context) :BaseRepository(context) {




    // ====================================== PROFILE APIS =================================

    suspend fun userLogin(
        loginRequestModel: LoginRequestModel
    ): ResultWrapper<LoginResponseModel> {
        return safeApiCall(dispatcher) {
            getApiService().loginUser(loginRequestModel)
        }
    }


    suspend fun userSignUp(
        signUpRequestModel: SignUpRequestModel
    ): ResultWrapper<SignupResponseModel> {
        return safeApiCall(dispatcher) {
            getApiService().signUpUser(
               signUpRequestModel
            )
        }
    }


//    suspend fun logoutUser(): ResultWrapper<BaseResponse> {
//        return safeApiCall(dispatcher) {
//            getApiService().userLogout(GeneralIdRequest(userId))
//        }
//    }
//
//
//    suspend fun forgotPassword(
//        email: String
//    ): ResultWrapper<BaseResponse> {
//        return safeApiCall(dispatcher) {
//            getApiService().forgotPassword(ForgotPasswordRequest(email))
//        }
//    }

//
//    suspend fun updatePassword(
//        email: String,
//        password: String
//    ): ResultWrapper<BaseResponse> {
//        return safeApiCall(dispatcher) {
//            getApiService().updatePassword(UpdatePasswordRequest(email, password))
//        }
//    }
//
//
//    suspend fun changePassword(
//        currentPassword: String,
//        newPassword: String
//    ): ResultWrapper<BaseResponse> {
//        return safeApiCall(dispatcher) {
//            getApiService().changePassword(
//                ChangePasswordRequest(
//                    userId,
//                    currentPassword,
//                    newPassword
//                )
//            )
//        }
//    }
//
//
//    suspend fun updateFCMToken(
//        token: String
//    ): ResultWrapper<BaseResponse> {
//        return safeApiCall(dispatcher) {
//            getApiService().updateFCMToken(UpdateFcmRequest(userId, token))
//        }
//    }
//
//
//    suspend fun getProfile(
//    ): ResultWrapper<LoginResponse> {
//        return safeApiCall(dispatcher) {
//            getApiService().getProfile(GeneralGarageIdRequest(userId))
//        }
//    }





}