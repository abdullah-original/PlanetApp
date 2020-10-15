package com.example.planetapp

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PlanetData(
    val name: String,
    val description: String
) : Parcelable