package com.example.planetapp.di

import com.example.planetapp.ui.planetdetails.PlanetDetailFragment
import com.example.planetapp.ui.planetlist.PlanetListFragment
import dagger.Component

@Component(modules = [NetworkModule::class, RepositoryModule::class])
interface ApplicationComponent {
    fun inject(planetDetailFragment: PlanetDetailFragment)
    fun inject(planetListFragment: PlanetListFragment)
}