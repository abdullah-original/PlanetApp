package com.example.planetapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class PlanetListViewModel : ViewModel() {

    private val planetRepository: PlanetRepository = PlanetRepositoryImplementation()


    private val _viewState = MutableLiveData<PlanetListViewState>()

    val viewState: LiveData<PlanetListViewState>
        get() = _viewState

    fun start() {
        viewModelScope.launch {
            _viewState.value = PlanetListViewState(planetResponseList = planetRepository.getPlanets())
        }
    }
}