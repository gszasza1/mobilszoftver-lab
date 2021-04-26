package com.baei7j.movier.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName= "favourite_movie")
data class FavouriteMovie(
    @PrimaryKey(autoGenerate = true) var movieId: Long?,
    @ColumnInfo(name = "overview") var overview: String,
    @ColumnInfo(name = "release_date") var release_date: String,
    @ColumnInfo(name = "original_title") var original_title: String,
    @ColumnInfo(name = "original_language") var original_language: String,
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "popularity") var popularity: Long,
    @ColumnInfo(name = "vote_average") var vote_average: Long
)
