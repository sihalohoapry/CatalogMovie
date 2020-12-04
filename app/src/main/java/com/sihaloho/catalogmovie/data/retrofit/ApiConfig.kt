package com.sihaloho.catalogmovie.data.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiConfig {
    private const val BASE_URL = MovieApi.BASE_URL
    val instance: MovieApi by lazy{
        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        retrofit.create(MovieApi::class.java)
    }
}