package com.baei7j.movier.di

import androidx.lifecycle.ViewModel
import co.zsmb.rainbowcake.dagger.ViewModelKey
import com.baei7j.movier.ui.blank.BlankViewModel
import com.baei7j.movier.ui.list.ListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ListViewModel::class)
    abstract fun bindListViewModel(listViewModel: ListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(BlankViewModel::class)
    abstract fun bindBlankViewModel(blankViewModel: BlankViewModel): ViewModel

}
