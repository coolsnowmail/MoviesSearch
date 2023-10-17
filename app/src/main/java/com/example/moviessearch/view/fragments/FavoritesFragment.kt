package com.example.moviessearch.view.fragments

import com.example.moviessearch.domain.Film
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.moviessearch.RetrofitInterface
import com.example.moviessearch.utils.AnimationHelper
import com.megamovies.moviessearch.databinding.FragmentFavoritesBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class FavoritesFragment : Fragment() {
    val favoritesList: MutableList<Film> = mutableListOf()
    private lateinit var binding: FragmentFavoritesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        AnimationHelper.performFragmentCircularRevealAnimation(
            binding.favoritesFragmentRoot,
            requireActivity(),
            1
        )

        val retrofit = Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val productApi = retrofit.create(RetrofitInterface::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            val product = productApi.productById(3)
            println("!!!! ${product.title}")
        }
    }
}