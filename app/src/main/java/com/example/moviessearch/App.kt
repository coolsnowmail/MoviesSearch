package com.example.moviessearch

import android.app.Application
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance
import com.example.moviessearch.data.MainRepository
import com.example.moviessearch.data.internet.ApiConstants
import com.example.moviessearch.data.internet.TmdbApi
import com.example.moviessearch.domain.Interactor
import com.megamovies.moviessearch.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

class App : Application() {
    lateinit var interactor: Interactor

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
        val retrofitService = retrofit.create(TmdbApi::class.java)
        interactor = Interactor(retrofitService)

    }

    companion object {
        lateinit var instance: App
            private set
    }
}