package com.baei7j.movier.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName= "favourite_movie")
data class FavouriteMovie(
    @PrimaryKey(autoGenerate= true) var movieId: Long?,
    @ColumnInfo(name = "sajt") var sajt: Boolean = true,
)
