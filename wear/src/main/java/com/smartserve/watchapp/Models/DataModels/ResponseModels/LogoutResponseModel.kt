package com.smartserve.watchapp.Models.DataModels.ResponseModels


import com.smartserve.watchapp.Models.DataModels.GeneralModels.UserModel.UserModel
import com.smartserve.watchapp.Models.DataModels.UtilityModels.BaseResponse
import java.io.Serializable

data class LogoutResponseModel(

    val data: Boolean
) : BaseResponse(), Serializable