package com.smartserve.watchapp.Models.DataModels.ResponseModels

import com.smartserve.watchapp.Models.DataModels.GeneralModels.NotificationItem
import com.smartserve.watchapp.Models.DataModels.UtilityModels.BaseResponse
import java.io.Serializable

class GetNotificationResponse (
    val data:ArrayList<NotificationItem>
):Serializable,BaseResponse()