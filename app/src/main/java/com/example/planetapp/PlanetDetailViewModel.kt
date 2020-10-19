package com.example.planetapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.planetapp.domain.PlanetRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class PlanetDetailViewModel @Inject constructor(private val planetRepository: PlanetRepository) :
    ViewModel() {

    // reference to planetRespository so we can fetch data
    // private val planetRepository: PlanetRepository =
    //     PlanetRepositoryImplementation(
    //         RetrofitClient.getClient(),
    //         Dispatchers.IO
    //     )

    private val _viewState = MutableLiveData<PlanetDetailViewState>()

    val viewState: LiveData<PlanetDetailViewState>
        get() = _viewState

    fun fetchPlanet(id: Int) {
        viewModelScope.launch {
            val result = planetRepository.getPlanetsById(id)
            _viewState.value =
                PlanetDetailViewState(
                    result.id,
                    result.name,
                    result.shortDescription,
                    result.distanceFromSun,
                    result.description,
                    result.planetType,
                    result.surfaceGravity,
                    result.imageUrl
                )
        }
    }

}