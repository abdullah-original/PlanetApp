package com.example.planetapp

interface PlanetRepository {
    suspend fun getPlanets(): List<PlanetData>
}

class PlanetRepositoryImplementation : PlanetRepository {
    override suspend fun getPlanets(): List<PlanetData> {
        val retrofitClient = RetrofitClient.getClient()

        return retrofitClient.getPlanetsFromApi().map { PlanetData(it.name, it.shortDescription) }
    }
}