package com.smartserve.watchapp.Models.Source.ServerConnection


import com.smartserve.watchapp.Models.DataModels.RequestModels.LoginRequestModel.LoginRequestModel
import com.smartserve.watchapp.Models.DataModels.RequestModels.SignUpRequestModel.SignUpRequestModel
import com.smartserve.watchapp.Models.DataModels.ResponceModels.*
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

//
//    @POST(LOGOUT_API)
//    suspend fun userLogout(
//        @Body generalIdRequest: GeneralIdRequest
//    ): BaseResponse
//
//
//    @POST(CHANGE_PASSWORD)
//    suspend fun changePassword(
//        @Body changePasswordRequest: ChangePasswordRequest
//    ): BaseResponse
//
//
//    @POST(FORGOT_PASSWORD)
//    suspend fun forgotPassword(
//        @Body forgotPasswordRequest: ForgotPasswordRequest
//    ): BaseResponse
//
//
//    @POST(VERIFY_CODE)
//    suspend fun verifyCode(
//        @Body verifyCodeRequest: VerifyCodeRequest
//    ): BaseResponse
//
//
//    @POST(UPDATE_PASSWORD)
//    suspend fun updatePassword(
//        @Body updatePasswordRequest: UpdatePasswordRequest
//    ): BaseResponse
//
//
//    @POST(GET_PROFILE)
//    suspend fun getProfile(
//        @Body generalGarageIdRequest: GeneralGarageIdRequest
//    ): LoginResponse
//
//
//    @POST(UPDATE_PROFILE)
//    suspend fun updateProfile(
//        @Field("first_name") first_name: String,
//        @Field("last_name") last_name: String,
//        @Field("name") name: String,
//        @Field("email") email: String,
//        @Field("phone") phone: String,
//        @Field("password") password: String,
//        @Field("fcm_token") fcm_token: String,
//        @Field("user_type") user_type: String,
//        @Field("cnic") cnic: String,
//        @Field("address") address: String,
//        @Field("city") city: String,
//        @Field("country") country: String,
//        @Field("lat") lat: String,
//        @Field("lng") lng: String
//    ): LoginResponse
//
//
//    @POST(UPDATE_FCM)
//    suspend fun updateFCMToken(
//        @Body updateFcmRequest: UpdateFcmRequest
//    ): BaseResponse


}