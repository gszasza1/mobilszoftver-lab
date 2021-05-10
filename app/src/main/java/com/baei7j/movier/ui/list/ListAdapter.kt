package com.baei7j.movier.ui.list

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.baei7j.movier.R
import com.baei7j.movier.network.models.Movie
import kotlinx.android.synthetic.main.fragment_movie_row.view.*

class MovieListAdapter (
        private val context: Context
    ) :
    ListAdapter<Movie, MovieListAdapter.ViewHolder>(MovieComparator) {

        var listener: Listener? = null
        interface Listener {

            fun onItemSelected(id: Int)
        }

    override fun onCreateViewHolder(
                parent: ViewGroup,
                viewType: Int
        ) : MovieListAdapter.ViewHolder {
            val view = LayoutInflater
                    .from(parent.context)
                    .inflate(
                            R.layout.fragment_movie_row,
                            parent,
                            false
                    )
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: MovieListAdapter.ViewHolder, position: Int) {
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

            var item: Movie? = null

            init {
                itemView.setOnClickListener {
                    item.let {
                        listener?.onItemSelected(it?.id!!.toInt())
                    }
                }
            }
        }


    }