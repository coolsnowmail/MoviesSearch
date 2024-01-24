package com.example.moviessearch

import android.app.Application
import com.example.moviessearch.data.internet.ApiConstants
import com.example.moviessearch.data.internet.KinopoiskApi
import com.example.moviessearch.data.internet.individual_film.GetFilmDescriptionFromApi
import com.example.moviessearch.di.AppComponent
import com.example.moviessearch.domain.Interactor
import com.megamovies.moviessearch.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class App : Application() {
    lateinit var dagger: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
//        dagger = Dagger
    }

    companion object {
        lateinit var instance: App
            private set
    }
}