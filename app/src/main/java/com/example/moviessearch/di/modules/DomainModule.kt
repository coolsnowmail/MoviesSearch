package com.example.moviessearch.di.modules

import com.example.moviessearch.data.MainRepository
import com.example.moviessearch.data.internet.KinopoiskApi
import com.example.moviessearch.data.internet.individual_film.GetFilmDescriptionFromApi
import com.example.moviessearch.domain.Interactor
import dagger.Provides

class DomainModule {
    @Provides
    fun providesInteractor(repository: MainRepository, kinopoiskApi: KinopoiskApi) =
        Interactor(repo = repository, retrofitService = kinopoiskApi)

    @Provides
    fun providesGetFilmDescriptionFromApi(repository: MainRepository, kinopoiskApi: KinopoiskApi) =
        GetFilmDescriptionFromApi(repo = repository, retrofitService = kinopoiskApi)
}