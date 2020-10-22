package com.example.planetapp.repository

import android.content.SharedPreferences
import io.mockk.coEvery
import io.mockk.mockk
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class PreferenceRespositoryImplementationTest {

    private lateinit var pref: SharedPreferences

    private lateinit var prefRepo: PreferenceRespository

    @Before
    fun setUp() {
        pref = mockk (relaxUnitFun = true){
            coEvery {
                getStringSet(any(), any())
            } returns emptySet()
        }

        prefRepo = PreferenceRespositoryImplementation(pref)
    }

    @Test
    fun getFavouriteItemsNoItems() {
        assertTrue(prefRepo.getFavouriteItems().isEmpty())
    }

    @Test
    fun getFavouriteItems4Item() {
        val test = HashSet<String>()
        test.addAll(listOf("123", "141", "156", "67"))

        coEvery {
            pref.getStringSet(any(), any())
        } returns test

        val response = prefRepo.getFavouriteItems()
        assertTrue(response.size == 4)
        assertTrue(response.containsAll(test.map { it.toInt() }))
    }

    @Test
    fun addItemToFavourites() {
        assertTrue(prefRepo.getFavouriteItems().isEmpty())

        prefRepo.addItemToFavourites(141)

        assertTrue(prefRepo.getFavouriteItems().size == 1)
    }

    @Test
    fun removeItemFromFavourites() {
    }
}