package com.example.daggerapplication

import android.app.Application
import com.example.daggerapplication.di.AppComponent
import com.example.daggerapplication.di.DaggerAppComponent

class DaggerApp : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.create()
    }
}