package com.baei7j.movier.mock

import com.baei7j.movier.network.api.MovieApi
import com.baei7j.movier.network.models.*
import kotlinx.coroutines.delay
import retrofit2.Response
import javax.inject.Inject

class MockMovieApi @Inject constructor() : MovieApi {
    private val movieList = MovieList(
            page = 1,
            total_pages = 1,
            results = arrayOf<Movie>(Movie(
                    adult = false,
                    backdrop_path = "Nincs",
                    genre_ids = arrayOf(1,2,3),
                    id = 1,
                    original_language = "Hun",
                    original_title = "Zanzibál1",
                    overview = "A Zanzibál egy nagyon remek filmecske. Tessék csak meglesni",
                    popularity = 4.0,
                    poster_path="",
                    release_date = "2020.12.12",
                    title = "Zanzibál, a kezdetek",
                    video = false,
                    vote_average = 2.0,
                    vote_count = 4000.0
            ), Movie(
                    adult = false,
                    backdrop_path = "Nincs",
                    genre_ids = arrayOf(1,2,3),
                    id = 1,
                    original_language = "Hun",
                    original_title = "Zanzibál12",
                    overview = "A Zanzibál egy nagyon remek filmecske. Tessék csak meglesni",
                    popularity = 4.0,
                    poster_path="",
                    release_date = "2020.12.12",
                    title = "Zanzibál1, a kezdetek",
                    video = false,
                    vote_average = 2.0,
                    vote_count = 4000.0
            ), Movie(
                    adult = false,
                    backdrop_path = "Nincs",
                    genre_ids = arrayOf(1,2,3),
                    id = 1,
                    original_language = "Hun",
                    original_title = "Zanzibál324",
                    overview = "A Zanzibál egy nagyon remek filmecske. Tessék csak meglesni",
                    popularity = 4.0,
                    poster_path="",
                    release_date = "2020.12.12",
                    title = "Zanzibál234234, a kezdetek",
                    video = false,
                    vote_average = 2.0,
                    vote_count = 4000.0
            ), Movie(
                    adult = false,
                    backdrop_path = "Nincs",
                    genre_ids = arrayOf(1,2,3),
                    id = 1,
                    original_language = "Hun",
                    original_title = "Zanzibál132",
                    overview = "A Zanzibál egy nagyon remek filmecske. Tessék csak meglesni",
                    popularity = 4.0,

                    poster_path="",                    release_date = "2020.12.12",
                    title = "Zanzibál675, a kezdetek",
                    video = false,
                    vote_average = 2.0,
                    vote_count = 4000.0
            )),
            total_results = 4,

            )
    override suspend fun getLatestMovies(apiKey: String): MovieList {
        return movieList
    }

    override suspend fun searchMovie(apiKey: String, query: String): MovieList {
        return movieList
    }
    override suspend fun getMovieById(apiKey: String, movieId: String): DetailedMovie {
        return DetailedMovie(
                vote_count = 3,
                vote_average = 3.0,
                video = false,
                title = "Zanzibál 2",
                release_date = "2020.12.12",
                poster_path="",
                popularity = 2.0,
                overview = "Zanzibál Afrikába fut",
                original_title = "Zanzibál ketto",
                original_language = "Hun",
                id = 1,
                backdrop_path = "Nincs",
                adult = false,
                belongs_to_collection = "",
                budget = 20000,
                genres = arrayOf(Genre(name = "romance",id = 1)),
                homepage ="Homapage",
                imdb_id = "2323",
                production_companies = arrayOf(),
                production_countries = arrayOf(),
                revenue = 2000000,
                runtime = 200,
                spoken_languages = arrayOf(SpokenLanguage(name = "Hun",iso_639_1 = "DeHun")),
                status = "Kész",
                tagline = "Ezsincs"
        )
    }

    override suspend fun addFavouriteMovie(id: String): Response<Unit> {
        delay(1000)

        return Response.success(Unit)
    }

    override suspend fun deleteFavouriteMovie(id: String): Response<Unit> {
        delay(1000)
        return Response.success(Unit)
    }
}