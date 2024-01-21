package com.example.moviessearch.data.internet

import com.example.moviessearch.data.internet.individual_film.FilmKinopoiskApiDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface KinopoiskApi {
    @Headers(
        "X-API-KEY: ${API.KEY}"
    )
    @GET("films/collections")
    fun getCollection(
        @Query("type") type: String,
        @Query("page") page: Int
    ): Call<ResultKinopoiskDto>

    @Headers(
        "X-API-KEY: ${API.KEY}"
    )
    @GET("films/{id}")
    fun getFilm(
        @Path("id") id: Int
    ): Call<FilmKinopoiskApiDto>
}