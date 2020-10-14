package com.example.planetapp

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Planet (
    val name: String,
    val description: String
) : Parcelable