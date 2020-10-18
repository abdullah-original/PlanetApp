package com.example.planetapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.planetapp.domain.PlanetRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PlanetListViewModel : ViewModel() {

    private val planetRepository: PlanetRepository =
        PlanetRepositoryImplementation(
            RetrofitClient.getClient(),
            Dispatchers.IO
        )


    private val _viewState = MutableLiveData<PlanetListViewState>()

    val viewState: LiveData<PlanetListViewState>
        get() = _viewState

    fun start() {
        viewModelScope.launch {
            _viewState.value = PlanetListViewState(planetResponseList = planetRepository.getPlanets())
        }
    }
}