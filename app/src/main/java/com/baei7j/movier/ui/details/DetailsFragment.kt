package com.baei7j.movier.ui.details

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.navigation.extensions.applyArgs
import co.zsmb.rainbowcake.navigation.extensions.getLongOrNull
import co.zsmb.rainbowcake.navigation.extensions.requireLong
import co.zsmb.rainbowcake.navigation.navigator
import com.baei7j.movier.R
import com.baei7j.movier.ui.favourites.FavouritesFragment
import com.baei7j.movier.ui.list.ListFragment
import kotlinx.android.synthetic.main.fragment_details.*
import kotlinx.android.synthetic.main.fragment_details.favouriteButton
import kotlinx.android.synthetic.main.fragment_list.*

class DetailsFragment : RainbowCakeFragment<DetailsViewState, DetailsViewModel> {

    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.fragment_details
    private lateinit var detailState :DetailsReady
    @Suppress("ConvertSecondaryConstructorToPrimary")
    @Deprecated(message = "Use newInstance instead", replaceWith = ReplaceWith("DetailsFragment.newInstance()"))
    constructor()


    companion object {
        private const val ARG_MOVIE_DETAIL_ID = "ARG_MOVIE_DETAIL_ID"

          @Suppress("DEPRECATION")
          fun newInstance(movieId: Long): DetailsFragment {
             return DetailsFragment().applyArgs {
                putLong(ARG_MOVIE_DETAIL_ID, movieId)
            }
        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupButtons()
        initArguments()
    }
    private fun setupButtons(){
        addMovieButton.setOnClickListener {
            viewModel.insertLocally(detailState.data)
            viewModel.insertNetwork(detailState.data.id.toString())
        }
        favouriteButton.setOnClickListener {
            navigator?.add(FavouritesFragment())
        }
        listButton.setOnClickListener {
            navigator?.add(ListFragment())
        }
    }

    private var requiredId: Long = 0

    private fun initArguments() {
        requiredId = requireArguments().requireLong(ARG_MOVIE_DETAIL_ID)
    }

    override fun onStart() {
        super.onStart()
        viewModel.load(requiredId.toString())
    }

    override fun render(viewState: DetailsViewState) {
        when (viewState) {
            is DetailsReady -> showDetailsReady(viewState)
        }
    }

    private fun showDetailsReady(viewState: DetailsReady) {
        detailState = viewState
        movieDetailsTitle.text = viewState.data.title
        movieCreationData.text = viewState.data.release_date
        moviePopularityData.text = viewState.data.popularity.toString()
        movieDescription.text = viewState.data.overview
        movieLengthData.text = viewState.data.runtime.toString()
    }

}
