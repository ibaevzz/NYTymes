package com.example.nytimes

import android.app.Application
import com.example.nytimes.di.moduleNetwork
import com.example.nytimes.di.moduleViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class NYApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@NYApplication)
            androidLogger()
            modules(moduleNetwork, moduleViewModel)
        }
    }
}