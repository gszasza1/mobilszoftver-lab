package com.baei7j.movier.ui.favourites

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import javax.inject.Inject

class FavouritesViewModel @Inject constructor(
    private val blankPresenter: FavouritesPresenter
) : RainbowCakeViewModel<FavouritesViewState>(Loading) {

    fun load() = execute {
        viewState = FavouritesReady(blankPresenter.getData())
    }

}
