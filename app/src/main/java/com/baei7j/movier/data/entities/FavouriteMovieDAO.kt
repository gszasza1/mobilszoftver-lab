package com.baei7j.movier.data.entities

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FavouriteMovieDAO {

    @Query("SELECT * FROM favourite_movie")
    fun getFavouriteMovies(): List<FavouriteMovie>
    @Query("SELECT * FROM favourite_movie WHERE movieId = :movieId")
    fun getSpecificFavouriteMovie(movieId: Long): FavouriteMovie
    @Insert
    suspend fun insertFavouriteMovie(vararg movie: FavouriteMovie)
    @Delete
    suspend fun deleteFavouriteMovie(movie: FavouriteMovie)
}