package com.smartserve.watchapp.Models.DataModels.UtilityModels

import java.io.Serializable

open class BaseResponse(val status: Int = 0,
                        var message: String = "") : Serializable {

}