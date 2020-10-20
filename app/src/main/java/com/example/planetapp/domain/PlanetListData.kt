package com.example.planetapp.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

// Response from API is converted to this type to remove dependency and this type is used within the app
// for ListView

@Parcelize
data class PlanetListData(
    val name: String,
    val description: String,
    val imageURL: String = "",
    val id: Int,
    val isFavourite: Boolean = false
) : Parcelable