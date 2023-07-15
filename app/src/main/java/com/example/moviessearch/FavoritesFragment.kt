package com.example.moviessearch

import Film
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.megamovies.moviessearch.R

class FavoritesFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val favoritsList: List<Film> = emptyList()

    }


    companion object {
        @JvmStatic
        fun newInstance() = FavoritesFragment()
    }
}