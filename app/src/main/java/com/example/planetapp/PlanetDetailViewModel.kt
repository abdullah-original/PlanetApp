package com.example.planetapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PlanetDetailViewModel : ViewModel() {
    val selected = MutableLiveData<PlanetResponse>()

    fun select(item: PlanetResponse) {
        selected.value = item
    }
}