package com.example.daggerapplication.di

import com.example.core.di.CoreModule
import com.example.daggerapplication.MainActivity
import com.example.feature_home.di.HomeDepsProvider
import dagger.Component

@Component(modules = [CoreModule::class])
interface AppComponent : HomeDepsProvider {
    fun inject(activity: MainActivity)
}
