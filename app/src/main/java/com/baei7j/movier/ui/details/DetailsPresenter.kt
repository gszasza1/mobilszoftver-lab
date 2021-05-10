package com.baei7j.movier.ui.details

import co.zsmb.rainbowcake.withIOContext
import com.baei7j.movier.data.entities.FavouriteMovie
import com.baei7j.movier.domain.interactor.MovieInteractor
import com.baei7j.movier.network.models.DetailedMovie
import com.baei7j.movier.network.models.Movie
import javax.inject.Inject

class DetailsPresenter @Inject constructor(private val movieInteractor: MovieInteractor) {


    suspend fun insertNetwork(movieId: String) = withIOContext {
        return@withIOContext movieInteractor.insertFavouriteMovieNetwork(movieId)
    }
    suspend fun insertLocally(movie: DetailedMovie) = withIOContext {
        return@withIOContext movieInteractor.insertFavouriteMovieLocally(movie)
    }
    suspend fun getById(id: String) = withIOContext {
        return@withIOContext movieInteractor.getMovieDetails(id)
    }
}
