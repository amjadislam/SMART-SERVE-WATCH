package com.smartserve.watchapp.Utils.Application


import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Paint
import android.net.Uri
import android.provider.Settings
import android.telephony.TelephonyManager
import android.text.TextUtils
import android.util.Patterns
import android.view.View
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout
import com.smartserve.watchapp.Models.DataModels.GeneralModels.UserModel.MenuModel
import com.smartserve.watchapp.R
import com.smartserve.watchapp.Views.dialog.AlertMessageDialog
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


fun View.hideKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}


fun EditText.isValidPhone(): Boolean {
    return (!TextUtils.isEmpty(text.toString().trim { it <= ' ' })
            && Patterns.PHONE.matcher(text.toString().trim { it <= ' ' }).matches()
            && text.toString().length >= 13)
}

fun EditText.isEmailValid(): Boolean {
    return !TextUtils.isEmpty(text) && Patterns.EMAIL_ADDRESS.matcher(text).matches()
}


fun ImageView.loadImage(url: String) {
    val circularProgressDrawable = context?.let { CircularProgressDrawable(it) }
    circularProgressDrawable?.strokeWidth = 5f
    circularProgressDrawable?.centerRadius = 30f
    circularProgressDrawable?.start()
    context?.let {
        Glide.with(it)
            .load(url)
            .placeholder(circularProgressDrawable)
            .into(this)
    }

}

fun ImageView.loadImage(resourceID: Int) {
    Glide.with(context)
        .load(resourceID)
        .into(this)
}

fun TextView.showStrikeThrough(show: Boolean) {
    paintFlags =
        if (show) paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        else paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
}


fun <T> Call<T>.enqueue(callback: CallBackKt<T>.() -> Unit) {
    val callBackKt = CallBackKt<T>()
    callback.invoke(callBackKt)
    this.enqueue(callBackKt)
}

class CallBackKt<T> : Callback<T> {

    var onSucessResponse: ((Response<T>) -> Unit)? = null
    var onErrorResponse: ((String?) -> Unit)? = null
    var onFailure: ((t: Throwable?) -> Unit)? = null

    override fun onFailure(call: Call<T>, t: Throwable) {
        onFailure?.invoke(t)
    }

    override fun onResponse(call: Call<T>, response: Response<T>) {
        if (response.isSuccessful) {
            if (response.body() != null) {
                onSucessResponse?.invoke(response)
            } else if (response.errorBody() != null) {
                onErrorResponse?.invoke(response.errorBody()?.string())
            } else {
                onFailure?.invoke(Throwable("No error mentioned"))
            }

        } else {
            onErrorResponse?.invoke(response.errorBody()?.string())
        }
    }

}


fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun View.isVisibleToUser(): Boolean {
    return visibility == View.VISIBLE
}

fun EditText.string(): String {
    return this.text.toString().trim()
}

fun String?.requireString(): String {
    return "" + this
}

fun EditText.Error(errorMessage: String?) {
    error = "Field required"
    errorMessage?.let {
        error = errorMessage
    }
    requestFocus()

}

fun TextInputLayout.errorSet(errorMessage: String?) {
    error = "Field required"
    errorMessage?.let {
        error = errorMessage
    }
    isErrorEnabled = true
    requestFocus()

}


fun Context.newNavigatorIntent(
    latitude: Double,
    longitude: Double,
    name: String
): Intent? {
    val format =
        "geo:0,0?q=" + java.lang.Double.toString(latitude) + "," + java.lang.Double.toString(
            longitude
        ) + "(" + name + ")"
    val uri: Uri = Uri.parse(format)
    val intent = Intent(Intent.ACTION_VIEW, uri)
    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
    return if (intent.resolveActivity(this.packageManager) != null) {
        intent
    } else null
}


fun Context?.getUniqueAndroidId(): String {
    var androidId =
        Settings.Secure.getString(this?.getContentResolver(), Settings.Secure.ANDROID_ID)
    if (androidId.isNullOrEmpty()) {
        val telephonyManager = this?.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        androidId = telephonyManager.deviceId
    }
    return androidId
}

fun Context.newDialerIntent(phone: String): Intent? {
    val intent = Intent(Intent.ACTION_DIAL)
    intent.data = Uri.parse("tel:$phone")
    return if (intent.resolveActivity(this.packageManager) != null) {
        intent
    } else null
}


fun Context.newSendEmailsIntent(
    emails: Array<String>?,
    subject: String?,
    text: String?
): Intent? {
    val mailIntent = Intent(Intent.ACTION_SENDTO)
    mailIntent.type = "message/rfc822"
    mailIntent.putExtra(Intent.EXTRA_SUBJECT, subject)
    mailIntent.putExtra(Intent.EXTRA_EMAIL, emails)
    mailIntent.putExtra(Intent.EXTRA_TEXT, text)
    return if (mailIntent.resolveActivity(this.packageManager) != null) {
        mailIntent
    } else null
}

fun Context.newSendEmailIntent(
    email: String,
    subject: String?,
    text: String?
): Intent? {
    return newSendEmailsIntent(arrayOf(email), subject, text)
}

fun Context.newOpenUrlIntent(url: String?): Intent? {
    val urlIntent = Intent(Intent.ACTION_VIEW)
    urlIntent.data = Uri.parse(url)
    return if (urlIntent.resolveActivity(this.packageManager) != null) {
        urlIntent
    } else null
}

fun Context.newShareFileIntent(
    uri: Uri?,
    mimeType: String?
): Intent? {
    val shareIntent = Intent(Intent.ACTION_SEND)
    shareIntent.putExtra(Intent.EXTRA_STREAM, uri)
    shareIntent.type = mimeType
    return if (shareIntent.resolveActivity(this.packageManager) != null) {
        shareIntent
    } else null
}


