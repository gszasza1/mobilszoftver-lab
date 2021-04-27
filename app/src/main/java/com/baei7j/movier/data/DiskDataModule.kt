package com.baei7j.movier.data

import android.content.Context
import com.baei7j.movier.data.entities.FavouriteMovieDAO
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DiskDataModule {

    @Provides
    @Singleton
    fun provideNewsDatabase(context: Context): AppDatabase {
        return AppDatabase.getInstance(context)
    }

    @Provides
    @Singleton
    fun provideMovieDao(newsDatabase: AppDatabase): FavouriteMovieDAO {
        return newsDatabase.favouriteMovieDao()
    }

    @Provides
    @Singleton
    fun provideMockMovieDao(): IMockFavouriteMovieDAO {
        return DiskDataMock()
    }
}