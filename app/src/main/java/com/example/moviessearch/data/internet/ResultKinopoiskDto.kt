package com.example.moviessearch.data.internet

data class ResultKinopoiskDto(
    val items: List<Item>,
    val total: Int,
    val totalPages: Int
)