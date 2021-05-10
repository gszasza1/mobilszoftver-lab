package com.baei7j.movier.network

import android.util.Log
import com.baei7j.movier.network.api.IMockMovieApi
import com.baei7j.movier.network.api.MovieApi
import com.baei7j.movier.network.models.DetailedMovie
import com.baei7j.movier.network.models.Movie
import com.baei7j.movier.network.models.MovieList
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkDataSource @Inject constructor(
    private val movieApi: MovieApi,
   // private val mockMovieApi: IMockMovieApi,
) {
    private val apiKey = "5637779ad0397a76e1cddf7bc16c3a4d"

    suspend fun getLatestMovies(): List<Movie>?{
        var result = movieApi.getLatestMovies(apiKey)
        var toList = result.results?.toList()
        return toList
    }

    suspend fun searchMovie(query: String): List<Movie>? {
        var result = movieApi.searchMovie(apiKey, query).results?.toList()
        return result
    }

    suspend fun getMovieById(movieId: String): DetailedMovie {
        var result = movieApi.getMovieById(movieId, apiKey)
        return result
    }

    suspend fun addFavouriteMovie(id: String)  : Response<Unit> {
      //  return mockMovieApi.addFavouriteMovie(id)
        return Response.success(Unit)
    }

    suspend fun deleteFavouriteMovie(id: String): Response<Unit> {
       // return mockMovieApi.deleteFavouriteMovie(id)
        return Response.success(Unit)
    }
}