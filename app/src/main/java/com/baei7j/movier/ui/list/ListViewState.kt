package com.baei7j.movier.ui.list

import com.baei7j.movier.network.models.Movie
import com.baei7j.movier.network.models.MovieList

sealed class ListViewState

object Loading : ListViewState()

data class ListReady(val data: List<Movie>?) : ListViewState()
