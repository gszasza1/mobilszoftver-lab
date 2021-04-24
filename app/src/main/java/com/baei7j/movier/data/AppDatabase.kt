package com.baei7j.movier.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.baei7j.movier.data.entities.FavouriteMovie
import com.baei7j.movier.data.entities.FavouriteMovieDAO

@Database(entities = [FavouriteMovie::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun favouriteMovieDao(): FavouriteMovieDAO
    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java, "favourite_movie_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { INSTANCE = it }
            }
        }
    }
}