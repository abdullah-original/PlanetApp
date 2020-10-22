package com.example.planetapp.di

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.planetapp.repository.PlanetRepositoryImplementation
import com.example.planetapp.repository.retrofit.PlanetRetrofitService
import com.example.planetapp.domain.PlanetRepository
import com.example.planetapp.repository.PreferenceRespository
import com.example.planetapp.repository.PreferenceRespositoryImplementation
import com.example.planetapp.repository.database.AppDatabase
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers

// this class  / module is used for dependency injection (through dagger)

@Module
class RepositoryModule {
    @Provides
    fun providePlanetRepository(planetRetrofitService: PlanetRetrofitService, roomDatabase: AppDatabase): PlanetRepository {
        return PlanetRepositoryImplementation(
            planetRetrofitService,
            Dispatchers.IO,
            roomDatabase.planetEntityDao()
        )
    }

    @Provides
    fun providePreferenceRepository(context: Context): PreferenceRespository {
        return PreferenceRespositoryImplementation(context.getSharedPreferences("wut", Context.MODE_PRIVATE))
    }

    @Provides
    fun provideRoomRepository(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "planets_database").build()
    }

}