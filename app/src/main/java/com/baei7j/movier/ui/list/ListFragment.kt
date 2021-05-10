package com.baei7j.movier.ui.list

import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.navigation.navigator
import com.baei7j.movier.R
import com.baei7j.movier.ui.details.DetailsFragment
import com.baei7j.movier.ui.favourites.FavouritesFragment
import kotlinx.android.synthetic.main.fragment_list.*

class ListFragment : RainbowCakeFragment<ListViewState, ListViewModel>(), MovieListAdapter.Listener {

    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.fragment_list
    private var isAsc = false

    private var delay: Long = 1000 // 1 seconds after user stops typing
    private var last_text_edit: Long = 0
    private lateinit var adapter: MovieListAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = MovieListAdapter(requireContext())
        setupButtons()
    }


    @Suppress("DEPRECATION")
    var handler = Handler()

    private val inputFinishChecker = Runnable {
        if (System.currentTimeMillis() > last_text_edit + delay - 500) {
            viewModel.search(searchMovie.text.toString(), isAsc)
        }
    }
    override fun onStart() {
        super.onStart()
        viewModel.loadLatest(isAsc)
    }
    private fun setupButtons(){
        favouriteButton.setOnClickListener {
            navigator?.add(FavouritesFragment())
        }
        orderButton.setOnClickListener {
            isAsc = !isAsc
            searchMovie.clearFocus()
            orderButton.requestFocus()
            if(searchMovie.text.toString().isNotEmpty()){
                viewModel.search(searchMovie.text.toString(), isAsc)
            }else{
                viewModel.loadLatest(isAsc)
            }
            adapter.notifyDataSetChanged()
        }
        searchMovie.addTextChangedListener((object : TextWatcher {
            override fun afterTextChanged(s:Editable)
            {
                if (s?.length > 0) {
                 last_text_edit = System.currentTimeMillis();
                 handler.postDelayed(inputFinishChecker, delay);
                }
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                handler.removeCallbacks(inputFinishChecker);
            }
        }))
    }

    override fun render(viewState: ListViewState) {
        when (viewState) {
            is ListReady -> showListPage(viewState)
            is Loading -> showLoading()
        }
    }

    private fun showListPage(viewState: ListReady) {
        setupList()
        listProgressBar.visibility = View.GONE
        adapter.submitList(viewState.data)
    }

    private fun showLoading() {
        listProgressBar.visibility = View.VISIBLE
    }

    private fun setupList() {
        adapter.listener = this
        recyclerView.adapter = adapter
        recyclerView.itemAnimator?.changeDuration = 0
        recyclerView.itemAnimator?.moveDuration = 0
    }

    override fun onDestroy() {
        adapter.listener = null
        super.onDestroy()
    }
    override fun onItemSelected(id: Int) {
        navigator?.add(DetailsFragment.newInstance(id.toLong()))
    }

}
