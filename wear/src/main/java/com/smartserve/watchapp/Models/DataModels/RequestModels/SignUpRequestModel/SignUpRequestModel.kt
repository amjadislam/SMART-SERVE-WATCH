package com.smartserve.watchapp.Models.DataModels.RequestModels.SignUpRequestModel

data class SignUpRequestModel(
    val devices: Devices,
    val email: String,
    val mobile_number: String,
    val name: String,
    val password: String
)