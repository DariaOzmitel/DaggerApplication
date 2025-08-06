package com.example.core.di

import com.example.core.network.ApiFactoryCard1
import com.example.core.network.ApiFactoryCard2
import com.example.core.network.ApiServiceCard1
import com.example.core.network.ApiServiceCard2
import com.example.core.repository.RepositoryImpl
import com.example.feature_home.repository.Repository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface CoreModule {

    @Binds
    fun bindRepository(impl: RepositoryImpl): Repository

    companion object {
        @Provides
        fun provideApiServiceCard1(): ApiServiceCard1 {
            return ApiFactoryCard1.apiService
        }

        @Provides
        fun provideApiServiceCard2(): ApiServiceCard2 {
            return ApiFactoryCard2.apiService
        }
    }
}