package com.example.daggerapplication.di

import com.example.daggerapplication.MainActivity
import dagger.Component

@Component
interface AppComponent {
    fun inject(activity: MainActivity)
}
