package com.baei7j.movier.domain.interactor

import com.baei7j.movier.data.DiskDataSource
import com.baei7j.movier.data.entities.FavouriteMovie
import com.baei7j.movier.extension.Converter
import com.baei7j.movier.network.NetworkDataSource
import com.baei7j.movier.network.models.DetailedMovie
import com.baei7j.movier.network.models.Movie
import com.baei7j.movier.network.models.MovieList
import kotlinx.coroutines.delay
import javax.inject.Inject

class MovieInteractor @Inject constructor(
        private val diskDataSource: DiskDataSource,
        private val networkDataSource: NetworkDataSource
){
    fun getFavouriteList(): List<FavouriteMovie> {
        return diskDataSource.getFavouriteList()
    }
    suspend fun getLatestList(isAsc : Boolean): List<Movie>? {
        var result = networkDataSource.getLatestMovies()
        if(!isAsc){
            result = result?.reversed()
        }
       // delay(3000L)
        return result
    }
    suspend fun getMovieDetails(movieId: String): DetailedMovie {
        return networkDataSource.getMovieById(movieId)
    }
    suspend fun searchMovie(search: String, isAsc : Boolean):List<Movie>? {
        var result = networkDataSource.searchMovie(search)
        if(!isAsc){
            result = result?.reversed()
        }
       // delay(3000L)
        return result
    }
    suspend fun insertFavouriteMovieLocally(movie: DetailedMovie){
        var result = Converter.DetailsToMovie(movie)
        return diskDataSource.insertFavourite(result)
    }
    suspend fun deleteFavouriteMovieNetwork(id: String){
        return networkDataSource.deleteFavouriteMovie(id)
    }
    suspend fun insertFavouriteMovieNetwork(id: String){
        return networkDataSource.addFavouriteMovie(id)
    }
    suspend fun deleteFavouriteMovieLocally(favouriteMovie: FavouriteMovie): List<FavouriteMovie> {
        return diskDataSource.deleteFavourite(favouriteMovie)
    }
}