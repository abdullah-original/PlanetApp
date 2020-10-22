package com.example.planetapp.repository.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(PlanetSummaryEntity::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun planetEntityDao(): PlanetDao
}