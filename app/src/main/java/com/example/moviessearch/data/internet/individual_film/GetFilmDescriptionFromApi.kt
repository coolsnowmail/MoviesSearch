package com.example.moviessearch.data.internet.individual_film

import com.example.moviessearch.data.internet.KinopoiskApi
import com.example.moviessearch.view.fragments.DetailsFragment
import com.example.moviessearch.viewmodel.HomeFragmentViewModel
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class GetFilmDescriptionFromApi(private val retrofitService: KinopoiskApi) {
    fun getFilmsFromApi(filmId: Int, callback: DetailsFragment.ApiFilmCallBack) {
        retrofitService.getFilm(filmId)
            .enqueue(object : Callback<FilmKinopoiskApiDto> {
                override fun onResponse(
                    call: Call<FilmKinopoiskApiDto>,
                    response: Response<FilmKinopoiskApiDto>
                ) {
                    response.body()?.let {
                        println("!!!! onFailure200 ${it.description}")
                        callback.onSuccess(it.description) }
                }

                override fun onFailure(call: Call<FilmKinopoiskApiDto>, t: Throwable) {
                    println("!!!! onFailure2")
                    callback.onFailure()
                }

            })
    }


//    fun get(film: Film): String? {
//        val okHttpClient = OkHttpClient.Builder()
//            .callTimeout(30, TimeUnit.SECONDS)
//            .readTimeout(30, TimeUnit.SECONDS)
//            .addInterceptor(HttpLoggingInterceptor().apply {
//                if (BuildConfig.DEBUG) {
//                    level = HttpLoggingInterceptor.Level.BODY
//                }
//            })
//            .build()
//        val retrofit = Retrofit.Builder()
//            .baseUrl(ApiConstants.BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .client(okHttpClient)
//            .build()
//        val retrofitService = retrofit.create(KinopoiskApi::class.java)


//        CoroutineScope(Dispatchers.IO).launch {
//            val filmKinopoiskApiDto = retrofitService.getFilm(film.id)
//        }
//        retrofitService.getFilm(film.id)
//            .enqueue(object : Callback<FilmKinopoiskApiDto> {
//                override fun onResponse(
//                    call: Call<FilmKinopoiskApiDto>,
//                    response: Response<FilmKinopoiskApiDto>
//                ) {
//                    film.description = response.body()?.description
//                    println("!!!! NEW1 ${response.body()?.description}")
//                }
//
//                override fun onFailure(call: Call<FilmKinopoiskApiDto>, t: Throwable) {
//                    println("!!!! onFailure2")
//                }
//
//            })
//        film.description = "fdfdfdf"
//        return film.description
//    }
}
