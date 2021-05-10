package com.baei7j.movier

import co.zsmb.rainbowcake.test.assertObserved
import co.zsmb.rainbowcake.test.base.ViewModelTest
import co.zsmb.rainbowcake.test.observeStateAndEvents
import com.baei7j.movier.data.entities.FavouriteMovie
import com.baei7j.movier.network.models.Movie
import com.baei7j.movier.ui.favourites.FavouritesPresenter
import com.baei7j.movier.ui.favourites.FavouritesReady
import com.baei7j.movier.ui.favourites.FavouritesViewModel
import com.baei7j.movier.ui.list.ListPresenter
import com.baei7j.movier.ui.list.ListReady
import com.baei7j.movier.ui.list.ListViewModel
import com.baei7j.movier.ui.list.Loading
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.stub
import com.baei7j.movier.ui.favourites.Loading as FavourteiLoading

@ExperimentalCoroutinesApi
class MovieViewModelTest : ViewModelTest() {

    private lateinit var mockedListPresenter: ListPresenter
    private lateinit var mockedFavouritePresenter: FavouritesPresenter

    @Before
    fun setup() {
        mockedListPresenter = mock()
        mockedFavouritePresenter = mock()

        mockedListPresenter.stub {
            onBlocking { getLatestMovies(true) } doReturn mockedListMovie
        }

        mockedFavouritePresenter.stub {
            onBlocking { getAllFavourtieMovies() } doReturn mockedFavouriteList
        }
    }

    @Test
    fun `get data from datasource`() = runBlockingTest {
        val favouriteViewModel = FavouritesViewModel(mockedFavouritePresenter)
        favouriteViewModel.observeStateAndEvents { stateObserver, _ ->
            favouriteViewModel.loadFavourites()

            val list = mockedFavouriteList
            stateObserver.assertObserved(
                    FavourteiLoading,
                    FavouritesReady(
                            data = list
                    )
            )
        }
    }

    @Test
    fun `get data from network`() = runBlockingTest {
        val listViewModel = ListViewModel(mockedListPresenter)
        listViewModel.observeStateAndEvents { stateObserver, _ ->
            listViewModel.loadLatest(true)

            val list = mockedListMovie
            stateObserver.assertObserved(
                    Loading,
                    ListReady(data= listOf()),
                    ListReady(
                            data = list
                    )
            )
        }
    }

    companion object {
        val mockedListMovie = listOf(
                Movie(
                        adult = false,
                        backdrop_path = "Nincs",
                        genre_ids = arrayOf(1, 2, 3),
                        id = 1,
                        original_language = "Hun",
                        original_title = "Zanzibál324",
                        overview = "A Zanzibál egy nagyon remek filmecske. Tessék csak meglesni",
                        popularity = 4.0,
                        poster_path = "",
                        release_date = "2020.12.12",
                        title = "Zanzibál234234, a kezdetek",
                        video = false,
                        vote_average = 2.0,
                        vote_count = 4000.0
                ),
                Movie(
                        adult = false,
                        backdrop_path = "Nincs",
                        genre_ids = arrayOf(1, 2, 3),
                        id = 1,
                        original_language = "Hun",
                        original_title = "Zanzibál132",
                        overview = "A Zanzibál egy nagyon remek filmecske. Tessék csak meglesni",
                        popularity = 4.0,
                        poster_path = "",
                        release_date = "2020.12.12",
                        title = "Zanzibál675, a kezdetek",
                        video = false,
                        vote_average = 2.0,
                        vote_count = 4000.0
                ))

        val mockedFavouriteList = listOf(
                FavouriteMovie(
                        movieId = 1,
                        original_language = "Hun",
                        original_title = "Szilaj",
                        overview = "A pacis film régről",
                        popularity = 3,
                        release_date = "2000.20.20",
                        title = "Altináj",
                        vote_average = 200),
                FavouriteMovie(
                        movieId = 2,
                        original_language = "De",
                        original_title = "Fast and Fat",
                        overview = "Majdnem megvan a címe az autós filmnek",
                        popularity = 3,
                        release_date = "2000.20.23",
                        title = "Skyline",
                        vote_average = 200)
        )
    }
}