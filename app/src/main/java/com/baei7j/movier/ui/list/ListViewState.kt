package com.baei7j.movier.ui.list

import com.baei7j.movier.data.entities.FavouriteMovie
import com.baei7j.movier.network.models.MovieList

sealed class ListViewState

object Loading : ListViewState()

data class ListReady(val data: MovieList) : ListViewState()
