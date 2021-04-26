package com.baei7j.movier.ui.list

import com.baei7j.movier.data.entities.FavouriteMovie

sealed class ListViewState

object Loading : ListViewState()

data class BlankReady(val data: MutableList<FavouriteMovie>) : ListViewState()
