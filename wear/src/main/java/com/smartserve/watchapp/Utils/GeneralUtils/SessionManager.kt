package com.smartserve.watchapp.Utils.GeneralUtils

import android.content.Context
import android.content.SharedPreferences
import com.smartserve.watchapp.Models.DataModels.GeneralModels.UserModel.UserModel
import com.smartserve.watchapp.Models.Source.ServerConnection.RetrofitClientInstance
import com.smartserve.watchapp.Utils.GeneralUtils.AppConstants.Companion.ADDRESS
import com.smartserve.watchapp.Utils.GeneralUtils.AppConstants.Companion.EMAIL
import com.smartserve.watchapp.Utils.GeneralUtils.AppConstants.Companion.FCM_TOKEN
import com.smartserve.watchapp.Utils.GeneralUtils.AppConstants.Companion.FIRST_NAME
import com.smartserve.watchapp.Utils.GeneralUtils.AppConstants.Companion.IS_LOGGED_IN
import com.smartserve.watchapp.Utils.GeneralUtils.AppConstants.Companion.KEY_AUTH
import com.smartserve.watchapp.Utils.GeneralUtils.AppConstants.Companion.LAST_NAME
import com.smartserve.watchapp.Utils.GeneralUtils.AppConstants.Companion.PHONE_NUMBER
import com.smartserve.watchapp.Utils.GeneralUtils.AppConstants.Companion.PREF_NAME
import com.smartserve.watchapp.Utils.GeneralUtils.AppConstants.Companion.PROFILE_PIC
import com.smartserve.watchapp.Utils.GeneralUtils.AppConstants.Companion.PROFILE_STATUS
import com.smartserve.watchapp.Utils.GeneralUtils.AppConstants.Companion.UNIQUE_CODE
import com.smartserve.watchapp.Utils.GeneralUtils.AppConstants.Companion.USER_ID
import com.smartserve.watchapp.Utils.GeneralUtils.AppConstants.Companion.USER_STATUS

class SessionManager {
    var context: Context? = null
    var pref: SharedPreferences

    constructor(context: Context) {
        this.context = context
        pref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    fun isLoggedIn(): Boolean {
        return pref.getBoolean(IS_LOGGED_IN, false)
    }

    fun setLoggedIn(isLoggedIn: Boolean) {
        with(pref.edit()) {
            putBoolean(IS_LOGGED_IN, isLoggedIn)
            apply()
        }
    }

    fun setUserId(id: String) {
        with(pref.edit()) {
            putString(USER_ID, id)
            apply()
        }
    }

    fun getUserId(): String {
        return pref.getString(USER_ID, "")!!
    }


    fun setUniqueCode(id: String) {
        with(pref.edit()) {
            putString(UNIQUE_CODE, id)
            apply()
        }
    }

    fun getUniqueCode(): String {
        return pref.getString(UNIQUE_CODE, "")!!
    }

    fun setFirstName(name: String?) {
        with(pref.edit()) {
            putString(FIRST_NAME, name)
            apply()
        }
    }


    fun setName(name: String?) {
        with(pref.edit()) {
            putString(LAST_NAME, name)
            apply()
        }
    }

    fun getFirstName(): String {
        return pref.getString(FIRST_NAME, "")!!
    }


    fun getName(): String {
        return pref.getString(LAST_NAME, "")!!
    }


    fun setAddress(address: String?) {
        with(pref.edit()) {
            putString(ADDRESS, address)
            apply()
        }
    }

    fun getAddress(): String {
        return pref.getString(ADDRESS, "")!!
    }


    fun setLat(lat: String?) {
        with(pref.edit()) {
            putString("lat", lat)
            apply()
        }
    }

    fun getLat(): String {
        return pref.getString("lat", "")!!
    }


    fun setLng(lat: String?) {
        with(pref.edit()) {
            putString("lng", lat)
            apply()
        }
    }

    fun getLng(): String {
        return pref.getString("lng", "")!!
    }

    fun setPhoneNumber(phone_num: String?) {
        with(pref.edit()) {
            putString(PHONE_NUMBER, phone_num)
            apply()
        }
    }

    fun getPhoneNumber(): String {
        return pref.getString(PHONE_NUMBER, "")!!
    }

    fun setMobileNumber(value: String?) {
        with(pref.edit()) {
            putString(PHONE_NUMBER, value)
            apply()
        }
    }

    fun getMobileNumber(): String {
        return pref.getString(PHONE_NUMBER, "")!!
    }

    fun setPicture(name: String?) {
        with(pref.edit()) {
            putString(PROFILE_PIC, name)
            apply()
        }
    }

    fun getPicture(): String {
        return pref.getString(PROFILE_PIC, "")!!
    }

    fun setFCMToken(token: String?) {
        with(pref.edit()) {
            putString(FCM_TOKEN, token)
            apply()
        }
    }

    fun getFCMToken(): String {
        return pref.getString(FCM_TOKEN, "")!!
    }

    fun setEmail(email: String?) {
        with(pref.edit()) {
            putString(EMAIL, email)
            apply()
        }
    }

    fun getEmail(): String {
        return pref.getString(EMAIL, "")!!
    }

fun setUserStatus(user_status: String?) {
        with(pref.edit()) {
            putString(USER_STATUS, user_status)
            apply()
        }
    }

    fun getUserStatus(): String {
        return pref.getString(USER_STATUS, "")!!
    }


    fun setInfoStatus(status: Int?) {
        status?.let {
            with(pref.edit()) {
                putInt(PROFILE_STATUS, status)
                apply()
            }
        }

    }

    fun isProfileCompleted(): Boolean {
        return pref.getInt(PROFILE_STATUS, 1) == 1

    }


    fun setAuthToken(email: String?) {
        with(pref.edit()) {
            putString(KEY_AUTH, email)
            apply()
        }
        RetrofitClientInstance.getInstance(context!!)?.initRetrofit()
    }

    fun getAuthToken(): String? {
        return pref.getString(KEY_AUTH, "")
    }


//    fun setPermissions(permissions: ArrayList<Permission>) {
//        var permissionsData=Gson().toJson(PermissionsData(permissions))
//        with(pref.edit()) {
//            putString(KEY_PERMISSIONS, permissionsData)
//            apply()
//        }
//        RetrofitClientInstance.getInstance(context!!)?.initRetrofit()
//    }

//    fun hasPermission(id: Int): Boolean {
//
//        var dataString=pref.getString(KEY_PERMISSIONS, "")
//        return if(dataString.isNullOrEmpty()) {
//            false
//        } else {
//            val permissionsData=Gson().fromJson(dataString,PermissionsData::class.java)
//            val reqPermission=permissionsData.permission.find { it.id==id }
//            reqPermission!=null
//        }
//    }


    fun logout() {
        setLoggedIn(false)
        setEmail("")
        setUserId("")
        setName("")
        setMobileNumber("")
        setPicture("")
        setFCMToken("")
        setUserStatus("")
        setUniqueCode("")
    }

    fun setUser(user: UserModel) {

        setUserId(user.uuid)
        setName(user.name)
        setEmail(user.email)
        setUniqueCode(user.unique_code)
        setLoggedIn(true)
        setFCMToken(user.access_token)
        setPhoneNumber(user.mobile_number)
        setPicture(user.avatar_src)
        setUserStatus(user.user_status)


    }

    fun getLocale(): String {
        return "en"
    }
}