package com.example.planetapp.di

import android.content.Context
import com.example.planetapp.ui.planetdetails.PlanetDetailFragment
import com.example.planetapp.ui.planetlist.PlanetListFragment
import dagger.BindsInstance
import dagger.Component

@Component(modules = [NetworkModule::class, RepositoryModule::class, NotificationModule::class])
interface ApplicationComponent {
    fun inject(planetDetailFragment: PlanetDetailFragment)
    fun inject(planetListFragment: PlanetListFragment)

    // Necessary so that the Context can be injected in the repository
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder
        fun build(): ApplicationComponent
    }
}