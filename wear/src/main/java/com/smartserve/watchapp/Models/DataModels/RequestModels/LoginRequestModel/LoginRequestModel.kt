package com.smartserve.watchapp.Models.DataModels.RequestModels.LoginRequestModel

data class LoginRequestModel(
    val device: Device,
    val email: String,
    val password: String
)