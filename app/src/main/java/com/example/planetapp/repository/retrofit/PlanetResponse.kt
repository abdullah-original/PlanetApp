package com.example.planetapp.repository.retrofit

import android.os.Parcelable
import com.example.planetapp.domain.PlanetListData
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
        PlanetListData(name, shortDescription, imageUrl, id)
}