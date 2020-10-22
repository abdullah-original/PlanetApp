package com.example.planetapp

import com.example.planetapp.domain.PlanetRepository
import com.example.planetapp.repository.PlanetRepositoryImplementation
import com.example.planetapp.repository.database.PlanetDao
import com.example.planetapp.repository.database.PlanetSummaryEntity
import com.example.planetapp.repository.retrofit.PlanetResponse
import com.example.planetapp.repository.retrofit.PlanetRetrofitService
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import org.mockito.Mock

class PlanetRepositoryImplementationTest {

    private lateinit var retrofitService: PlanetRetrofitService
    private var dispatcher = TestCoroutineDispatcher()
    private lateinit var planetRepo: PlanetRepository
    private lateinit var planetDao: PlanetDao

    @Before
    fun setUp() {
        retrofitService = mockk {
            coEvery {
                getPlanetsFromApi()
            } returns emptyList()
        }

        planetDao = mockk (relaxUnitFun = true) {
            coEvery {
                getAllPlanets()
            } returns emptyList()
        }

        planetRepo =
            PlanetRepositoryImplementation(
                retrofitService,
                dispatcher,
                planetDao
            )
    }

    @Test
    fun getPlanetsApiNotCalled() = dispatcher.runBlockingTest {
        coEvery {
            planetDao.getAllPlanets()
        } returns listOf(
            PlanetSummaryEntity(141, "Earth", "Homeland", "")
        )

        planetRepo.getPlanets()

        coVerify(exactly = 0) {
            retrofitService.getPlanetsFromApi()
        }
    }


    @Test
    fun getPlanetsApiIsCalled() = dispatcher.runBlockingTest {
        coEvery {
            planetDao.getAllPlanets()
        } returns emptyList()

        planetRepo.getPlanets()

        coVerify(exactly = 1) {
            retrofitService.getPlanetsFromApi()
        }

    }

    @Test
    fun getPlanetsTestTwoPlanets() =
        dispatcher.runBlockingTest {
            coEvery {
                retrofitService.getPlanetsFromApi()
            } returns (1..2).map {
                PlanetResponse(
                    0, "Mars", "Hello Mars", 0.0, ""
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