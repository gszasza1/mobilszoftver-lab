package com.baei7j.movier.ui.details

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import javax.inject.Inject

class DetailsViewModel @Inject constructor(
    private val detailsPresenter: DetailsPresenter
) : RainbowCakeViewModel<DetailsViewState>(Loading) {

    fun load() = execute {
        viewState = BlankReady(detailsPresenter.getData())
    }

}
