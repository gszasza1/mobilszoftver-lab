package com.baei7j.movier.mock

import com.baei7j.movier.network.api.MovieApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MockNetworkModule {

    @Provides
    @Singleton
    fun provideMockCharacterApi(): MovieApi {
        return MockMovieApi()
    }
}