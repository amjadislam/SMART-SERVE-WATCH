package com.smartserve.watchapp.Models.Source.Repository

import android.content.Context
import com.smartserve.watchapp.Models.Source.ServerConnection.ApiService
import com.smartserve.watchapp.Models.Source.ServerConnection.RetrofitClientInstance

import com.google.gson.Gson
import com.smartserve.watchapp.Utils.GeneralUtils.SessionManager
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers


open class BaseRepository(ctx: Context) {

    var context: Context
    var sessionManager: SessionManager? = null
    val dispatcher: CoroutineDispatcher = Dispatchers.IO
    var userId:String =""

    var gson = Gson()

    init {
        context = ctx
        sessionManager = SessionManager(context)
        userId=sessionManager!!.getUserId()

    }




    fun getApiService(): ApiService {
        if(userId.isNullOrEmpty())
        {
            userId=sessionManager!!.getUserId()
        }
        return RetrofitClientInstance.getInstance(context)!!.getService()
    }













}