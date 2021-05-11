package com.baei7j.movier

import com.baei7j.movier.domain.interactor.MovieInteractor
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Before
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters
import org.robolectric.RobolectricTestRunner
import javax.inject.Inject

@ExperimentalCoroutinesApi
@RunWith(RobolectricTestRunner::class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class MovieInteractorTest {
    @Inject
    lateinit var
            movieInteractor: MovieInteractor

    @Before
    fun setup() {
        injectorOfTests.inject(this)
    }
    @Test
    fun `get latest movie`() = runBlockingTest {
        val result = movieInteractor.getLatestList(true)
        Assert.assertEquals(result?.size, 4)
    }
    @Test
    fun `search movie`() = runBlockingTest {
        val result = movieInteractor.searchMovie("",true)
        Assert.assertEquals(result?.size, 4)
    }
    @Test
    fun `get fevourite movies`() = runBlockingTest {
        val result = movieInteractor.getFavouriteList()
        Assert.assertEquals(result?.size, 2)
    }

    @Test
    fun `delete movie`() = runBlockingTest {
        val result = movieInteractor.deleteFavouriteMovieNetwork("2")
        Assert.assertEquals(result, true)
    }
    @Test
    fun `insert movie`() = runBlockingTest {
        val result = movieInteractor.insertFavouriteMovieNetwork("2")
        Assert.assertEquals(result, true)
    }

    @Test
    fun `get detailed movie`() = runBlockingTest {
        val result = movieInteractor.getMovieDetails("1")
        Assert.assertEquals(result.id!!.toLong(), 1)
        Assert.assertEquals(result.adult, false)
        Assert.assertEquals(result.tagline, "Ezsincs")
        Assert.assertEquals(result.status, "Kész")
        Assert.assertEquals(result.revenue , 2000000.toLong())
        Assert.assertEquals(result.runtime!!.toLong() , 200.toLong())
        Assert.assertEquals(result.original_language , "Hun")
        Assert.assertEquals(result.original_title ,"Zanzibál ketto")
        Assert.assertEquals(result.title ,"Zanzibál 2")
    }
}