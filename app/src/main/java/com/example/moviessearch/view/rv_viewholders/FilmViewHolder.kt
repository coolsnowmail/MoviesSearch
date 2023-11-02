package com.example.moviessearch.view.rv_viewholders

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviessearch.data.internet.ApiConstants
import com.example.moviessearch.domain.Film
import com.megamovies.moviessearch.R
import com.megamovies.moviessearch.databinding.FilmItemBinding

class FilmViewHolder(private val itemFilmBinding: FilmItemBinding) :
    RecyclerView.ViewHolder(itemFilmBinding.root) {

    fun bind(film: Film) {
        itemFilmBinding.title.text = film.title
        itemFilmBinding.year.text = R.string.film_year.toString()
        itemFilmBinding.ratingDonut.setProgress((film.rating * 10).toInt())
//            itemFilmBinding.poster.setImageResource(film.poster)
        Glide.with(itemView)
            //Загружаем сам ресурс
            .load(film.poster)
            //Центруем изображение
            .centerCrop()
            //Указываем ImageView, куда будем загружать изображение
            .into(itemFilmBinding.poster)
    }
}