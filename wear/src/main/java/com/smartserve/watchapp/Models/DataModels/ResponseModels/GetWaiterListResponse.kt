package com.smartserve.watchapp.Models.DataModels.ResponseModels

import com.smartserve.watchapp.Models.DataModels.GeneralModels.WaiterModels.WaiterRestModel
import com.smartserve.watchapp.Models.DataModels.UtilityModels.BaseResponse
import java.io.Serializable

class GetWaiterListResponse (
    val data:ArrayList<WaiterRestModel>
):Serializable,BaseResponse()