package com.example.planetapp.repository

import android.content.SharedPreferences
import com.example.planetapp.R
import java.lang.Exception

class PreferenceRespositoryImplementation constructor(private val pref: SharedPreferences) :
    PreferenceRespository {

    private val key = "favourites"

    override fun getFavouriteItems(): List<Int> {
        val favourites = pref.getStringSet(key, emptySet()) ?: emptySet()

        return favourites.map { it.toInt() }.toList()
    }

    override fun addItemToFavourites(id: Int): Boolean {

        val favourites = pref.getStringSet(key, emptySet())?.toMutableSet() ?: mutableSetOf()


        if (favourites.contains(id.toString())) {
            return false
        }

        favourites.add(id.toString())
        pref.edit().putStringSet(key, favourites).apply()
        return true
    }

    override fun removeItemFromFavourites(id: Int): Boolean {

        val favourites = pref.getStringSet(key, emptySet())?.toMutableSet() ?: mutableSetOf()


        if (favourites.contains(id.toString())) {
            favourites.remove(id.toString())
            pref.edit().putStringSet(key, favourites).apply()
            return true
        }

        return false
    }
}
