package com.sihaloho.catalogmovie.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sihaloho.catalogmovie.data.entity.MovieEntity
import com.sihaloho.catalogmovie.data.entity.TvShowEntity
import com.sihaloho.catalogmovie.data.response.MovieResponse
import com.sihaloho.catalogmovie.data.retrofit.ApiConfig
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import retrofit2.await
import java.io.IOException

class RemoteDataSource  {
    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource()
            }
    }

    fun getMovies() : LiveData<ApiResponse<List<MovieEntity>>> {
        val resultMovie = MutableLiveData<ApiResponse<List<MovieEntity>>>()

        CoroutineScope(IO).launch {
            try {
                val response = ApiConfig.instance.getMovies().await()
                resultMovie.postValue(ApiResponse.success(response.results))
            } catch (e: IOException) {
                e.printStackTrace()
                resultMovie.postValue(
                    ApiResponse.error(
                        e.message.toString(),
                        mutableListOf()
                    )
                )
            }
        }
        return resultMovie

//        ApiConfig.instance.getMovies().await().results.let { listMovie ->
//            callback.onAllMoviesReceived(
//                listMovie
//            )
//        }
    }
    fun getTvShow() : LiveData<ApiResponse<List<TvShowEntity>>> {
        val resultTvShow = MutableLiveData<ApiResponse<List<TvShowEntity>>>()

        CoroutineScope(IO).launch {
            try {
                val response = ApiConfig.instance.getTvShow().await()
                resultTvShow.postValue(ApiResponse.success(response.results))
            } catch (e: IOException) {
                e.printStackTrace()
                resultTvShow.postValue(
                    ApiResponse.error(
                        e.message.toString(),
                        mutableListOf()
                    )
                )
            }
        }
        return resultTvShow

//        ApiConfig.instance.getTvShow().await().results.let { listTvShow ->
//            callback.onAllTvShowReceived(
//                listTvShow
//            )
//        }
    }

    interface LoadMoviesCallback {
        fun onAllMoviesReceived(movieResponse: List<MovieEntity>)
    }
    interface LoadTvShowCallback {
        fun onAllTvShowReceived(tvShowResponse: List<TvShowEntity>)
    }

}
