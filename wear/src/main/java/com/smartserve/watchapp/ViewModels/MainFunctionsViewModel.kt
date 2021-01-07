package com.rapidzz.garageapp.ViewModels


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.smartserve.watchapp.Models.DataModels.ResponseModels.GetNotificationResponse
import com.smartserve.watchapp.Models.DataModels.ResponseModels.GetPaidBillResponse
import com.smartserve.watchapp.Models.DataModels.ResponseModels.GetWaiterListResponse
import com.smartserve.watchapp.Models.DataModels.UtilityModels.BaseResponse
import com.smartserve.watchapp.Models.Source.Repository.DataRepository
import com.smartserve.watchapp.Utils.GeneralUtils.OneShotEvent
import com.smartserve.watchapp.Utils.NetworkUtils.ResultWrapper
import com.smartserve.watchapp.ViewModels.BaseAndroidViewModel
import kotlinx.coroutines.launch


class MainFunctionsViewModel(private val dataRepository: DataRepository) :
    BaseAndroidViewModel() {


 

    var notificationResponseLiveData: MutableLiveData<OneShotEvent<GetNotificationResponse>> = MutableLiveData()
    var paidBillsResponseLiveData: MutableLiveData<OneShotEvent<GetPaidBillResponse>> = MutableLiveData()
    var waiterResponseLiveData: MutableLiveData<OneShotEvent<GetWaiterListResponse>> = MutableLiveData()

    var notificationReadLiveData: MutableLiveData<OneShotEvent<BaseResponse>> = MutableLiveData()


    fun getNotifications(currentDate:String) {
        showProgressBar(true)
        viewModelScope.launch {
            dataRepository.getNotifications(currentDate)?.let { response ->
                showProgressBar(false)
                when (response) {
                    is ResultWrapper.Success ->
                        if (isSuccess(response.value)) {
                            notificationResponseLiveData.value = OneShotEvent(response.value)
                        }
                    else -> handleErrorType(response)
                }
            }
        }
    }

    fun readNotifications(notification_uuid:String) {
        showProgressBar(true)
        viewModelScope.launch {
            dataRepository.readNotifications(notification_uuid)?.let { response ->
                showProgressBar(false)
                when (response) {
                    is ResultWrapper.Success ->
                        if (isSuccess(response.value)) {
                            notificationReadLiveData.value = OneShotEvent(response.value)
                        }
                    else -> handleErrorType(response)
                }
            }
        }
    }


    fun getWaiters() {
        showProgressBar(true)
        viewModelScope.launch {
            dataRepository.getWaiterList()?.let { response ->
                showProgressBar(false)
                when (response) {
                    is ResultWrapper.Success ->
                        if (isSuccess(response.value)) {
                            waiterResponseLiveData.value = OneShotEvent(response.value)
                        }
                    else -> handleErrorType(response)
                }
            }
        }
    }

    fun getPaidBills(currentDate:String) {
        showProgressBar(true)
        viewModelScope.launch {
            dataRepository.getPaidBills(currentDate)?.let { response ->
                showProgressBar(false)
                when (response) {
                    is ResultWrapper.Success ->
                        if (isSuccess(response.value)) {
                            paidBillsResponseLiveData.value = OneShotEvent(response.value)
                        }
                    else -> handleErrorType(response)
                }
            }
        }
    }




}