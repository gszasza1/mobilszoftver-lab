package com.baei7j.movier.network

import com.baei7j.movier.network.api.IMockMovieApi
import com.baei7j.movier.network.api.MovieApi
import com.baei7j.movier.network.models.DetailedMovie
import com.baei7j.movier.network.models.MovieList
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkDataSource @Inject constructor(
    private val movieApi: MovieApi,
    private val mockMovieApi: IMockMovieApi,
) {
    private val api_key="5637779ad0397a76e1cddf7bc16c3a4d"

    suspend fun getLatestMovies(): MovieList {
        return mockMovieApi.getLatestMovies(api_key)
    }

    suspend fun searchMovie(query: String): MovieList {
       return mockMovieApi.searchMovie(api_key, query)
    }

    suspend fun getMovieById(movieId: String): DetailedMovie {
        return mockMovieApi.getMovieById(api_key, movieId)
    }

    suspend fun addFavouriteMovie(id: String) {
        return mockMovieApi.addFavouriteMovie(id)
    }

    suspend fun deleteFavouriteMovie(id: String) {
        return mockMovieApi.deleteFavouriteMovie(id)
    }
}