package com.example.planetapp.repository.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.planetapp.domain.PlanetListData

// this represents the data used in List Fragment
@Entity
data class PlanetSummaryEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "shortDescription") val shortDescription: String,
    @ColumnInfo(name = "imageUrl") val imageUrl: String
) {
    fun mapToPlanetListData() = PlanetListData(name, shortDescription, imageUrl, id)
}