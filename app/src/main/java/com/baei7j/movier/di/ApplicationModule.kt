package com.baei7j.movier.di

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
open class ApplicationModule(@get:Provides @Singleton val context: Context){
}
