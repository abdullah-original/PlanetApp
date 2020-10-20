package com.example.planetapp.repository.retrofit


import android.os.Parcelable
import com.example.planetapp.domain.PlanetDetailData
import kotlinx.android.parcel.Parcelize


// Data class used to store API response from API for detail view


@Parcelize
data class PlanetDetailResponse(
    val id: Int,
    val name: String,
    val shortDescription: String,
    val distanceFromSun: Double,
    val description: String,
    val planetType: String,
    val surfaceGravity: Double,
    val imageUrl: String
) : Parcelable {
    fun mapToDomain() = PlanetDetailData(
        id,
        name,
        shortDescription,
        distanceFromSun,
        description,
        planetType,
        surfaceGravity,
        imageUrl
    )
}