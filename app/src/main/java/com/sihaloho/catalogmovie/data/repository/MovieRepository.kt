package com.sihaloho.catalogmovie.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sihaloho.catalogmovie.data.RemoteDataSource

import com.sihaloho.catalogmovie.data.entity.MovieEntity
import com.sihaloho.catalogmovie.data.response.MovieResponse
import com.sihaloho.catalogmovie.data.retrofit.MovieApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject constructor(private val movieApi: MovieApi) {
    fun getDataMovie(): LiveData<List<MovieEntity>> {
        val listMovie = MutableLiveData<List<MovieEntity>>()

        movieApi.getMovies().enqueue(object : Callback<MovieResponse> {
            val listItems = ArrayList<MovieEntity>()
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.isSuccessful) {
                    response.body()?.results.let { it?.let { it1 -> listItems.addAll(it1) } }
                    listMovie.postValue(listItems)

                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
            }
        })

        return listMovie
    }
}