package com.example.planetapp.domain

// this provides a high level interface to the application for fetching data
// hence it belongs to the domain
interface PlanetRepository {
    suspend fun getPlanets(): List<PlanetListData>
    suspend fun getPlanetsById(id: Int): PlanetDetailData
}

