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
        return favouriteMovieDAO.getFavouriteMovies()
    }

    suspend fun deleteFavourite(favouriteMovie: FavouriteMovie): List<FavouriteMovie>{
        favouriteMovieDAO.deleteFavouriteMovie(favouriteMovie)
        return this.getFavouriteList()
    }

    suspend fun insertFavourite(favouriteMovie: FavouriteMovie){
        return  favouriteMovieDAO.insertFavouriteMovie(favouriteMovie)
    }
}