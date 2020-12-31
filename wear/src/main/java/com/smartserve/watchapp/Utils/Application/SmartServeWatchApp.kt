package com.smartserve.watchapp.Utils.Application

import android.app.Application
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



}