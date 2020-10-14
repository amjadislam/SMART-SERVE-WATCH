package com.smartserve.watchapp.Models.Source.ServerConnection


import com.smartserve.watchapp.Models.DataModels.RequestModels.LoginRequestModel.LoginRequestModel
import com.smartserve.watchapp.Models.DataModels.RequestModels.SignUpRequestModel.SignUpRequestModel
import com.smartserve.watchapp.Models.DataModels.ResponseModels.*
import com.smartserve.watchapp.Utils.GeneralUtils.AppConstants.Companion.GET_NOTIFICATION
import com.smartserve.watchapp.Utils.GeneralUtils.AppConstants.Companion.GET_WAITERS
import com.smartserve.watchapp.Utils.GeneralUtils.AppConstants.Companion.PAID_BILLS
import com.smartserve.watchapp.Utils.GeneralUtils.AppConstants.Companion.SIGNIN_API
import com.smartserve.watchapp.Utils.GeneralUtils.AppConstants.Companion.SIGNUP_API
import retrofit2.http.*

@JvmSuppressWildcards
interface ApiService {


    // ====================================== PROFILE APIS =================================


    @POST(SIGNIN_API)
    suspend fun loginUser(
        @Body loginRequestModel: LoginRequestModel
    ): LoginResponseModel


    @POST(SIGNUP_API)
    suspend fun signUpUser(
        @Body signUpRequestModel: SignUpRequestModel
    ): SignupResponseModel


    @GET(GET_NOTIFICATION)
    suspend fun getNotifications(): GetNotificationResponse

    @GET(PAID_BILLS)
    suspend fun getPaidBills(): GetPaidBillResponse

    @GET(GET_WAITERS)
    suspend fun getWaiterList(): GetWaiterListResponse

}