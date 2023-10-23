package com.example.moviessearch.domain

import com.example.moviessearch.API
import com.example.moviessearch.data.MainRepository
import com.example.moviessearch.data.internet.TmdbApi
import com.example.moviessearch.data.internet.TmdbResultsDto
import com.example.moviessearch.utils.Converter
import com.example.moviessearch.viewmodel.HomeFragmentViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Interactor(private val retrofitService: TmdbApi) {
    fun getFilmsFromApi(page: Int, callback: HomeFragmentViewModel.ApiCallBack) {
        retrofitService.getFilms(API.KEY, "ru-RU", page)
            .enqueue(object : Callback<TmdbResultsDto> {
                override fun onResponse(
                    call: Call<TmdbResultsDto>,
                    response: Response<TmdbResultsDto>
                ) {
                    println("!!!! ${response.body()}")
                    callback.onSuccess(Converter.convertApiListToDtoList(response.body()?.tmdbFilms))
                }

                override fun onFailure(call: Call<TmdbResultsDto>, t: Throwable) {
                    println("!!!! onFailure2")
                    callback.onFailure()
                }

            })
    }
//    fun getFilmsDB(): List<Film> = repo.filmsDataBase
}