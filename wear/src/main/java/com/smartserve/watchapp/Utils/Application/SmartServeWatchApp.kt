package com.smartserve.watchapp.Utils.Application

import android.app.Activity
import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level


class SmartServeWatchApp: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger(Level.NONE)
            androidContext(this@SmartServeWatchApp)
            modules(listOf(applicationModule, viewModelModules))
        }
    }
    private var mCurrentActivity: Activity? = null
    fun getCurrentActivity(): Activity? {
        return mCurrentActivity
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
    fun setCurrentActivity(mCurrentActivity: Activity?) {
        this.mCurrentActivity = mCurrentActivity
    }

}