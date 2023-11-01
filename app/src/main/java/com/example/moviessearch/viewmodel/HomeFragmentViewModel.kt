package com.example.moviessearch.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviessearch.App
import com.example.moviessearch.data.internet.individual_film.GetFilmDescriptionFromApi
import com.example.moviessearch.domain.Film
import com.example.moviessearch.domain.Interactor

class HomeFragmentViewModel : ViewModel() {
    val filmListLiveData = MutableLiveData<List<Film>>()
    private var interactor: Interactor = App.instance.interactor
//    val filmLiveData = MutableLiveData<Film>()
//    private var getFilmDescriptionFromApi: GetFilmDescriptionFromApi = App.instance.getFilmDescriptionFromApi

    init {
        interactor.getFilmsFromApi(1, object : ApiCallBack {
            override fun onSuccess(films: List<Film>) {
                filmListLiveData.postValue(films)
            }

            override fun onFailure() {
//                println("!!!! ApiCallBack interface in HomeFragmentViewModel is onFailure")
            }
        })

    }

    interface ApiCallBack {
        fun onSuccess(films: List<Film>)
        fun onFailure()
    }

//    interface ApiFilmCallBack {
//        fun onSuccess(filmDescription: String)
//        fun onFailure()
//    }

}