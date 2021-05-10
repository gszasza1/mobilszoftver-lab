package com.baei7j.movier.network.api

import com.baei7j.movier.network.models.DetailedMovie
import com.baei7j.movier.network.models.MovieList
import retrofit2.Response
import retrofit2.http.*

interface MovieApi {
    @GET("movie/popular")
    suspend fun getLatestMovies(
        @Query("api_key") apiKey: String
    ): MovieList

    @GET("search/movie")
    suspend fun searchMovie(
        @Query("api_key") apiKey: String,
        @Query("query") query: String
    ): MovieList

    @GET("movie/{movie_id}")
    suspend fun getMovieById(
        @Path("movie_id") movieId: String,
        @Query("api_key") apiKey: String,

    ): DetailedMovie

    @POST("movie/favourite/{id}")
    suspend fun addFavouriteMovie(
        @Path("id") id: String,
    ): Response<Unit>

    @DELETE("movie/favourite/{id}")
    suspend fun deleteFavouriteMovie(
        @Path("id") id: String,
    ): Response<Unit>
}