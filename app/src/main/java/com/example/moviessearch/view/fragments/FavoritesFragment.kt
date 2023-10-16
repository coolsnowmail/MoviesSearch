package com.example.moviessearch.view.fragments

import com.example.moviessearch.domain.Film
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.moviessearch.API
import com.example.moviessearch.data.User
import com.example.moviessearch.utils.AnimationHelper
import com.google.gson.Gson
import com.megamovies.moviessearch.databinding.FragmentFavoritesBinding
import okhttp3.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.URL
import java.util.concurrent.Executors
import javax.net.ssl.HttpsURLConnection

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
       val rentofit = Retrofit.Builder()
           .baseUrl("https://reqres.in/")
           .addConverterFactory(GsonConverterFactory.create())
           .build()
    }
}