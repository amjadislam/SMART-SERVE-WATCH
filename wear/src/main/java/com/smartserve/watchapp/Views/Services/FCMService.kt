package com.smartserve.watchapp.Views.Services

import android.app.PendingIntent
import android.content.Intent
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.smartserve.watchapp.Utils.Application.SmartServeWatchApp
import com.smartserve.watchapp.Utils.GeneralUtils.NotificationHelper
import com.smartserve.watchapp.Views.activities.MainActivity
import com.smartserve.watchapp.Views.activities.SplashActivity
import com.smartserve.watchapp.Views.fragments.HomeFragment
import com.smartserve.watchapp.Views.fragments.NotificationFragment
import com.smartserve.watchapp.Views.fragments.PaidBillFragment
import com.smartserve.watchapp.Views.fragments.WaiterListFragment
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.greenrobot.eventbus.EventBus


class FCMService : FirebaseMessagingService() {

    var TAG: String = "FCMToken"
    var message: String = ""
    var title: String = ""
    var requestID = System.currentTimeMillis().toInt()
    // var eventItem=EventItem()


    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)

        requestID = System.currentTimeMillis().toInt()
        handleNotificationData()
        remoteMessage?.let {
//            remoteMessage.notification?.let {
//                title = remoteMessage.notification!!.title!!
//                message = remoteMessage.notification!!.body!!
//            }
            if (remoteMessage.data != null) {
                // TAG = remoteMessage.data["type"]!!
                //eventItem = EventItem(TAG!!)
            }
        }

    }

    fun handleNotificationData() {

        if ((applicationContext as SmartServeWatchApp).getCurrentActivity() != null
            && (applicationContext as SmartServeWatchApp).getCurrentActivity() is MainActivity
        ) {
            createBookingOrInvitation()
            sendNotification()
            when (TAG) {
                /*NEW_ORDER_TYPE -> {
                    if (((applicationContext as App).getCurrentActivity() as BaseActivity).getCurrentFragment() is HomeFragment) {
                        EventBus.getDefault().post(EventItem(TAG))
                    } else {
                        sendNotification()
                    }
                }

                ORDER_CANCEL -> {
                    if (((applicationContext as App).getCurrentActivity() as BaseActivity).getCurrentFragment() is BidsHistoryFragment) {
                        EventBus.getDefault().post(EventItem(TAG))
                    } else {
                        sendNotification()
                    }
                }

                ORDER_APPROVE -> {
                    if (((applicationContext as App).getCurrentActivity() as BaseActivity).getCurrentFragment() is BidsHistoryFragment) {
                        AppInstance.getInstance().accepted = true
                        EventBus.getDefault().post(EventItem(TAG))
                    } else {
                        sendNotification()
                    }
                }
                else -> {
                    sendNotification()
                }*/

            }
        }

    }


    fun sendNotification() {

        val notificationHelper = NotificationHelper(this)
        var notificationIntent = Intent(applicationContext, SplashActivity::class.java)
//         notificationIntent.putExtra("data", eventItem)
        notificationIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        var contentIntent = PendingIntent.getActivity(
            this,
            requestID,
            notificationIntent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )
        val builder = notificationHelper.createNotificationBuilder(
            title,
            message, true, contentIntent
        )
        notificationHelper.makeNotification(builder, requestID)

    }

    fun createBookingOrInvitation() {
        val fragment =
            ((applicationContext as SmartServeWatchApp).getCurrentActivity() as MainActivity).getCurrentFragment()
        if (fragment is NotificationFragment || fragment is PaidBillFragment || fragment is WaiterListFragment) {
            EventBus.getDefault().post("")
        }
    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        GlobalScope.launch {
//             DataRepository(this@FCMService).updateFCMToken(token)
        }
    }
}