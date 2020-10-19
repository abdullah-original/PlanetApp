package com.example.planetapp

import com.example.planetapp.PlanetRetrofitService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

// this class  / module is used for dependency injection (through dagger)
@Module
class NetworkModule {
    @Provides
    fun provideRetrofitService(): PlanetRetrofitService {

        return Retrofit.Builder().baseUrl("https://y3fsc8hysh.execute-api.us-east-2.amazonaws.com")
            .addConverterFactory(
                MoshiConverterFactory.create()
            )
            .build().create(PlanetRetrofitService::class.java)
    }
}