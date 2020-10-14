package com.smartserve.watchapp.Models.Source.Repository


import com.smartserve.watchapp.Models.DataModels.UtilityModels.BaseResponse
import com.smartserve.watchapp.Models.DataSource.BaseDataSource

interface ServerDataSource {


    interface GetGeneralResponseCallback: BaseDataSource {
        fun onSuccess(baseResponse: BaseResponse)
    }

//
//    interface LoginCallback:BaseDataSource{
//        fun onLogin(login: LoginResponse)
//
//    }



}