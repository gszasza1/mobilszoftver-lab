package com.baei7j.movier.mock

import com.baei7j.movier.data.entities.FavouriteMovieDAO
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MockDiskModule {

    @Provides
    @Singleton
    fun provideMockNewsDao(): FavouriteMovieDAO = MockMovieDao()

}