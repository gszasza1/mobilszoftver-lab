package com.baei7j.movier.ui.list

import androidx.recyclerview.widget.DiffUtil
import com.baei7j.movier.network.models.Movie

object MovieComparator : DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem == newItem
    }

}