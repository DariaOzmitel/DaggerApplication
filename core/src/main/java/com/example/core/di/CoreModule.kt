package com.example.core.di

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class CoreModule {

    @Singleton
    @Provides
    @Retrofit1Qualifier
    fun provideRetrofitServer1(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL_SERVER_1)
            .build()
    }

    @Singleton
    @Provides
    @Retrofit2Qualifier
    fun provideRetrofitServer2(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL_SERVER_2)
            .build()
    }
}

private const val BASE_URL_SERVER_1 =
    "https://gist.githubusercontent.com/DariaOzmitel/98f1ff214b6d920c5385b42c1f8046b7/raw/"

private const val BASE_URL_SERVER_2 =
    "https://gist.githubusercontent.com/DariaOzmitel/0ac72b643e334471183db170a61a49aa/raw/"
