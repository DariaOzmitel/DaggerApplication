package com.example.daggerapplication.di

import com.example.core.di.CoreModule
import com.example.daggerapplication.MainActivity
import dagger.Component

@Component(modules = [ViewModelModule::class, CoreModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)
}
