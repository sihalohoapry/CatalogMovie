package com.sihaloho.catalogmovie.data.retrofit

import com.sihaloho.catalogmovie.data.response.MovieResponse
import com.sihaloho.catalogmovie.data.response.TvShowResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
    companion object{
        const val API_KEY = "4848804cd918ca98482c34aa81bddd27"
        const val BASE_URL = "Https://api.themoviedb.org/3/"
    }

    @GET("movie/now_playing?api_key=$API_KEY")
    fun getMovies() : Call <MovieResponse>

    @GET("tv/airing_today?api_key=$API_KEY")
    fun getTvShow() : Call <TvShowResponse>

}