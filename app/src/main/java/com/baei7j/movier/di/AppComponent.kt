package com.baei7j.movier.di

import co.zsmb.rainbowcake.dagger.RainbowCakeComponent
import co.zsmb.rainbowcake.dagger.RainbowCakeModule
import com.baei7j.movier.network.NetworkModule
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        RainbowCakeModule::class,
        ApplicationModule::class,
        ViewModelModule::class,
        NetworkModule::class
    ]
)
interface AppComponent : RainbowCakeComponent
