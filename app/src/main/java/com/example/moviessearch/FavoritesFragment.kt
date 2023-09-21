package com.example.moviessearch

import Film
import android.os.Bundle
import android.transition.Slide
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.megamovies.moviessearch.MainActivity
import com.megamovies.moviessearch.databinding.FragmentDetailsBinding
import com.megamovies.moviessearch.databinding.FragmentFavoritesBinding

class FavoritesFragment : Fragment() {
//    init {
//        enterTransition = Slide(Gravity.END).apply { duration = 500; mode = Slide.MODE_IN }
//        returnTransition = Slide(Gravity.END).apply { duration = 500;mode = Slide.MODE_OUT }
//        exitTransition = Slide(Gravity.START).apply { duration = 500;mode = Slide.MODE_OUT }
//
//    }
    val favoritesList: MutableList<Film> = mutableListOf()
    private lateinit var binding: FragmentFavoritesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        return super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        AnimationHelper.performFragmentCircularRevealAnimation(binding.favoritesFragmentRoot, requireActivity(), 1)


    }
}