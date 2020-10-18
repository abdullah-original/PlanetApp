package com.example.planetapp.domain

import com.example.planetapp.PlanetDetailResponse
import com.example.planetapp.PlanetDetailViewState
import com.example.planetapp.PlanetRetrofitService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

interface PlanetRepository {
    suspend fun getPlanets(): List<PlanetData>
    suspend fun getPlanetsById(id: Int): PlanetDetailData
}

