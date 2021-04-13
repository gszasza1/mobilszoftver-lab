package com.baei7j.movier.ui.list

import co.zsmb.rainbowcake.withIOContext
import javax.inject.Inject

class ListPresenter @Inject constructor() {

    suspend fun getData(): String = withIOContext {
        ""
    }

}
