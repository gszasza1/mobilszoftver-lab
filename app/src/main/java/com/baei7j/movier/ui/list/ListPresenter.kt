package com.baei7j.movier.ui.list

import co.zsmb.rainbowcake.withIOContext
import com.baei7j.movier.data.entities.FavouriteMovie
import javax.inject.Inject

class ListPresenter @Inject constructor() {

    suspend fun getData(): String = withIOContext {
        ""
    }


}
