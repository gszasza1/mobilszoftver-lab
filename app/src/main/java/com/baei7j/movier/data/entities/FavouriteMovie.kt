package com.baei7j.movier.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName= "favourite_movie")
data class FavouriteMovie(
    @PrimaryKey(autoGenerate = true) var id: Long?,
    @ColumnInfo(name = "overview") var overview: String?,
    @ColumnInfo(name = "release_date") var release_date: kotlin.String?,
    @ColumnInfo(name = "original_title") var original_title: kotlin.String?,
    @ColumnInfo(name = "original_language") var original_language: kotlin.String?,
    @ColumnInfo(name = "title") var title: kotlin.String?,
    @ColumnInfo(name = "popularity") var popularity: kotlin.Long?,
    @ColumnInfo(name = "vote_average") var vote_average: kotlin.Long?
)
