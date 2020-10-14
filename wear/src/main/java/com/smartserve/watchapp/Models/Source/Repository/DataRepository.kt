package com.smartserve.watchapp.Models.Source.Repository

import android.content.Context
import com.smartserve.watchapp.Models.DataModels.RequestModels.LoginRequestModel.LoginRequestModel
import com.smartserve.watchapp.Models.DataModels.RequestModels.SignUpRequestModel.SignUpRequestModel
import com.smartserve.watchapp.Models.DataModels.ResponseModels.*

import com.smartserve.watchapp.Utils.NetworkUtils.ResultWrapper
import com.smartserve.watchapp.Utils.NetworkUtils.safeApiCall


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
            getApiService().signUpUser(signUpRequestModel)
        }
    }

    suspend fun getNotifications(): ResultWrapper<GetNotificationResponse> {
        return safeApiCall(dispatcher) {
            getApiService().getNotifications()
        }
    }

    suspend fun getWaiterList(): ResultWrapper<GetWaiterListResponse> {
        return safeApiCall(dispatcher) {
            getApiService().getWaiterList()
        }
    }

    suspend fun getPaidBills(): ResultWrapper<GetPaidBillResponse> {
        return safeApiCall(dispatcher) {
            getApiService().getPaidBills()
        }
    }


}