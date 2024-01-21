package com.example.moviessearch

import com.example.moviessearch.data.Product
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitInterface {

//    @GET("products")
//    suspend fun getProduct(
//        @Query("id") id: Int
//    ): Call<Product>

    @GET("products/{id}")
   suspend fun productById(@Path("id") id: Int): Product
}