package com.baei7j.movier.ui.details

import co.zsmb.rainbowcake.withIOContext
import com.baei7j.movier.data.entities.FavouriteMovie
import com.baei7j.movier.domain.interactor.MovieInteractor
import javax.inject.Inject

class DetailsPresenter @Inject constructor(private val movieInteractor: MovieInteractor) {


    suspend fun insertNetwork(id: String) = withIOContext {
        return@withIOContext movieInteractor.insertFavouriteMovieNetwork(id)
    }
    suspend fun insertLocally(favouriteMovie: FavouriteMovie) = withIOContext {
        return@withIOContext movieInteractor.insertFavouriteMovieLocally(favouriteMovie)
    }
    suspend fun getById(id: String) = withIOContext {
        return@withIOContext movieInteractor.getMovieDetails(id)
    }
}
