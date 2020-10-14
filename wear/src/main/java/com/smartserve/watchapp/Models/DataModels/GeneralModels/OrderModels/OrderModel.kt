package com.smartserve.watchapp.Models.DataModels.GeneralModels.OrderModels

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class OrderModel {
    @SerializedName("tuser_id")
    @Expose
    var tuserId: String? = null

    @SerializedName("uName")
    @Expose
    var uName: String? = null

    @SerializedName("uEmail")
    @Expose
    var uEmail: String? = null

    @SerializedName("uContact")
    @Expose
    var uContact: String? = null

    @SerializedName("uSrc")
    @Expose
    var uSrc: String? = null

    @SerializedName("trestaurant_id")
    @Expose
    var trestaurantId: String? = null

    @SerializedName("rTitle")
    @Expose
    var rTitle: String? = null

    @SerializedName("cover")
    @Expose
    var cover: String? = null

    @SerializedName("rSrc")
    @Expose
    var rSrc: String? = null

    @SerializedName("rDescription")
    @Expose
    var rDescription: String? = null

    @SerializedName("rAddress")
    @Expose
    var rAddress: String? = null

    @SerializedName("rLatitude")
    @Expose
    var rLatitude: String? = null

    @SerializedName("rLongitude")
    @Expose
    var rLongitude: String? = null

    @SerializedName("rVAT")
    @Expose
    var rVAT: String? = null

    @SerializedName("rVPer")
    @Expose
    var rVPer: String? = null

    @SerializedName("oVPrice")
    @Expose
    var oVPrice: String? = null

    @SerializedName("reward")
    @Expose
    var reward: List<Reward>? = null

    @SerializedName("ttable_id")
    @Expose
    var tableId: String? = null

    @SerializedName("tloyalty_id")
    @Expose
    var tloyaltyId: String? = null

    @SerializedName("lPoint")
    @Expose
    var lPoint: String? = null

    @SerializedName("torder_id")
    @Expose
    var torderId: String? = null

    @SerializedName("oType")
    @Expose
    var oType: String? = null

    @SerializedName("oPMode")
    @Expose
    var oPMode: String? = null

    @SerializedName("oTAmount")
    @Expose
    var oTAmount: String? = null

    @SerializedName("oStatus")
    @Expose
    var oStatus: String? = null

    @SerializedName("oDateAdded")
    @Expose
    var oDateAdded: String? = null

    @SerializedName("currentDateTime")
    @Expose
    var currentDate: String? = null

    @SerializedName("isFavourite")
    @Expose
    var isFavourite: Int? = null

    @SerializedName("order")
    @Expose
    var order: List<Order>? = null

    @SerializedName("orderId")
    @Expose
    var orderId: String? = null

    @SerializedName("table")
    @Expose
    var table: Table? = null
}