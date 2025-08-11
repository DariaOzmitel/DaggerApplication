package com.example.core.di

import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [CoreModule::class])
interface CoreComponent {
    @Retrofit1Qualifier
    fun retrofit1(): Retrofit
    @Retrofit2Qualifier
    fun retrofit2(): Retrofit
}