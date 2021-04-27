package com.baei7j.movier.data

import com.baei7j.movier.data.entities.FavouriteMovie
import com.baei7j.movier.data.entities.FavouriteMovieDAO
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DiskDataSource @Inject constructor(
        private val favouriteMovieDAO: FavouriteMovieDAO,
        private val mockfavouriteMovieDAO: IMockFavouriteMovieDAO
) {
    fun getFavouriteList(): List<FavouriteMovie> {
        return mockfavouriteMovieDAO.getFavouriteMovies()
    }

    suspend fun deleteFavourite(favouriteMovie: FavouriteMovie){
        return mockfavouriteMovieDAO.deleteFavouriteMovie(favouriteMovie)
    }

    suspend fun insertFavourite(favouriteMovie: FavouriteMovie){
        return mockfavouriteMovieDAO.insertFavouriteMovie(favouriteMovie)
    }
}