package com.example.planetapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PlanetDetailViewModel : ViewModel() {
    val selected = MutableLiveData<Planet>()

    fun select(item: Planet) {
        selected.value = item
    }
}