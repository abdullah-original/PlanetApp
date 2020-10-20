package com.example.planetapp.ui.planetlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.planetapp.domain.PlanetListData
import com.example.planetapp.domain.PlanetRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class PlanetListViewModel @Inject constructor(private val planetRepository: PlanetRepository) :
    ViewModel() {

    private val _viewState = MutableLiveData<PlanetListViewState>()

    val viewState: LiveData<PlanetListViewState>
        get() = _viewState

    fun start() {
        viewModelScope.launch {
            _viewState.value =
                PlanetListViewState(
                    planetDataList = planetRepository.getPlanets()
                )
        }
    }

    fun changePlanetDataList(
        planetID: Int,
        currentPlanetList: List<PlanetListData>
    ): List<PlanetListData> {
        return currentPlanetList.map {
            if (it.id == planetID) {
                it.copy(isFavourite = !it.isFavourite)
            } else {
                it
            }
        }
    }

    // change isFavourite value when heart image is clicked
    fun handleFavouriteIntent(planetID: Int) {

        // this is the same as below
        // _viewState.value = if (_viewState.value != null) {
        //     _viewState.value!!.copy(
        //         planetDataList = changePlanetDataList(
        //             planetID,
        //             _viewState.value!!.planetDataList
        //         )
        //     )
        // } else {
        //     null
        // }

        // new viewState has to be created for every UI interaction that causes a viewState change
        _viewState.value = _viewState.value?.let {
            it.copy(planetDataList = changePlanetDataList(planetID, it.planetDataList))
        }
    }
}