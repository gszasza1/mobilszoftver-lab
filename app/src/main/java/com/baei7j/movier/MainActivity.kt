package com.baei7j.movier

import android.os.Bundle
import co.zsmb.rainbowcake.navigation.SimpleNavActivity
import com.baei7j.movier.data.AppDatabase
import com.baei7j.movier.data.entities.FavouriteMovie
import com.baei7j.movier.ui.list.ListFragment

class MainActivity : SimpleNavActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            navigator.add(ListFragment())
        }
        Thread {
            AppDatabase.getInstance(this).favouriteMovieDao().insertFavouriteMovie(FavouriteMovie(null))
        }.start()
    }

}
