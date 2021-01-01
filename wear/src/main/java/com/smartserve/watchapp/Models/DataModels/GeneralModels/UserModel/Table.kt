package com.smartserve.watchapp.Models.DataModels.GeneralModels.UserModel

data class Table(
    val area: String,
    val capacity: String,
    val floor: String,
    val has_quick_service: Int,
    val qr_code: String,
    val status: String,
    val table_name: String,
    val uuid: String
)