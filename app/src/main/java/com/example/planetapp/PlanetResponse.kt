package com.example.planetapp

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PlanetResponse(
    val id: Int,
    val name: String,
    val shortDescription: String,
    val distanceFromSun: Double,
    val description: String,
    val planetType: String,
    val surfaceGravity: Double,
    val imageURl: String
) : Parcelable {
    fun mapToDomain () = PlanetData(name, shortDescription)
}