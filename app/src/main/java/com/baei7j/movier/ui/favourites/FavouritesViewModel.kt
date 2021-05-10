package com.baei7j.movier.ui.favourites

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import com.baei7j.movier.data.entities.FavouriteMovie
import javax.inject.Inject

class FavouritesViewModel @Inject constructor(
    private val favouritesPresenter: FavouritesPresenter
) : RainbowCakeViewModel<FavouritesViewState>(Loading) {

    fun loadFavourites() = execute {
        viewState = FavouritesReady(favouritesPresenter.getAllFavourtieMovies())
    }
    fun deleteLocal(movie : FavouriteMovie) = execute {
        viewState = FavouritesReady(favouritesPresenter.deleteFavouriteMoviesLocally(movie))
    }
    fun deleteNetwork(movieId : String) = execute {
        favouritesPresenter.deleteFavouriteMoviesNetwork(movieId)
    }

}
