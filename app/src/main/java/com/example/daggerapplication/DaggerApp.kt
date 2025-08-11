package com.example.daggerapplication

import android.app.Application
import com.example.core.di.CoreComponent
import com.example.core.di.CoreComponentProvider
import com.example.core.di.DaggerCoreComponent
import com.example.daggerapplication.di.AppComponent
import com.example.daggerapplication.di.DaggerAppComponent

class DaggerApp : Application(), CoreComponentProvider {
    lateinit var appComponent: AppComponent
    private val coreComponent: CoreComponent by lazy {
        DaggerCoreComponent.create()
    }

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.create()
    }

    override fun provideCoreComponent(): CoreComponent = coreComponent
}