package com.smartserve.watchapp.Utils.Application

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.koinApplication
import org.koin.dsl.module


class SmartServeKitchenApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@SmartServeKitchenApplication)
            listOf(applicationModule, viewModelModules)
        }
    }



}