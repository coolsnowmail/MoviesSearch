package com.example.moviessearch

import android.app.Application
import com.example.moviessearch.data.internet.ApiConstants
import com.example.moviessearch.data.internet.KinopoiskApi
import com.example.moviessearch.data.internet.individual_film.GetFilmDescriptionFromApi
import com.example.moviessearch.domain.Interactor
import com.megamovies.moviessearch.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class App : Application() {
    lateinit var interactor: Interactor
    lateinit var getFilmDescriptionFromApi: GetFilmDescriptionFromApi

    override fun onCreate() {
        super.onCreate()
        instance = this
        val okHttpClient = OkHttpClient.Builder()
            .callTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(HttpLoggingInterceptor().apply {
                if (BuildConfig.DEBUG) {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            })
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
        val retrofitService = retrofit.create(KinopoiskApi::class.java)
        interactor = Interactor(retrofitService)


        val okHttpClient1 = OkHttpClient.Builder()
            .callTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(HttpLoggingInterceptor().apply {
                if (BuildConfig.DEBUG) {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            })
            .build()
        val retrofit1 = Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient1)
            .build()
        val retrofitService1 = retrofit1.create(KinopoiskApi::class.java)
        getFilmDescriptionFromApi = GetFilmDescriptionFromApi(retrofitService1)
    }

    companion object {
        lateinit var instance: App
            private set
    }
}