package com.smartserve.watchapp.Models.DataSource

import com.smartserve.watchapp.Models.DataModels.UtilityModels.ApiErrorResponse


interface BaseDataSource {
    fun onPayloadError(error: ApiErrorResponse)
}
