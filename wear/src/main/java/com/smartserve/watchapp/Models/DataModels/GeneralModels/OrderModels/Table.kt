package com.smartserve.watchapp.Models.DataModels.GeneralModels.OrderModels

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

class Table {
    @SerializedName("ttable_id")
    @Expose
    var ttableId: String? = null

    @SerializedName("tName")
    @Expose
    var tName: String? = null
        get() = if (displayName != null && !displayName.equals(
                "null",
                ignoreCase = true
            ) && displayName!!.trim { it <= ' ' }.length > 0
        ) {
            displayName
        } else {
            field
        }

    @SerializedName("display_name")
    @Expose
    var displayName: String? = null

    @SerializedName("tCapacity")
    @Expose
    var tCapacity: String? = null

    @SerializedName("waiter_id")
    @Expose
    var waiterId: String? = null

    @SerializedName("waiterArray")
    @Expose
    var waiters: ArrayList<WaiterModel>? = null
}