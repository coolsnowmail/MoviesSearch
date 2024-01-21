package com.example.moviessearch.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviessearch.App
import com.example.moviessearch.domain.Film
import com.example.moviessearch.domain.Interactor

class HomeFragmentViewModel : ViewModel() {
    val filmListLiveData = MutableLiveData<List<Film>>()
    private var interactor: Interactor = App.instance.interactor
    init {
        val films = interactor.getFilmsDB()
        filmListLiveData.postValue(films)
    }

}