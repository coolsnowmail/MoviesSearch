package com.example.moviessearch.domain

import com.example.moviessearch.API
import com.example.moviessearch.data.MainRepository
import com.example.moviessearch.data.internet.*
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
                    println("!!!! ${response.body()}")
                    callback.onSuccess(Converter.convertApiListToDtoList(response.body()?.items))
                }

                override fun onFailure(call: Call<ResultKinopoiskDto>, t: Throwable) {
                    println("!!!! onFailure2")
                    callback.onFailure()
                }

            })
    }
//    fun getFilmsDB(): List<Film> = repo.filmsDataBase
}