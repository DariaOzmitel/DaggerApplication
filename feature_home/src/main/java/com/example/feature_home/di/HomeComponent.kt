package com.example.feature_home.di

import android.content.Context
import com.example.core.di.CoreComponent
import com.example.core.di.CoreComponentProvider
import com.example.feature_home.presentation.HomeFragment
import dagger.Component

@FeatureScope
@Component(
    modules = [HomeModule::class, ViewModelModule::class],
    dependencies = [CoreComponent::class]
)
interface HomeComponent {

    fun inject(fragment: HomeFragment)

    companion object {

        @Volatile
        private var homeComponent: HomeComponent? = null

        @Synchronized
        fun init(context: Context): HomeComponent {
            if (homeComponent == null) {
                val coreComponent =
                    (context.applicationContext as CoreComponentProvider).provideCoreComponent()
                homeComponent = DaggerHomeComponent
                    .builder()
                    .coreComponent(coreComponent)
                    .build()
            }
            return homeComponent!!
        }
    }
}