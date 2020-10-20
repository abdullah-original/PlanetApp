package com.example.planetapp.repository

import com.example.planetapp.domain.PlanetListData
import com.example.planetapp.domain.PlanetDetailData
import com.example.planetapp.domain.PlanetRepository
import com.example.planetapp.repository.retrofit.PlanetRetrofitService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class PlanetRepositoryImplementation(
    val service: PlanetRetrofitService,
    val dispatcher: CoroutineDispatcher
) : PlanetRepository {
    override suspend fun getPlanets(): List<PlanetListData> {

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