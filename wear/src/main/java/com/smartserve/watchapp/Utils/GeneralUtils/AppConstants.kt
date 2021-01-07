package com.smartserve.watchapp.Utils.GeneralUtils

class AppConstants {

    companion object {

        // APIS
        const val SIGNIN_API = "user/auth/staff/authenticate/pin"
        const val LOGOUT_API = "user/auth/logout"
        const val GET_NOTIFICATION = "smartwatch/notification"
        const val READ_NOTIFICATION = "smartwatch/notification/{notification_uuid}"
        const val GET_WAITERS = "smartwatch/staff/{rest_uuid}"
        const val PAID_BILLS = "smartwatch/notification"
        const val UPDATE_FCM_TOKEN = "user/fcm/token"









        //EXTRA CONSTANTS
        const val DEVICE_TYPE = "android"



        //ACTIVITY TYPES
        const val ACTIVITY_WAITER_LIST="Kitchen to Waiter"
        const val ACTIVITY_PAID_BILLS="bill_paid"
        const val ACTIVITY_NOTIFICATIONS="watch_new_order"



        // Preference name

        const val PREF_NAME = "SmartServeWatchAppPrefs"
        const val IS_LOGGED_IN = "isLoggedIn"
        const val KEY_AUTH = "auth"
        const val PROFILE_PIC = "image"
        const val ADDRESS = "address"
        const val USER_ID = "user_id"
        const val REST_UUID = "rest_id"
        const val UNIQUE_CODE = "unique_code"
        const val EMAIL = "email"
        const val USER_STATUS = "user_status"
        const val FCM_TOKEN = "fcm_token"
        const val PHONE_NUMBER = "phone_num"
        const val IMAGE = "image"
        const val PASSWORD = "password"
        const val FIRST_NAME = "first_name"
        const val LAST_NAME = "last_name"
        const val PROFILE_STATUS = "PROFILE_STATUS"






    }
}