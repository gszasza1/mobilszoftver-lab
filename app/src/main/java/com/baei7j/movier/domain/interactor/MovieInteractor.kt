package com.baei7j.movier.domain.interactor

import android.content.Context
import com.baei7j.movier.data.AppDatabase
import com.baei7j.movier.data.entities.FavouriteMovie
import javax.inject.Inject

class MovieInteractor @Inject constructor(
        private val context: Context
){
    fun getFavouriteList(): List<FavouriteMovie> {
        return AppDatabase.getInstance(context).favouriteMovieDao().getFavouriteMovies()
    }
}