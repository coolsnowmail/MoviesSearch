package com.example.moviessearch.domain

import com.example.moviessearch.data.MainRepository
import com.example.moviessearch.data.internet.*
import com.example.moviessearch.data.internet.individual_film.FilmKinopoiskApiDto
import com.example.moviessearch.utils.Converter
import com.example.moviessearch.viewmodel.HomeFragmentViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Interactor(private val repo: MainRepository,  private val retrofitService: KinopoiskApi) {
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
}