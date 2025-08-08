package com.example.feature_home.di

import android.content.Context
import com.example.feature_home.presentation.HomeFragment
import dagger.Component

@Component(
    modules = [HomeModule::class, ViewModelModule::class], dependencies = [HomeDepsProvider::class]
)
interface HomeComponent {

    fun inject(fragment: HomeFragment)

    @Component.Builder
    interface Builder {

        fun deps(deps: HomeDepsProvider): Builder

        fun build(): HomeComponent
    }

    companion object {

        @Volatile
        private var homeComponent: HomeComponent? = null

        @Synchronized
        fun init(context: Context): HomeComponent {
            if (homeComponent == null) {
                val deps = context.applicationContext as HomeDepsProvider
                homeComponent = DaggerHomeComponent
                    .builder()
                    .deps(deps)
                    .build()
            }
            return homeComponent!!
        }
    }
}