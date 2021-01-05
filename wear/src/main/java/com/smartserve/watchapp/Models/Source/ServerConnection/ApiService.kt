package com.smartserve.watchapp.Models.Source.ServerConnection


import com.smartserve.watchapp.Models.DataModels.RequestModels.LoginRequestModel.Device
import com.smartserve.watchapp.Models.DataModels.RequestModels.LoginRequestModel.LoginRequestModel
import com.smartserve.watchapp.Models.DataModels.RequestModels.LogoutRequestModel.LogoutRequestModel
import com.smartserve.watchapp.Models.DataModels.ResponseModels.*
import com.smartserve.watchapp.Models.DataModels.UtilityModels.BaseResponse
import com.smartserve.watchapp.Utils.GeneralUtils.AppConstants.Companion.GET_NOTIFICATION
import com.smartserve.watchapp.Utils.GeneralUtils.AppConstants.Companion.GET_WAITERS
import com.smartserve.watchapp.Utils.GeneralUtils.AppConstants.Companion.LOGOUT_API
import com.smartserve.watchapp.Utils.GeneralUtils.AppConstants.Companion.PAID_BILLS
import com.smartserve.watchapp.Utils.GeneralUtils.AppConstants.Companion.SIGNIN_API
import com.smartserve.watchapp.Utils.GeneralUtils.AppConstants.Companion.UPDATE_FCM_TOKEN
import retrofit2.http.*

@JvmSuppressWildcards
interface ApiService {


    // ====================================== PROFILE APIS =================================


    @POST(SIGNIN_API)
    suspend fun loginUser(
        @Body loginRequestModel: LoginRequestModel
    ): LoginResponseModel


    @POST(LOGOUT_API)
    suspend fun logoutUser(
        @Body logoutRequestModel: LogoutRequestModel
    ): LogoutResponseModel


    @GET(GET_NOTIFICATION)
    suspend fun getNotifications(
        @Query("activity_type") activity_type: String,
        @Query("current_date") current_date: String
    ): GetNotificationResponse

    @GET(PAID_BILLS)
    suspend fun getPaidBills(
        @Query("activity_type") activity_type: String,
        @Query("current_date") current_date: String
    ): GetPaidBillResponse

    @GET(GET_WAITERS)
    suspend fun getWaiterList(@Path("rest_uuid") rest_uuid: String): GetWaiterListResponse

    @POST(UPDATE_FCM_TOKEN)
    suspend fun updateFCMToken(
        @Body device: Device
    ): BaseResponse
}