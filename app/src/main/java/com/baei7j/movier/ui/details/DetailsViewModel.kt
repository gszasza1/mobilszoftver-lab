package com.baei7j.movier.ui.details

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import com.baei7j.movier.data.entities.FavouriteMovie
import com.baei7j.movier.network.models.DetailedMovie
import com.baei7j.movier.network.models.Movie
import javax.inject.Inject

class DetailsViewModel @Inject constructor(
    private val detailsPresenter: DetailsPresenter
) : RainbowCakeViewModel<DetailsViewState>(Loading) {

    fun insertNetwork(movieId: String) = execute {
        detailsPresenter.insertNetwork(movieId)
    }
    fun insertLocally(movie: DetailedMovie) = execute {
        detailsPresenter.insertLocally(movie)
    }
    fun load(id: String) = execute {
        viewState = DetailsReady(detailsPresenter.getById(id))
    }

}
