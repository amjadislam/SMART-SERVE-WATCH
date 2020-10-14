package com.smartserve.watchapp.Models.DataModels.GeneralModels.OrderModels

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class WaiterModel {
    @SerializedName("waiter_id")
    @Expose
    var waiterId: String? = null

    @SerializedName("waiter_name")
    @Expose
    var waiterName: String? = null

    @SerializedName("waiter_email")
    @Expose
    var waiterEmail: String? = null
}