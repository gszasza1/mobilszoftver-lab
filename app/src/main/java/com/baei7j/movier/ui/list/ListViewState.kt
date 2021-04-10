package com.baei7j.movier.ui.list

sealed class ListViewState

object Loading : ListViewState()

data class BlankReady(val data: String = "") : ListViewState()
