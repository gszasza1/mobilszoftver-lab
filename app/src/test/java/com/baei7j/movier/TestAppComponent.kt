package com.baei7j.movier

import co.zsmb.rainbowcake.dagger.RainbowCakeModule
import com.baei7j.movier.di.AppComponent
import com.baei7j.movier.di.ViewModelModule
import com.baei7j.movier.mock.MockDiskModule
import com.baei7j.movier.mock.MockNetworkModule
import dagger.Component
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        MockNetworkModule::class,
        MockDiskModule::class,
        ViewModelModule::class,
        RainbowCakeModule::class
    ]
)
@ExperimentalCoroutinesApi
interface TestAppComponent : AppComponent {
    fun inject(newsInteractorTest: MovieInteractorTest)
}