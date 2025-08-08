package com.example.daggerapplication

import android.app.Application
import com.example.daggerapplication.di.AppComponent
import com.example.daggerapplication.di.DaggerAppComponent
import com.example.feature_home.di.HomeDepsProvider
import retrofit2.Retrofit

class DaggerApp : Application(), HomeDepsProvider {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.create()
    }

    override fun getRetrofitServer1(): Retrofit = appComponent.getRetrofitServer1()
    override fun getRetrofitServer2(): Retrofit = appComponent.getRetrofitServer2()
}