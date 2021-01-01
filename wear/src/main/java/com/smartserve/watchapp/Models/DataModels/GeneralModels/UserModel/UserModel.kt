package com.smartserve.watchapp.Models.DataModels.GeneralModels.UserModel

data class UserModel(
    val access_token: String,
    val avatar_src: String,
    val email: String,
    val mobile_number: String,
    val name: String,
    val restaurant: Restaurant,
    val sign_in_count: Int,
    val staff_role: String,
    val tables: List<Table>,
    val uuid: String
)