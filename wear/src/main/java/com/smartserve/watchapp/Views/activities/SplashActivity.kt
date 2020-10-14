package com.smartserve.watchapp.Views.activities

import android.os.Handler
import com.smartserve.watchapp.R

class SplashActivity : BaseActivity() {
    companion object {
        val SPLASH_DELAY: Long = 3000
    }


    override fun initViews() {

        Handler().postDelayed(Runnable {
                gotoMainActivity()
        }, SPLASH_DELAY)
    }

    override fun getLayoutId(): Int {
       return R.layout.activity_splash
    }
}
