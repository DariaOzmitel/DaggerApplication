package com.example.feature_home.di

import com.example.feature_home.data.repository.RepositoryImpl
import com.example.feature_home.domain.repository.Repository
import dagger.Binds
import dagger.Module

@Module
interface HomeModule {

    @FeatureScope
    @Binds
    fun bindRepository(impl: RepositoryImpl): Repository
}