package com.example.moviessearch.utils

import com.example.moviessearch.data.internet.TmdbFilm
import com.example.moviessearch.domain.Film


object Converter {
    fun convertApiListToDtoList(list: List<TmdbFilm>?): List<Film> {
        val result = mutableListOf<Film>()
        list?.forEach {
            result.add(Film(
                title = it.title,
                poster = it.posterPath,
                description = it.overview,
                rating = it.voteAverage
            ))
        }
        return result
    }
}