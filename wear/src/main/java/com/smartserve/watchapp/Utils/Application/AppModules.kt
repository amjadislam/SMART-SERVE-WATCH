package com.smartserve.watchapp.Utils.Application

import com.rapidzz.garageapp.ViewModels.ProfileViewModel
import com.smartserve.watchapp.Models.Source.Repository.DataRepository
import com.smartserve.watchapp.Utils.GeneralUtils.SessionManager
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val applicationModule = module {
    single { DataRepository(get()) }

}

val viewModelModules = module {
    viewModel {
        ProfileViewModel(get())
    }
}


