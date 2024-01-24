package com.example.moviessearch.view.fragments

import com.example.moviessearch.domain.Film
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.moviessearch.App
import com.example.moviessearch.data.internet.ApiConstants
import com.example.moviessearch.data.internet.KinopoiskApi
import com.example.moviessearch.data.internet.ResultKinopoiskDto
import com.example.moviessearch.data.internet.individual_film.FilmKinopoiskApiDto
import com.example.moviessearch.data.internet.individual_film.GetFilmDescriptionFromApi
import com.example.moviessearch.domain.Interactor
import com.example.moviessearch.utils.Converter
import com.example.moviessearch.viewmodel.HomeFragmentViewModel
import com.megamovies.moviessearch.BuildConfig
import com.megamovies.moviessearch.R
import com.megamovies.moviessearch.databinding.FragmentDetailsBinding
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject


class DetailsFragment : Fragment() {
    //    init {
//        enterTransition = Slide(Gravity.END).apply { duration = 500; mode = Slide.MODE_IN }
//        returnTransition = Slide(Gravity.END).apply { duration = 500;mode = Slide.MODE_OUT }
//        exitTransition = Slide(Gravity.START).apply { duration = 500;mode = Slide.MODE_OUT }
//    }
    private lateinit var binding: FragmentDetailsBinding
    val filmLiveData = MutableLiveData<String>()
//    private var getFilmDescriptionFromApi: GetFilmDescriptionFromApi =
//        App.instance.getFilmDescriptionFromApi
    @Inject
    lateinit var getFilmDescriptionFromApi: GetFilmDescriptionFromApi

    init {
        App.instance.dagger.inject(this)
    }
//    init {
//        getFilmDescriptionFromApi.getFilmsFromApi(
//            film.id,
//            object : DetailsFragment.ApiFilmCallBack {
//                override fun onSuccess(filmDescription: String) {
//                    filmLiveData.postValue(filmDescription)
//                }
//
//                override fun onFailure() {
//                    println("!!!! ApiCallBack interface in HomeFragmentViewModel is onFailure")
//                }
//
//            })
//    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        val film = arguments?.get("film") as Film

        getFilmDescriptionFromApi.getFilmsFromApi(
            film.id,
            object : DetailsFragment.ApiFilmCallBack {
                override fun onSuccess(filmDescription: String) {
                    filmLiveData.postValue(filmDescription)
                    println("!!!! onFailure100 ${filmDescription}")
                }

                override fun onFailure() {
                    println("!!!! ApiCallBack interface in HomeFragmentViewModel is onFailure")
                }

            })

        filmLiveData.observe(viewLifecycleOwner,
            Observer<String> {
                binding.detailsDescription.text = it
            })

        binding.detailsToolbar.title = film.title
//Устанавливаем картинку
        Glide.with(this)
            .load(film.poster)
            .centerCrop()
            .into(binding.detailsPoster)
//        binding.detailsPoster.setImageResource(film.poster)
//Устанавливаем описание

        binding.detailsDescription.text = film.description
        binding.detailsFabFavorites.setImageResource(
            if (film.isInFavorites) R.drawable.baseline_favorite_24
            else R.drawable.baseline_favorite_border_24
        )
        binding.detailsFabFavorites.setOnClickListener {
            if (!film.isInFavorites) {
                binding.detailsFabFavorites.setImageResource(R.drawable.baseline_favorite_24)
                film.isInFavorites = true
            } else {
                binding.detailsFabFavorites.setImageResource(R.drawable.baseline_favorite_border_24)
                film.isInFavorites = false
            }
        }

        binding.detailsFab.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(
                Intent.EXTRA_TEXT, "Check out this film: ${film.title} \n\n" +
                        "${film.description}"
            )
            intent.type = "test/plain"
            startActivity(Intent.createChooser(intent, "Share To:"))

//            Toast.makeText(context, "Посмотреть похже", Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }

    interface ApiFilmCallBack {
        fun onSuccess(filmDescription: String)
        fun onFailure()
    }
}

