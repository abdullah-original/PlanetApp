package com.example.planetapp

data class PlanetListViewState (
    val title: String = "Planets",
    val planetResponseList: List<PlanetData>
)