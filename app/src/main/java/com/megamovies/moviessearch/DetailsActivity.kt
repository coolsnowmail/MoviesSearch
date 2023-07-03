package com.megamovies.moviessearch

import Film
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.megamovies.moviessearch.databinding.ActivityDetailsBinding
import com.megamovies.moviessearch.databinding.ActivityMainBinding
import timber.log.Timber
import timber.log.Timber.Forest.plant

class DetailsActivity : AppCompatActivity() {
    override fun onResume() {
        super.onResume()
        Timber.d("onResume fdlgdrfjogfdko! Huy!")
    }

    private lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Timber.plant(Timber.DebugTree())
        Timber.d("onCreate fdlgdrfjogfdko! Huy!")
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val film = intent.extras?.get("film") as Film
        binding.detailsToolbar.title = film.title
//Устанавливаем картинку
        binding.detailsPoster.setImageResource(film.poster)
//Устанавливаем описание
        binding.detailsDescription.text = film.description
    }

    override fun onPause() {
        super.onPause()
        Timber.d("onPause fdlgdrfjogfdko! Huy!")
    }

    override fun onStart() {
        super.onStart()
        Timber.d("onStart fdlgdrfjogfdko! Huy!")}

    override fun onStop() {
        super.onStop()
        Timber.d("onStop fdlgdrfjogfdko! Huy!")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.d("onDestroy fdlgdrfjogfdko! Huy!")
    }
}