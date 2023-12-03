package com.johnny3e.kkmusic

import android.app.Application
import timber.log.Timber

//import timber.log.Timber

class App : Application() {


    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        appContainer = AppContainer(this)
    }

    companion object {
        lateinit var appContainer: AppContainer
    }
}