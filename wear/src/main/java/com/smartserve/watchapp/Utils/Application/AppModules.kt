package com.smartserve.watchapp.Utils.Application

import com.rapidzz.garageapp.ViewModels.MainFunctionsViewModel
import com.rapidzz.garageapp.ViewModels.ProfileViewModel
import com.smartserve.watchapp.Models.Source.Repository.DataRepository
import com.smartserve.watchapp.Models.Source.ServerConnection.RetrofitClientInstance
import com.smartserve.watchapp.Utils.GeneralUtils.SessionManager
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


val applicationModule = module {

    factory { RetrofitClientInstance(get()) }
    single { SessionManager(get()) }
    factory { DataRepository(get(),get()) }

}

val viewModelModules = module {
    viewModel {
        ProfileViewModel(get())
    }

    viewModel {
        MainFunctionsViewModel(get())
    }
}


