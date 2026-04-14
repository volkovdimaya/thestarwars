package com.dima.thestarwars

import android.app.Application
import com.dima.thestarwars.di.dataModule
import com.dima.thestarwars.di.interactorModule
import com.dima.thestarwars.di.repositoryModule
import com.dima.thestarwars.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
        override fun onCreate() {
            super.onCreate()
            startKoin{
                androidContext(this@App)
                modules(dataModule, repositoryModule, viewModelModule, interactorModule)
            }
        }
}