package com.baei7j.movier.ui.list

import co.zsmb.rainbowcake.withIOContext
import com.baei7j.movier.domain.interactor.MovieInteractor
import javax.inject.Inject

class ListPresenter @Inject constructor(private val movieInteractor: MovieInteractor) {

    suspend fun getLatestMovies(isAsc : Boolean) = withIOContext {
        movieInteractor.getLatestList(isAsc)
    }
    suspend fun getLatestMovies(searchText:String, isAsc : Boolean) = withIOContext {
        movieInteractor.searchMovie(searchText, isAsc)
    }

}
