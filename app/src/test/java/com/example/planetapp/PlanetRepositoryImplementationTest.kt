package com.example.planetapp

import com.example.planetapp.domain.PlanetRepository
import com.example.planetapp.domain.PlanetRepositoryImplementation
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test

class PlanetRepositoryImplementationTest {

    private lateinit var retrofitService: PlanetRetrofitService
    private var dispatcher = TestCoroutineDispatcher()
    private lateinit var planetRepo: PlanetRepository

    @Before
    fun setUp() {
        retrofitService = mockk {
            coEvery {
                getPlanetsFromApi()
            } returns emptyList()
        }
        planetRepo = PlanetRepositoryImplementation(
            retrofitService,
            dispatcher
        )
    }


    @Test
    fun getPlanetsTestNoPlanets() =
        dispatcher.runBlockingTest {
            val result = planetRepo.getPlanets()

            assertTrue(result.isEmpty())

        }

    @Test
    fun getPlanetsTestTwoPlanets() =
        dispatcher.runBlockingTest {
            coEvery {
                retrofitService.getPlanetsFromApi()
            } returns (1..2).map {
                PlanetResponse(
                    0, "Mars", "Hello Mars", 0.0, "", "", 5.6, ""
                )
            }

            val response = planetRepo.getPlanets()

            assertTrue(response.size == 2)

            assertTrue(response.get(0).name == "Mars")
            assertTrue(response.get(1).name == "Mars")

            assertTrue(response.get(0).description == "Hello Mars")
            assertTrue(response.get(1).description == "Hello Mars")

        }
}