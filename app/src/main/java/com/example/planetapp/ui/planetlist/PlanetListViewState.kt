package com.example.planetapp.ui.planetlist

import com.example.planetapp.domain.PlanetListData

data class PlanetListViewState (
    val title: String = "Planets",
    val planetDataList: List<PlanetListData>
)