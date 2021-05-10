package com.baei7j.movier.ui.favourites

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.baei7j.movier.R
import com.baei7j.movier.data.entities.FavouriteMovie
import kotlinx.android.synthetic.main.fragment_movie_row.view.*

class FavouritesAdapter (
    private val context: Context
) :
    ListAdapter<FavouriteMovie, FavouritesAdapter.ViewHolder>(FavouritesComparator) {

    var listener: Listener? = null
    interface Listener {
        fun onItemSelected(movie : FavouriteMovie)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) : FavouritesAdapter.ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.fragment_movie_row,
                parent,
                false
            )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavouritesAdapter.ViewHolder, position: Int) {
        val item = getItem(position)

        holder.item = item
        holder.detailMovieTitle.text = item.title
        holder.detailMovieCreation.text = item.release_date
        holder.detailMoviePopularity.text = item.popularity.toString()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val detailMovieTitle: TextView = itemView.detailMovieTitle
        val detailMovieCreation: TextView = itemView.detailMovieCreation
        val detailMoviePopularity: TextView = itemView.detailMoviePopularity

        var item: FavouriteMovie? = null

        init {
            itemView.setOnClickListener {
                item.let {
                    listener?.onItemSelected(it!!)
                }
            }
        }
    }


}