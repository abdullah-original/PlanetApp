package com.example.planetapp

import com.example.planetapp.domain.PlanetData
import com.example.planetapp.domain.PlanetDetailData
import com.example.planetapp.domain.PlanetRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class PlanetRepositoryImplementation(
    val service: PlanetRetrofitService,
    val dispatcher: CoroutineDispatcher
) : PlanetRepository {
    override suspend fun getPlanets(): List<PlanetData> {

        // return using the IO thread
        return withContext(dispatcher) {
            val retrofitClient = service
//            println("Hello : ${Thread.currentThread()}")
            retrofitClient.getPlanetsFromApi()
                .map { it.mapToPlanetData() }
        }
    }

    override suspend fun getPlanetsById(id: Int): PlanetDetailData {
        return withContext(dispatcher) {
            val retrofitClient = service
            retrofitClient.getPlanetsFromApiById(id).mapToDomain()
        }
    }
}