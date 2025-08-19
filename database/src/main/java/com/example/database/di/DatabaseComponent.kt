package com.example.database.di

import android.app.Application
import com.example.database.dao.BouquetDao
import com.example.database.dao.FlowerDao
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DatabaseModule::class])
interface DatabaseComponent {
    fun provideFlowerDao(): FlowerDao
    fun provideBouquetDao(): BouquetDao

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: Application
        ): DatabaseComponent
    }
}