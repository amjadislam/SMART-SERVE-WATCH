package com.smartserve.watchapp.Views.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.NavHostFragment
import com.google.firebase.iid.FirebaseInstanceId
import com.smartserve.watchapp.R
import com.smartserve.watchapp.Utils.Application.SmartServeWatchApp
import com.smartserve.watchapp.Utils.Application.openActivityWithExist
import com.smartserve.watchapp.Utils.GeneralUtils.DialogUtils
import com.smartserve.watchapp.Utils.GeneralUtils.SessionManager
import org.koin.android.ext.android.get

abstract class BaseActivity : AppCompatActivity() {

    val sessionManager: SessionManager = get()
    var dialog: AlertDialog? = null
    protected var mMyApp: SmartServeWatchApp? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        dialog = DialogUtils.getProgressDialog(this)
        mMyApp = this.applicationContext as SmartServeWatchApp
        initViews()
    }


    abstract fun getLayoutId(): Int
    abstract fun initViews()


    fun gotoMainActivity() {
        openActivityWithExist(MainActivity::class.java)
    }

    fun gotoSplashActivity() {
        openActivityWithExist(SplashActivity::class.java)
    }

    fun gotoLoginActivity() {
        openActivityWithExist(LoginActivity::class.java)
    }

    fun showProgressDialog(show: Boolean) {

        if (dialog != null && show) {
            if (!dialog!!.isShowing)
                dialog!!.apply {
                    show()
                }
        } else if (dialog != null && !show) {
            if (dialog!!.isShowing)
                dialog!!.dismiss()
        }
    }

    override fun onResume() {
        super.onResume()
        mMyApp?.setCurrentActivity(this)
    }

    fun getToken() {
        FirebaseInstanceId.getInstance().instanceId.addOnSuccessListener {
            sessionManager.setFCMToken(it.token)
            Log.e("token",it.token)
        }
    }

    fun getCurrentFragment(): Fragment? {
        val navHostFragment =
            supportFragmentManager.primaryNavigationFragment as NavHostFragment?
        val fragmentManager: FragmentManager = navHostFragment!!.childFragmentManager
        return fragmentManager.primaryNavigationFragment

    }

}
