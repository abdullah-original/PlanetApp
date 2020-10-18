package com.example.planetapp.domain

// Response from API is converted to this type to remove dependency and this type is used within the app
// for DetailView

data class PlanetDetailData(
    val id: Int,
    val name: String,
    val shortDescription: String,
    val distanceFromSun: Double,
    val description: String,
    val planetType: String,
    val surfaceGravity: Double,
    val imageUrl: String
)
