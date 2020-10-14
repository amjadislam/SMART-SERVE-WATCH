package com.smartserve.watchapp.Models.DataModels.RequestModels.LoginRequestModel

data class Device(
    val device: String,
    val token: String,
    val udid: String
)