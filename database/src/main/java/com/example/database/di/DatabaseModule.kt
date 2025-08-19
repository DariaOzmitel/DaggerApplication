package com.example.database.di

import android.app.Application
import com.example.database.AppDatabase
import com.example.database.dao.BouquetDao
import com.example.database.dao.FlowerDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideFlowerDao(application: Application): FlowerDao {
        return AppDatabase.getInstance(application).flowerDao()
    }

    @Singleton
    @Provides
    fun provideBouquetDao(application: Application): BouquetDao {
        return AppDatabase.getInstance(application).bouquetDao()
    }
}