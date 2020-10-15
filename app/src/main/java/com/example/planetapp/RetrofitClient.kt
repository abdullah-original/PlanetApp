package com.example.planetapp

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitClient {
    fun getClient(): PlanetWebService {
        return Retrofit.Builder().baseUrl("https://y3fsc8hysh.execute-api.us-east-2.amazonaws.com/")
            .addConverterFactory(
                MoshiConverterFactory.create()
            )
            .build().create(PlanetWebService::class.java)
    }
}