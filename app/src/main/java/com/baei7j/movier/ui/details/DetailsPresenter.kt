package com.baei7j.movier.ui.details

import co.zsmb.rainbowcake.withIOContext
import com.baei7j.movier.domain.interactor.MovieInteractor
import javax.inject.Inject

class DetailsPresenter @Inject constructor(private val movieInteractor: MovieInteractor) {

    suspend fun getData(): String = withIOContext {
        ""
    }

}
