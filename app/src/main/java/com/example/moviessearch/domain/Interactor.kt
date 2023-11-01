package com.example.moviessearch.domain

import com.example.moviessearch.data.internet.*
import com.example.moviessearch.data.internet.individual_film.FilmKinopoiskApiDto
import com.example.moviessearch.utils.Converter
import com.example.moviessearch.viewmodel.HomeFragmentViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Interactor(private val retrofitService: KinopoiskApi) {
    fun getFilmsFromApi(page: Int, callback: HomeFragmentViewModel.ApiCallBack) {
        retrofitService.getCollection(ApiConstants.TYPE_COLLECTION, page)
            .enqueue(object : Callback<ResultKinopoiskDto> {
                override fun onResponse(
                    call: Call<ResultKinopoiskDto>,
                    response: Response<ResultKinopoiskDto>
                ) {
                    callback.onSuccess(Converter.convertApiListToDtoList(response.body()?.items))
                }

                override fun onFailure(call: Call<ResultKinopoiskDto>, t: Throwable) {
                    callback.onFailure()
                }

            })
    }

//    fun getFilm(id: Int, callback: HomeFragmentViewModel.ApiCallBack) {
//        retrofitService.getFilm(id)
//            .enqueue(object : Callback<FilmKinopoiskApiDto> {
//                override fun onResponse(
//                    call: Call<FilmKinopoiskApiDto>,
//                    response: Response<FilmKinopoiskApiDto>
//                ) {
//                    println("!!!! ${response.body()}")
//                    callback.onSuccess(Converter.convertToAddDtoListFilmDescription(response.body(), list))
//                }
//
//                override fun onFailure(call: Call<FilmKinopoiskApiDto>, t: Throwable) {
//                    println("!!!! onFailure get film")
//                    callback.onFailure()
//                }
//
//
//            })
//    }
//    fun getFilmsDB(): List<Film> = repo.filmsDataBase
}