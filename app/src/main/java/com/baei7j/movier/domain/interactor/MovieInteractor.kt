package com.baei7j.movier.domain.interactor

import com.baei7j.movier.data.DiskDataSource
import com.baei7j.movier.data.entities.FavouriteMovie
import com.baei7j.movier.network.NetworkDataSource
import com.baei7j.movier.network.models.DetailedMovie
import com.baei7j.movier.network.models.MovieList
import javax.inject.Inject

class MovieInteractor @Inject constructor(
        private val diskDataSource: DiskDataSource,
        private val networkDataSource: NetworkDataSource
){
    fun getFavouriteList(): List<FavouriteMovie> {
        return diskDataSource.getFavouriteList()
    }
    suspend fun getLatestList(): MovieList {
        return networkDataSource.getLatestMovies()
    }
    suspend fun getMovieDetails(movieId: String): DetailedMovie {
        return networkDataSource.getMovieById(movieId)
    }
    suspend fun searchMovie(search: String): MovieList {
        return networkDataSource.searchMovie(search)
    }
    private fun insertFavouriteMovieLocally(favouriteMovie: FavouriteMovie){
        return diskDataSource.insertFavourite(favouriteMovie)
    }

    suspend fun deleteFavouriteMovieNetwork(id: String){
        return networkDataSource.deleteFavouriteMovie(id)
    }
    suspend fun insertFavouriteMovieNetwork(id: String){
        return networkDataSource.addFavouriteMovie(id)
    }
    fun deleteFavouriteMovieLocally(favouriteMovie: FavouriteMovie){
        return diskDataSource.deleteFavourite(favouriteMovie)
    }
}