package com.example.planetapp.di

import com.example.planetapp.PlanetRepositoryImplementation
import com.example.planetapp.PlanetRetrofitService
import com.example.planetapp.domain.PlanetRepository
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers

// this class  / module is used for dependency injection (through dagger)

@Module
class RepositoryModule {
    @Provides
    fun providePlanetRepository(planetRetrofitService: PlanetRetrofitService): PlanetRepository {
        return PlanetRepositoryImplementation(
            planetRetrofitService,
            Dispatchers.IO
        )
    }
}