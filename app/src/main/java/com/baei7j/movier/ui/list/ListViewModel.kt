package com.baei7j.movier.ui.list

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import javax.inject.Inject

class ListViewModel @Inject constructor(
    private val listPresenter: ListPresenter
) : RainbowCakeViewModel<ListViewState>(Loading) {

    fun load(isAsc : Boolean) = execute {
        var result = listPresenter.getLatestMovies(isAsc)
        viewState = ListReady(listOf())
        viewState = ListReady(result)
    }
    fun search(seaxhText : String, isAsc : Boolean) = execute {
        viewState = ListReady(listPresenter.getLatestMovies(seaxhText, isAsc))
    }

}
