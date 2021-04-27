package com.baei7j.movier.data

import com.baei7j.movier.data.entities.FavouriteMovie
import kotlinx.coroutines.delay

class DiskDataMock : IMockFavouriteMovieDAO {
    override fun getFavouriteMovies(): List<FavouriteMovie> {
        return listOf(
            FavouriteMovie(
                movieId=1,
                original_language = "Hun",
                original_title = "Szilaj",
                overview = "A pacis film régről",
                popularity = 3,
                release_date = "2000.20.20",
                title = "Altináj",
                vote_average = 200),
            FavouriteMovie(
                movieId=2,
                original_language = "De",
                original_title = "Fast and Fat",
                overview = "Majdnem megvan a címe az autós filmnek",
                popularity = 3,
                release_date = "2000.20.23",
                title = "Skyline",
                vote_average = 200)
        )
    }

    override fun getSpecificFavouriteMovie(movieId: Long): FavouriteMovie {
        return FavouriteMovie(
            movieId=1,
            original_language = "Hun",
            original_title = "Szilaj",
            overview = "A pacis film régről",
            popularity = 3,
            release_date = "2000.20.20",
            title = "Altináj",
            vote_average = 200)
    }

    override suspend fun insertFavouriteMovie(vararg movie: FavouriteMovie) {
        delay(2000)
    }

    override suspend fun deleteFavouriteMovie(movie: FavouriteMovie) {
       delay(2000)
    }
}