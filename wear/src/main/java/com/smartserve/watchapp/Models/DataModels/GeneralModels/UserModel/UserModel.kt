package com.smartserve.watchapp.Models.DataModels.GeneralModels.UserModel

data class UserModel(
    val access_token: String,
    val activated_at: String,
    val avatar_src: String,
    val bank_details: BankDetails,
    val biometric_enabled: Int,
    val devices: List<Device>,
    val email: String,
    val favourites: List<Any>,
    val last_active_at: String,
    val loyalty_points: List<Any>,
    val mobile_number: String,
    val name: String,
    val notification_enabled: Int,
    val profile: Profile,
    val sign_in_count: Int,
    val unique_code: String,
    val user_status: String,
    val uuid: String
)