package com.example.moviessearch.view.fragments

import com.example.moviessearch.domain.Film
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.moviessearch.RetrofitInterface
import com.example.moviessearch.data.Product
import com.example.moviessearch.utils.AnimationHelper
import com.megamovies.moviessearch.R
import com.megamovies.moviessearch.databinding.FragmentFavoritesBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
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

        Glide.with(this)
            .load("https://memepedia.ru/wp-content/uploads/2018/12/in_article_11341c19c0-768x768.jpg")
            .into(binding.imageView)

// 35.2 work with json
//        val interceptor = HttpLoggingInterceptor()
//        interceptor.level = HttpLoggingInterceptor.Level.BODY
//
//        val client = OkHttpClient.Builder()
//            .addInterceptor(interceptor)
//            .build()
//
//        val retrofit = Retrofit.Builder()
//            .baseUrl("https://dummyjson.com/")
//            .client(client)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//        val productApi = retrofit.create(RetrofitInterface::class.java)
//        CoroutineScope(Dispatchers.IO).launch {
//            val product = productApi.productById(3)
//            println("!!!! ${product.title}")
//        }
    }
}