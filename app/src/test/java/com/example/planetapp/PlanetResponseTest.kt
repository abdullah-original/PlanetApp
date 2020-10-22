package com.example.planetapp

import com.example.planetapp.repository.retrofit.PlanetResponse
import org.junit.Assert.*
import org.junit.Test

class PlanetResponseTest {
    @Test
    fun mapToPlanetData() {
        val name = "Earth"
        val shortDescription = "Earth is nice"
        val planetResponse =
            PlanetResponse(
                0,
                name,
                shortDescription,
                1.0,
                ""
            )

        val planetData = planetResponse.mapToPlanetData()
        assertTrue(name == planetData.name)
        assertTrue(shortDescription == planetData.description)
    }
}