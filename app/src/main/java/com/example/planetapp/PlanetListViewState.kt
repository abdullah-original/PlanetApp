package com.example.planetapp

import com.example.planetapp.domain.PlanetData

data class PlanetListViewState (
    val title: String = "Planets",
    val planetResponseList: List<PlanetData>
)