fun Context.newShareTextIntent(text: String?): Intent? {
    val shareIntent = Intent(Intent.ACTION_SEND)
    shareIntent.putExtra(Intent.EXTRA_TEXT, text)
    shareIntent.type = "text/*"
    return if (shareIntent.resolveActivity(this.packageManager) != null) {
        shareIntent
    } else null
}


fun Activity.openActivity(clazz: Class<out Activity>) {
    startActivity(Intent(this, clazz))
}

fun Activity.openActivityWithExist(clazz: Class<out Activity>) {
    startActivity(Intent(this, clazz))
    this.finish()
}


fun Activity.openActivityForResult(clazz: Class<out Activity>, requestCode: Int) {
    startActivityForResult(Intent(this, clazz), requestCode)
}


fun Fragment.showAlertDialog(msg: String) {
    var newMessage = msg
    if (newMessage.isEmpty()) {
        newMessage = "Unable to process your request \nPlease try again later !!"
    }
    AlertMessageDialog.newInstance(newMessage)
        .show(requireActivity().supportFragmentManager, AlertMessageDialog.TAG)
}

fun FragmentActivity.showAlertDialog(msg: String) {
    var newMessage = msg
    if (newMessage.isEmpty()) {
        newMessage = "Unable to process your request \nPlease try again later !!"
    }
    AlertMessageDialog.newInstance(newMessage).show(supportFragmentManager, AlertMessageDialog.TAG)
}


fun View.collapse() {
    val animate = TranslateAnimation(
        0f,
        0f,
        0f,
        this.height.toFloat()
    )
    animate.duration = 500
    animate.fillAfter = true
    this.startAnimation(animate)
    animate.setAnimationListener(object : Animation.AnimationListener {
        override fun onAnimationRepeat(animation: Animation?) {

        }

        override fun onAnimationEnd(animation: Animation?) {
            this@collapse.gone()
        }

        override fun onAnimationStart(animation: Animation?) {

        }
    })
}


fun View.expand() {
    val animate = TranslateAnimation(
        0f,
        0f,
        this.height.toFloat(),
        0f
    )
    animate.duration = 500
    animate.fillAfter = true
    this.startAnimation(animate)
    animate.setAnimationListener(object : Animation.AnimationListener {
        override fun onAnimationRepeat(animation: Animation?) {

        }

        override fun onAnimationEnd(animation: Animation?) {

        }

        override fun onAnimationStart(animation: Animation?) {
            this@expand.visible()
        }
    })
}


fun View.showSnackBar(message: String) {
    val snackbar = Snackbar.make(this, message, Snackbar.LENGTH_LONG)
    snackbar.show()
}

fun Activity.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Fragment.showToast(message: String) {
    Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
}


fun Fragment.getSimpleName(): String {
    return this.javaClass.simpleName
}

fun Fragment.getColorCustom(color: Int): Int {
    return ContextCompat.getColor(requireContext(), color)
}


fun Date.dateWithUTCTimeZone(): String {
    val sdf = SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.ENGLISH);
    sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
    return sdf.format(this)
}

fun String.getDateWithCurrentTimeZone(): String {
    val sdf = SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.ENGLISH);
    sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
    val date = sdf.parse(this)
    sdf.setTimeZone(TimeZone.getDefault())
    return "" + date?.dateWithCurrentTimeZone()
}

fun String.dateToFullMothName(): String {
    var timeString = ""
    val newFormat = "dd MMM, yyyy - hh:mm a"
    val dateFormat = SimpleDateFormat("yyyy/MM/dd HH:mm:ssZ", Locale.ENGLISH);
    var myDate: Date? = null
    try {
        myDate = dateFormat.parse(this)
        val timeFormat = SimpleDateFormat(newFormat)
        myDate?.let {
            timeString= timeFormat.format(myDate)
        }

    } catch (e: ParseException) {
        e.printStackTrace()
    }
//    val timeFormat = SimpleDateFormat(newFormat)
//    timeString = "" + timeFormat.format(myDate)
    return timeString
}

fun Date.dateWithCurrentTimeZone(): String {
    val sdf = SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.ENGLISH);
    sdf.setTimeZone(TimeZone.getDefault());
    return sdf.format(this)
}


fun Fragment.getCurrentDate(): String {
    val dateFormat: DateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)
    val cal = Calendar.getInstance()
    return dateFormat.format(cal.time)
}


fun Fragment.getColorToLoad(id: Int): Int {
    return if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
        requireContext().getColor(id)
    } else {
        requireContext().resources.getColor(id)
    }
}


fun EditText.getString(): String {
    if (this.text.isNullOrEmpty()) {
        return ""
    } else {
        return this.text.toString()
    }
}

fun EditText.getInt(): Int {
    var value = 0
    try {
        value = this.text.toString().toInt()
    } catch (e: Exception) {
    }
    return value
}

fun View.loadMenuItems(): ArrayList<MenuModel> {
    val menus = ArrayList<MenuModel>()
    menus.add(MenuModel(1, R.drawable.ic_notifications_list, context.getString(R.string.notification)))
    menus.add(MenuModel(2, R.drawable.ic_waiter_list, context.getString(R.string.waiter_list)))
    menus.add(MenuModel(3, R.drawable.ic_paid_bills, context.getString(R.string.paid_bills)))
    menus.add(MenuModel(4, R.drawable.icon_logout, context.getString(R.string.logout)))
    return menus
}




