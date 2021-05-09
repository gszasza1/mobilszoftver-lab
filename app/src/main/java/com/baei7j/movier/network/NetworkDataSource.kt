package com.baei7j.movier.network

import com.baei7j.movier.network.api.IMockMovieApi
import com.baei7j.movier.network.api.MovieApi
import com.baei7j.movier.network.models.DetailedMovie
import com.baei7j.movier.network.models.Movie
import com.baei7j.movier.network.models.MovieList
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkDataSource @Inject constructor(
    private val movieApi: MovieApi,
    private val mockMovieApi: IMockMovieApi,
) {
    private val apiKey = "5637779ad0397a76e1cddf7bc16c3a4d"

    suspend fun getLatestMovies(): List<Movie>?{
        var result = movieApi.getLatestMovies(apiKey)
        var toList = result.results?.toList()
        return toList
    }

    suspend fun searchMovie(query: String): List<Movie>? {
       return movieApi.searchMovie(apiKey, query).results?.toList()
    }

    suspend fun getMovieById(movieId: String): DetailedMovie {
        return movieApi.getMovieById(apiKey, movieId)
    }

    suspend fun addFavouriteMovie(id: String) {
        return mockMovieApi.addFavouriteMovie(id)
    }

    suspend fun deleteFavouriteMovie(id: String) {
        return mockMovieApi.deleteFavouriteMovie(id)
    }
}