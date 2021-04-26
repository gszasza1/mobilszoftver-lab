package com.baei7j.movier.ui.favourites

import co.zsmb.rainbowcake.withIOContext
import com.baei7j.movier.data.entities.FavouriteMovie
import com.baei7j.movier.domain.interactor.MovieInteractor
import javax.inject.Inject

class FavouritesPresenter @Inject constructor(private val movieInteractor: MovieInteractor) {

    suspend fun getData(): String = withIOContext {
        ""
    }
    suspend fun getAllFavourtieMovies(): MutableList<FavouriteMovie> = withIOContext {
        return@withIOContext movieInteractor.getFavouriteList().toMutableList()
    }
    suspend fun deleteFavouriteMovies(favouriteMovie: FavouriteMovie) = withIOContext {
        return@withIOContext movieInteractor.deleteFavouriteMovieNetwork(favouriteMovie)
    }


}
