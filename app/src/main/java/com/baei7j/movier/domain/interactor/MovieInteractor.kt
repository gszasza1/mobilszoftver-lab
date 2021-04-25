package com.baei7j.movier.domain.interactor

import com.baei7j.movier.data.DiskDataSource
import com.baei7j.movier.data.entities.FavouriteMovie
import javax.inject.Inject

class MovieInteractor @Inject constructor(
        private val diskDataSource: DiskDataSource
){
    fun getFavouriteList(): List<FavouriteMovie> {
        return diskDataSource.getFavouriteList()
    }
    fun insertFavouriteMovieLocally(favouriteMovie: FavouriteMovie){
        return diskDataSource.insertFavourite(favouriteMovie);
    }
    fun deleteFavouriteMovieLocally(favouriteMovie: FavouriteMovie){
        return diskDataSource.deleteFavourite(favouriteMovie);
    }
}