package com.smartserve.watchapp.Models.DataModels.GeneralModels.OrderModels

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Sides {
    @SerializedName("extra_id")
    @Expose
    var extraId: String? = null

    @SerializedName("item_type")
    @Expose
    var itemType: String? = null

    @SerializedName("title")
    @Expose
    var title: String? = null

    @SerializedName("price")
    @Expose
    var price: String? = null

    @SerializedName("description")
    @Expose
    var description: String? = null

    @SerializedName("tmitem_id")
    @Expose
    var tmitemId: String? = null

    @SerializedName("miName")
    @Expose
    var miName: String? = null

    @SerializedName("miSrc")
    @Expose
    var miSrc: String? = null

    @SerializedName("miDescription")
    @Expose
    var miDescription: String? = null
}