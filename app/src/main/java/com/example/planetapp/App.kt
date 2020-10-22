package com.example.planetapp

import android.app.Application
import com.example.planetapp.di.ApplicationComponent
import com.example.planetapp.di.DaggerApplicationComponent

// provides ApplicationContext
class App : Application() {
    lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerApplicationComponent.builder().context(applicationContext).build()
    }
}