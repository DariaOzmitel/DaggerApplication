package com.example.feature_home.di

import com.example.core.di.Retrofit1Qualifier
import com.example.core.di.Retrofit2Qualifier
import retrofit2.Retrofit

interface HomeDepsProvider {
    @Retrofit1Qualifier
    fun getRetrofitServer1(): Retrofit

    @Retrofit2Qualifier
    fun getRetrofitServer2(): Retrofit
}