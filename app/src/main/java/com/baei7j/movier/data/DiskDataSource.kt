package com.baei7j.movier.data

import android.content.Context
import com.baei7j.movier.data.entities.FavouriteMovie
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DiskDataSource @Inject constructor(
        private val context: Context
) {
    fun getFavouriteList(): List<FavouriteMovie> {
        return AppDatabase.getInstance(context).favouriteMovieDao().getFavouriteMovies()
    }

    fun deleteFavourite(favouriteMovie: FavouriteMovie){
        return AppDatabase.getInstance(context).favouriteMovieDao().deleteFavouriteMovie(favouriteMovie)
    }

    fun insertFavourite(favouriteMovie: FavouriteMovie){
        return AppDatabase.getInstance(context).favouriteMovieDao().insertFavouriteMovie(favouriteMovie)
    }
}