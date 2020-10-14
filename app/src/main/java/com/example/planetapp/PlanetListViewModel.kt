package com.example.planetapp

import androidx.lifecycle.ViewModel

class PlanetListViewModel : ViewModel() {

    val mars = Planet("Mars", "This is Mars")
    val earth = Planet("Earth", "This is Earth")
    val mercury = Planet("Mercury", "This is Mercury")

    val planetsArray = arrayOf(mars, earth, mercury, mars, mars, earth, mercury, earth)

    val viewState = PlanetListViewState(planetList =  planetsArray)
}