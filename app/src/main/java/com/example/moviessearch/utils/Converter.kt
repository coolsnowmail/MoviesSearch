package com.example.moviessearch.utils

import com.example.moviessearch.data.internet.Item
import com.example.moviessearch.data.internet.individual_film.FilmKinopoiskApiDto
import com.example.moviessearch.domain.Film


object Converter {
    fun convertApiListToDtoList(list: List<Item>?): List<Film> {
        val result = mutableListOf<Film>()
        list?.forEach {
            result.add(
                Film(
                    id = it.kinopoiskId,
                    title = it.nameRu,
                    poster = it.posterUrl,
                    year = it.year,
                    rating = it.ratingImdb,
                    countries = it.countries
                )
            )
        }
        return result
    }
}