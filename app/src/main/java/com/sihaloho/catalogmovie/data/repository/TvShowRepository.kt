package com.sihaloho.catalogmovie.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sihaloho.catalogmovie.data.entity.MovieEntity
import com.sihaloho.catalogmovie.data.entity.TvShowEntity
import com.sihaloho.catalogmovie.data.response.TvShowResponse

import com.sihaloho.catalogmovie.data.retrofit.MovieApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TvShowRepository @Inject constructor(private val movieApi: MovieApi) {
    fun getDataTvShow(): LiveData<List<TvShowEntity>> {
        val listTvShow = MutableLiveData<List<TvShowEntity>>()

        movieApi.getTvShow().enqueue(object : Callback<TvShowResponse> {
            val listItems = ArrayList<TvShowEntity>()
            override fun onResponse(call: Call<TvShowResponse>, response: Response<TvShowResponse>) {
                if (response.isSuccessful) {
                    response.body()?.results.let { it?.let { it1 -> listItems.addAll(it1) } }
                    listTvShow.postValue(listItems)

                }
            }

            override fun onFailure(call: Call<TvShowResponse>, t: Throwable) {
            }
        })

        return listTvShow
    }
}