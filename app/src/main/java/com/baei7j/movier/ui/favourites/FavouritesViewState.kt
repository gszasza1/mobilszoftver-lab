package com.baei7j.movier.ui.favourites

sealed class FavouritesViewState

object Loading : FavouritesViewState()

data class FavouritesReady(val data: String = "") : FavouritesViewState()
