package com.smartserve.watchapp.Utils.GeneralUtils

class AppConstants {

    companion object {
        val VALID_PHONE_NUMBER: String = "Enter a valid phone number"
        val FIELD_REQUIRED: String = "This field is required"
        val REQUIRED_ERROR: String = "Can't be empty !!"


        // REQUEST CODES
        const val PHONE_CODE = 110
        const val ADDRESS_CODE = 111
        val REQUEST_CODES= intArrayOf(PHONE_CODE,ADDRESS_CODE)



        // POST EXTRAS
        const val MOBILE_PHONE_ARG = "mobile_phone"
        const val GARAGE_USER_ARG = "garage_user"






        //USER TYPES
        const val ADMIN_TYPE ="admin"
        const val SUB_ADMIN_TYPE="sub-admin"

        //GARAGE TYPES
        const val GARAGE_TYPE ="garage"
        const val MOBILE_GARAGE_TYPE="mobile_garage"
        const val BOTH_GARAGE ="both"



        // BID STATUS
        const val BID_ACCEPTED = "accepted"
        const val BID_REJECTED = "rejected"
        const val BID_CANCELLED="cancelled"




        // APIS
        const val SIGNIN_API = "login"
        const val SIGNUP_API = "signup"
        const val LOGOUT_API="user-logout"
        const val CHANGE_PASSWORD="change_password"
        const val FORGOT_PASSWORD="forget_password"
        const val VERIFY_CODE="verify_code"
        const val UPDATE_PASSWORD="update_password"
        const val GET_PROFILE="garage-get-profile"
        const val UPDATE_PROFILE="garage-update-profile"
        const val UPDATE_FCM="update_fcm"

        const val GET_SERVICE_CATEGORIES="garage/service-categories"
        const val ADD_SERVICE_CATEGORY="garage/service-categories/create"
        const val UPDATE_SERVICE_CATEGORY="garage/service-categories/update"
        const val ADD_SERVICE="garage/services/create"
        const val GET_ALL_SERVICES="garage/services"


        const val GET_GARAGE_USERS="garage/user-list"
        const val ADD_GARAGE_USER="garage/user-add"
        const val UPDATE_GARAGE_USER="garage/user-update"
        const val DELETE_GARAGE_USER="garage/user-delete"
        const val GET_GARAGE_USER_PERMISSIONS="user-permissions"
        const val ADD_TECHNICIAN_SUPERVISOR="technician-supervisor"



        const val POST_JOB="userjob/create"
        const val UPDATE_JOB="userjob"
        const val DELETE_JOB="userjob"
        const val JOB_DETAILS="userjob"
        const val GET_ALL_JOBS="userjob/list"

        const val POST_BID="job/bids/post"
        const val UPDATE_BID="job/bids/update"
        const val DELETE_BID="job/bids"









        // Preference name

        const val PREF_NAME = "GarageAppPrefs"
        const val IS_LOGGED_IN = "isLoggedIn"
        const val KEY_AUTH = "auth"
        const val PROFILE_PIC = "image"
        const val ADDRESS = "address"
        const val USER_ID = "user_id"
        const val UNIQUE_CODE = "unique_code"
        const val EMAIL = "email"
        const val USER_STATUS = "user_status"
        const val FCM_TOKEN = "fcm_token"
        const val PHONE_NUMBER = "phone_num"
        const val IMAGE = "image"
        const val PASSWORD = "password"
        const val FIRST_NAME = "first_name"
        const val LAST_NAME = "last_name"

        const val KEY_PERMISSIONS = "key_permission"
        const val NOTIFY_STATUS = "notify_status"
        const val PROFILE_STATUS = "PROFILE_STATUS"

        const val LATITUDE = "lat"
        const val LONGITUDE = "lng"





    }
}