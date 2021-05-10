package com.baei7j.movier.ui.favourites

import androidx.recyclerview.widget.DiffUtil
import com.baei7j.movier.data.entities.FavouriteMovie

object FavouritesComparator : DiffUtil.ItemCallback<FavouriteMovie>() {
    override fun areItemsTheSame(oldItem: FavouriteMovie, newItem: FavouriteMovie): Boolean {
        return oldItem.movieId == newItem.movieId
    }

    override fun areContentsTheSame(oldItem: FavouriteMovie, newItem: FavouriteMovie): Boolean {
        return oldItem == newItem
    }

}