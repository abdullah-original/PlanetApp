package com.example.planetapp

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitClient {

    private fun debugInterceptor(): Interceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    fun getClient(): PlanetRetrofitService {
        val client = OkHttpClient.Builder().addInterceptor(debugInterceptor()).build()
        return Retrofit.Builder().baseUrl("https://y3fsc8hysh.execute-api.us-east-2.amazonaws.com")
            .addConverterFactory(
                MoshiConverterFactory.create()
            ).client(client)
            .build().create(PlanetRetrofitService::class.java)
    }
}