package com.smartserve.watchapp.Models.Source.Repository

import com.smartserve.watchapp.Models.DataModels.RequestModels.LoginRequestModel.Device
import com.smartserve.watchapp.Models.DataModels.RequestModels.LoginRequestModel.Devices
import com.smartserve.watchapp.Models.DataModels.RequestModels.LoginRequestModel.LoginRequestModel
import com.smartserve.watchapp.Models.DataModels.RequestModels.LogoutRequestModel.LogoutRequestModel
import com.smartserve.watchapp.Models.DataModels.ResponseModels.*
import com.smartserve.watchapp.Models.DataModels.UtilityModels.BaseResponse
import com.smartserve.watchapp.Models.Source.ServerConnection.RetrofitClientInstance
import com.smartserve.watchapp.Utils.GeneralUtils.AppConstants.Companion.ACTIVITY_NOTIFICATIONS
import com.smartserve.watchapp.Utils.GeneralUtils.AppConstants.Companion.ACTIVITY_PAID_BILLS
import com.smartserve.watchapp.Utils.GeneralUtils.SessionManager

import com.smartserve.watchapp.Utils.NetworkUtils.ResultWrapper
import com.smartserve.watchapp.Utils.NetworkUtils.safeApiCall


class DataRepository(sessionManager: SessionManager, retrofitClientInstance: RetrofitClientInstance) :BaseRepository(sessionManager,retrofitClientInstance) {




    // ====================================== PROFILE APIS =================================

    suspend fun userLogin(
        loginRequestModel: LoginRequestModel
    ): ResultWrapper<LoginResponseModel> {
        return safeApiCall(dispatcher) {
            getApiService().loginUser(loginRequestModel)
        }
    }


    suspend fun userLogout(
        logoutRequestModel: LogoutRequestModel
    ): ResultWrapper<LogoutResponseModel> {
        return safeApiCall(dispatcher) {
            getApiService().logoutUser(logoutRequestModel)
        }
    }

    suspend fun getNotifications(currentDate:String): ResultWrapper<GetNotificationResponse> {
        return safeApiCall(dispatcher) {
            getApiService().getNotifications("",currentDate)
        }
    }

    suspend fun readNotifications(notification_uuid:String): ResultWrapper<BaseResponse> {
        return safeApiCall(dispatcher) {
            getApiService().readNotification(notification_uuid)
        }
    }


    suspend fun getWaiterList(): ResultWrapper<GetWaiterListResponse> {
        return safeApiCall(dispatcher) {
            getApiService().getWaiterList(sessionManager.getRestaurantId())
        }
    }

    suspend fun getPaidBills(currentDate:String): ResultWrapper<GetPaidBillResponse> {
        return safeApiCall(dispatcher) {
            getApiService().getPaidBills("",currentDate)
        }
    }

    suspend fun updateFcmToken(device: Devices): ResultWrapper<BaseResponse> {
        return safeApiCall(dispatcher) {
            getApiService().updateFCMToken(device)
        }
    }

}