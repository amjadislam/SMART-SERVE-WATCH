package com.smartserve.watchapp.Models.DataModels.RequestModels.LoginRequestModel

data class LoginRequestModel(
    val devices: Device,
    val pin: String
)