package com.smartserve.watchapp.Models.DataModels.GeneralModels.WaiterModels

data class WaiterRestModel(
    val title: String,
    val uuid: String,
    val wait_staff: List<WaitStaff>
)