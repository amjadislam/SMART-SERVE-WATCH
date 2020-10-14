package com.smartserve.watchapp.Models.DataModels.RequestModels.SignUpRequestModel

data class Devices(
    val device: String,
    val token: String,
    val udid: String
)