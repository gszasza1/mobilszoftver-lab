package com.baei7j.movier.ui.details

sealed class DetailsViewState

object Loading : DetailsViewState()

data class BlankReady(val data: String = "") : DetailsViewState()
