package com.smartserve.watchapp.Models.DataModels.GeneralModels.OrderModels

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Order {
    @SerializedName("tmenu_id")
    @Expose
    var tmenuId: String? = null

    @SerializedName("mName")
    @Expose
    var mName: String? = null

    @SerializedName("mSrc")
    @Expose
    var mSrc: String? = null

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

    @SerializedName("miPrice")
    @Expose
    var miPrice: String? = null

    @SerializedName("miQuantity")
    @Expose
    var miQuantity: String? = null

    @SerializedName("oDietry")
    @Expose
    private var oDietry: String? = null

    @SerializedName("sidemenu")
    @Expose
    var sides: List<Sides>? = null
    fun getoDietry(): String? {
        return oDietry
    }

    fun setoDietry(oDietry: String?) {
        this.oDietry = oDietry
    }
}