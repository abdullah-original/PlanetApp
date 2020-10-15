package com.example.planetapp

import retrofit2.http.GET

interface PlanetWebService {
    @GET("training/planets/")
    suspend fun getPlanetsFromApi(): List<PlanetResponse>
}
