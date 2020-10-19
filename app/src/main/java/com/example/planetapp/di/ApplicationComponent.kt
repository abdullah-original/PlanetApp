package com.example.planetapp.di

import com.example.planetapp.PlanetDetailFragment
import com.example.planetapp.PlanetListFragment
import dagger.Component

@Component(modules = [NetworkModule::class, RepositoryModule::class])
interface ApplicationComponent {
    fun inject(planetDetailFragment: PlanetDetailFragment)
    fun inject(planetListFragment: PlanetListFragment)
}