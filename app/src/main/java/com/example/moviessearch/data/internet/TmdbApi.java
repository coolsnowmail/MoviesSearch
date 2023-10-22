package com.example.moviessearch.data.internet;

import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TmdbApi {
    @GET("3/movie/popular")
    fun getFilms(
            @Query("api_key") apiKey: String,
            @Query("language") language: String,
            @Query("page") page: Int
    ): Call<TmdbResultsDto>
}
