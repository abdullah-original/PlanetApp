package com.example.planetapp.repository;

// high level interface to access preferences
// this is because underlying implementation can change from shared preferences
// to something else e.g. a database or web server etc.

interface PreferenceRespository {
    fun getFavouriteItems() : List<Int>

    fun addItemToFavourites(id: Int): Boolean

    fun removeItemFromFavourites(id: Int): Boolean
}
