package com.smartserve.watchapp.Models.DataModels.GeneralModels

data class NotificationItem(
    val activity_type: String,
    val created_at: String,
    val id: String,
    val message: String,
    val order_uuid: String,
    val read: Boolean,
    val read_at: Any,
    val restaurant_uuid: String,
    val table_name: String,
    val table_uuid: String,
    val time: Int,
    val type: String,
    val user_uuid: String
)