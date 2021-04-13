package com.baei7j.movier.ui.blank

import co.zsmb.rainbowcake.withIOContext
import javax.inject.Inject

class BlankPresenter @Inject constructor() {

    suspend fun getData(): String = withIOContext {
        ""
    }

}
