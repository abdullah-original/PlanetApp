package com.example.planetapp

data class PlanetDetailViewState(
    val id: Int,
    val name: String,
    val shortDescription: String,
    val distanceFromSun: Double,
    val description: String,
    val planetType: String,
    val surfaceGravity: Double,
    val imageUrl: String
)