package com.example.daggerapplication

import android.app.Application
import com.example.core.di.CoreComponent
import com.example.core.di.CoreComponentProvider
import com.example.core.di.DaggerCoreComponent
import com.example.daggerapplication.di.AppComponent
import com.example.daggerapplication.di.DaggerAppComponent
import com.example.database.di.DaggerDatabaseComponent
import com.example.database.di.DatabaseComponent
import com.example.database.di.DatabaseComponentProvider

class DaggerApp : Application(), CoreComponentProvider, DatabaseComponentProvider {
    lateinit var appComponent: AppComponent
    private val coreComponent: CoreComponent by lazy {
        DaggerCoreComponent.create()
    }
    private val databaseComponent: DatabaseComponent by lazy {
        DaggerDatabaseComponent.factory().create(this)
    }

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.create()
    }

    override fun provideCoreComponent(): CoreComponent = coreComponent
    override fun provideDatabaseComponent(): DatabaseComponent = databaseComponent
}