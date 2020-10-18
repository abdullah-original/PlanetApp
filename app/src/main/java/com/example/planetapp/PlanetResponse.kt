package com.example.planetapp

import android.os.Parcelable
import com.example.planetapp.domain.PlanetData
import kotlinx.android.parcel.Parcelize

// Data class used to store response from the API for the ListView

@Parcelize
data class PlanetResponse(
    val id: Int,
    val name: String,
    val shortDescription: String,
    val distanceFromSun: Double,
    val imageUrl: String
) : Parcelable {
    fun mapToPlanetData() =
        PlanetData(name, shortDescription, imageUrl, id)
}