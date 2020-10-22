package com.example.planetapp.repository.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PlanetDao {
    @Query("select * from planetsummaryentity")
    fun getAllPlanets(): List<PlanetSummaryEntity>


    @Insert
    fun insertAll(planets: List<PlanetSummaryEntity>)
}