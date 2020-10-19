package com.example.planetapp

import dagger.Component

@Component(modules = [NetworkModule::class, RepositoryModule::class])
interface ApplicationComponent {
    fun inject(planetDetailFragment: PlanetDetailFragment)
    fun inject(planetListFragment: PlanetListFragment)
}