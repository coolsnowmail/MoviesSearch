package com.example.moviessearch.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviessearch.App
import com.example.moviessearch.data.internet.individual_film.GetFilmDescriptionFromApi
import com.example.moviessearch.domain.Film
import com.example.moviessearch.domain.Interactor
import javax.inject.Inject

class HomeFragmentViewModel : ViewModel() {
    val filmListLiveData = MutableLiveData<List<Film>>()

    @Inject
    lateinit var interactor: Interactor


    init {
        App.instance.dagger.inject(this)
        interactor.getFilmsFromApi(1, object : ApiCallBack {
            override fun onSuccess(films: List<Film>) {
                filmListLiveData.postValue(films)
            }

            override fun onFailure() {
            }
        })

    }

    interface ApiCallBack {
        fun onSuccess(films: List<Film>)
        fun onFailure()
    }

}