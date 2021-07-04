package com.demo.newsapp

import android.app.Application
import android.content.Context
import android.os.StrictMode

class App : Application() {
    companion object {
        private lateinit var appContext: Context
        fun getContext() = appContext
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        appContext = this
    }

    override fun onCreate() {
        super.onCreate()
//        initStrictMode()
    }

    private fun initStrictMode() {
        StrictMode.setThreadPolicy(
            StrictMode.ThreadPolicy.Builder()
                .detectDiskReads()
                .detectDiskWrites()
                .detectNetwork()
                .detectAll()
                .penaltyLog()
                .build()
        )
    }
}