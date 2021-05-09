package com.baei7j.movier.ui.favourites

import com.baei7j.movier.data.entities.FavouriteMovie

sealed class FavouritesViewState

object Loading : FavouritesViewState()

data class FavouritesReady(val data: List<FavouriteMovie>) : FavouritesViewState()
