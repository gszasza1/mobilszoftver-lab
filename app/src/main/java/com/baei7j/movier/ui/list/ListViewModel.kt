package com.baei7j.movier.ui.list

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import javax.inject.Inject

class ListViewModel @Inject constructor(
    private val blankPresenter: ListPresenter
) : RainbowCakeViewModel<ListViewState>(Loading) {

    fun load() = execute {
        viewState = BlankReady(blankPresenter.getData())
    }

}
