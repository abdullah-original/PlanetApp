package com.example.planetapp.repository

import androidx.room.RoomDatabase
import com.example.planetapp.domain.PlanetListData
import com.example.planetapp.domain.PlanetDetailData
import com.example.planetapp.domain.PlanetRepository
import com.example.planetapp.repository.database.PlanetDao
import com.example.planetapp.repository.database.PlanetSummaryEntity
import com.example.planetapp.repository.retrofit.PlanetResponse
import com.example.planetapp.repository.retrofit.PlanetRetrofitService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.lang.Exception

class PlanetRepositoryImplementation(
    val service: PlanetRetrofitService,
    val dispatcher: CoroutineDispatcher,
    val planetDao: PlanetDao
) : PlanetRepository {
    override suspend fun getPlanets(): List<PlanetListData> {


        // return using the IO thread
        return withContext(dispatcher) {

            val planetsFromDatabase = planetDao.getAllPlanets()

            if (planetsFromDatabase.isEmpty()) {
                val retrofitClient = service
                // println("Hello : ${Thread.currentThread()}")

                lateinit var planetsFromApi: List<PlanetResponse>

                try {
                    planetsFromApi = retrofitClient.getPlanetsFromApi()
                } catch (e: Exception) {
                    println(e)
                    println("hello there")
                    return@withContext emptyList<PlanetListData>()
                }
                // update the database
                val planetsFromApiToEntity = planetsFromApi.map {
                    PlanetSummaryEntity(it.id, it.name, it.shortDescription, it.imageUrl)
                }
                planetDao.insertAll(planetsFromApiToEntity)

                // return List<PlanetData>
                planetsFromApi.map { it.mapToPlanetData() }
            } else {
                planetsFromDatabase.map { it.mapToPlanetListData() }
            }

        }
    }

    override suspend fun getPlanetsById(id: Int): PlanetDetailData {
        return withContext(dispatcher) {
            val retrofitClient = service
            retrofitClient.getPlanetsFromApiById(id).mapToDomain()
        }
    }
}