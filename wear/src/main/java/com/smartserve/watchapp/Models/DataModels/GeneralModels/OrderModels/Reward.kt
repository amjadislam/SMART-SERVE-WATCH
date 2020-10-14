package com.smartserve.watchapp.Models.DataModels.GeneralModels.OrderModels

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Reward {
    @SerializedName("torder_id")
    @Expose
    var torderId: String? = null

    @SerializedName("treward_id")
    @Expose
    var trewardId: String? = null

    @SerializedName("reTitle")
    @Expose
    var reTitle: String? = null

    @SerializedName("reDescription")
    @Expose
    var reDescription: String? = null

    @SerializedName("miSrc")
    @Expose
    var miSrc: String? = null

    @SerializedName("miDescription")
    @Expose
    var miDescription: String? = null

    @SerializedName("miPrice")
    @Expose
    var miPrice: String? = null
}