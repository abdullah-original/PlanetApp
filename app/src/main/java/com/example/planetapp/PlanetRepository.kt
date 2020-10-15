package com.example.planetapp

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface PlanetRepository {
    suspend fun getPlanets(): List<PlanetData>
}

class PlanetRepositoryImplementation : PlanetRepository {
    override suspend fun getPlanets(): List<PlanetData> {

        // return using the IO thread
        return withContext(Dispatchers.IO) {
            val retrofitClient = RetrofitClient.getClient()
            println("Hello : ${Thread.currentThread()}")
            retrofitClient.getPlanetsFromApi()
                .map { it.mapToDomain() }
        }
    }
}