package com.smartserve.watchapp.Views.activities

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.google.firebase.iid.FirebaseInstanceId
import com.smartserve.watchapp.Utils.Application.openActivityWithExist
import com.smartserve.watchapp.Utils.GeneralUtils.DialogUtils
import com.smartserve.watchapp.Utils.GeneralUtils.SessionManager
import org.koin.android.ext.android.get

abstract class BaseActivity : AppCompatActivity() {

    val sessionManager: SessionManager = get()
    var dialog: AlertDialog?= null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        dialog = DialogUtils.getProgressDialog(this)
        initViews()
    }




    abstract fun getLayoutId():Int
    abstract fun initViews()




    fun gotoMainActivity()
    {
        openActivityWithExist(MainActivity::class.java)
    }

    fun gotoSplashActivity()
    {
        openActivityWithExist(SplashActivity::class.java)
    }

    fun gotoLoginActivity()
    {
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



    private fun getToken()
    {
        FirebaseInstanceId.getInstance().instanceId.addOnSuccessListener {
            sessionManager.setFCMToken(it.token)
        }
    }

}
