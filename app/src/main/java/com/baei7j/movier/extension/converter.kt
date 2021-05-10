package com.baei7j.movier.extension

import com.baei7j.movier.data.entities.FavouriteMovie
import com.baei7j.movier.network.models.DetailedMovie

class Converter {

    companion object{

     fun DetailsToMovie(movie:DetailedMovie) : FavouriteMovie{
        return FavouriteMovie(
            vote_average = movie.vote_average!!.toLong(),
            title = movie.title!!,
            release_date = movie.release_date!!,
            popularity = movie.popularity!!.toLong(),
            overview = movie.overview!!,
            original_title = movie.original_title!!,
            original_language = movie.original_language!!,
            movieId = null
        )
     }
    }
}