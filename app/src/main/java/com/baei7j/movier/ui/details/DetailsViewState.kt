package com.baei7j.movier.ui.details

import com.baei7j.movier.network.models.DetailedMovie

sealed class DetailsViewState

object Loading : DetailsViewState()

data class DetailsReady(val data: DetailedMovie) : DetailsViewState()
