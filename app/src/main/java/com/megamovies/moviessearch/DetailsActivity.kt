package com.megamovies.moviessearch

import Film
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.megamovies.moviessearch.databinding.ActivityDetailsBinding
import com.megamovies.moviessearch.databinding.ActivityMainBinding

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_details)
        val film = intent.extras?.get("film") as Film
        binding.detailsToolbar.title = film.title
//Устанавливаем картинку
        binding.detailsPoster.setImageResource(film.poster)
//Устанавливаем описание
        binding.detailsDescription.text = film.description
    }
}