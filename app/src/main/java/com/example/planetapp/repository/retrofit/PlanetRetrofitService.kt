package com.example.planetapp.repository.retrofit

import retrofit2.http.GET
import retrofit2.http.Path

interface PlanetRetrofitService {
    @GET("training/planets/")
    suspend fun getPlanetsFromApi(): List<PlanetResponse>

    @GET("training/planets/{id}")
    suspend fun getPlanetsFromApiById(@Path("id") id: Int): PlanetDetailResponse
}
