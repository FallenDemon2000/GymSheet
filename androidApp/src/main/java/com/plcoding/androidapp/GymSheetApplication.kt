package com.plcoding.androidapp

import android.app.Application
import com.plcoding.shared.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class GymSheetApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() =
        startKoin {
            androidContext(this@GymSheetApplication)
            modules(appModule)
        }
}
