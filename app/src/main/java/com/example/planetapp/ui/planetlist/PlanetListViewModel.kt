package com.example.planetapp.ui.planetlist

import android.content.Context
import android.content.SharedPreferences
import android.provider.Settings.Global.getString
import android.view.Display
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.RoomDatabase
import com.example.planetapp.R
import com.example.planetapp.domain.PlanetListData
import com.example.planetapp.domain.PlanetRepository
import com.example.planetapp.repository.PreferenceRespository
import com.example.planetapp.ui.notifications.NotificationSender
import kotlinx.coroutines.launch
import javax.inject.Inject

// viewModel should only rely on abstractions

class PlanetListViewModel @Inject constructor(
    private val planetRepository: PlanetRepository,
    private val prefRepository: PreferenceRespository,
    private val notificationSender: NotificationSender
) :
    ViewModel() {

    private val _viewState = MutableLiveData<PlanetListViewState>()


    val viewState: LiveData<PlanetListViewState>
        get() = _viewState

    fun start() {
        viewModelScope.launch {
            _viewState.value =
                PlanetListViewState(
                    planetDataList = planetRepository.getPlanets()
                        .map {

                            if (prefRepository.getFavouriteItems().contains(it.id)) {
                                it.copy(isFavourite = true)
                            } else {
                                it.copy(isFavourite = false)
                            }

                        }
                )
        }
    }

    fun changePlanetDataList(
        planetID: Int,
        currentPlanetList: List<PlanetListData>
    ): List<PlanetListData> {
        return currentPlanetList.map {
            if (it.id == planetID) {
                if (it.isFavourite) {
                    prefRepository.removeItemFromFavourites(it.id)
                    // send notification
                    notificationSender.sendNotification(
                        it.id,
                        "Removed ${it.name} from favourites!"
                    )
                } else {
                    prefRepository.addItemToFavourites(it.id)
                    // send notification
                    notificationSender.sendNotification(it.id, "Added ${it.name} to favourites!")
                }
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