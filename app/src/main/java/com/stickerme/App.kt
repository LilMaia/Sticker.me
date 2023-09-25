package com.stickerme

import android.app.Application
import com.stickerme.login.di.loginModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(loginModule))
        }
    }
}
