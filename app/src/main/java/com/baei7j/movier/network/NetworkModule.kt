package com.baei7j.movier.network

import com.baei7j.movier.network.api.IMockMovieApi
import com.baei7j.movier.network.api.MockMovieApi
import com.baei7j.movier.network.api.MovieApi
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory

@Module
class NetworkModule {

    companion object {
        private const val SERVER_URL = "https://api.themoviedb.org/3/"
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addNetworkInterceptor { chain ->
                Thread.sleep(3000)
                chain.proceed(chain.request())
            }
            .addNetworkInterceptor(StethoInterceptor())
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(SERVER_URL)
            .client(okHttpClient)
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder()
                        .setLenient()
                        .create()
                )
            )
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }

    @Provides
    @Singleton
    fun provideDnd5eApi(retrofit: Retrofit): MovieApi =
        retrofit.create(MovieApi::class.java)

    @Provides
    @Singleton
    fun provideMockCharacterApi(): IMockMovieApi {
        return MockMovieApi()
    }
}