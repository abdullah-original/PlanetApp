package com.example.planetapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PlanetListViewModel : ViewModel() {

    val mars = Planet("Mars", "This is Mars")
    val earth = Planet("Earth", "This is Earth")
    val mercury = Planet("Mercury", "This is Mercury")

    private val planetsArray = arrayOf(mars, earth, mercury, mars, mars, earth, mercury, earth)

    private val _viewState = MutableLiveData<PlanetListViewState>()

    val viewState: LiveData<PlanetListViewState>
        get() = _viewState

    fun start() {
        _viewState.value = PlanetListViewState(planetList = planetsArray)
    }
}