package com.baei7j.movier.ui.favourites

import android.os.Bundle
import android.view.View
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.navigation.navigator
import com.baei7j.movier.R
import com.baei7j.movier.data.entities.FavouriteMovie
import com.baei7j.movier.ui.list.ListFragment
import kotlinx.android.synthetic.main.fragment_favourites.*

class FavouritesFragment : RainbowCakeFragment<FavouritesViewState, FavouritesViewModel>(),
    FavouritesAdapter.Listener {

    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.fragment_favourites

    private lateinit var adapter: FavouritesAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = FavouritesAdapter(requireContext())
        setupButtons()
    }

    override fun onStart() {
        super.onStart()

        viewModel.load()
    }
    private fun setupButtons(){
        listButton.setOnClickListener {
            navigator?.add(ListFragment())
        }
    }

    override fun render(viewState: FavouritesViewState) {
        when (viewState) {
            is FavouritesReady -> showListPage(viewState)
            is Loading -> showLoading()
        }
    }

    private fun showListPage(viewState: FavouritesReady) {
        setupList()
        favouriteProgressBar.visibility = View.GONE
        adapter.submitList(viewState.data)
    }

    private fun showLoading() {
        favouriteProgressBar.visibility = View.VISIBLE
    }

    private fun setupList() {
        adapter.listener = this
        favouritesRecyclerView.adapter = adapter
        favouritesRecyclerView.itemAnimator?.changeDuration = 0
        favouritesRecyclerView.itemAnimator?.moveDuration = 0
    }

    override fun onDestroy() {
        adapter.listener = null
        super.onDestroy()
    }
    override fun onItemSelected(item : FavouriteMovie) {
        viewModel.deleteLocal(item)
        viewModel.deleteNetwork(item.movieId.toString())
    }

}
