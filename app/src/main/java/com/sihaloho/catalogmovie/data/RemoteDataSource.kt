package com.sihaloho.catalogmovie.data

import com.sihaloho.catalogmovie.data.entity.MovieEntity
import com.sihaloho.catalogmovie.data.entity.TvShowEntity
import com.sihaloho.catalogmovie.data.retrofit.ApiConfig
import retrofit2.await

class RemoteDataSource  {
    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource()
            }
    }

    suspend fun getMovies(
        callback: LoadMoviesCallback
    ) {
        ApiConfig.instance.getMovies().await().results.let { listMovie ->
            callback.onAllMoviesReceived(
                listMovie
            )
        }
    }
    suspend fun getTvShow(
        callback: LoadTvShowCallback
    ) {
        ApiConfig.instance.getTvShow().await().results.let { listTvShow ->
            callback.onAllTvShowReceived(
                listTvShow
            )
        }
    }

    interface LoadMoviesCallback {
        fun onAllMoviesReceived(movieResponse: List<MovieEntity>)
    }
    interface LoadTvShowCallback {
        fun onAllTvShowReceived(tvShowResponse: List<TvShowEntity>)
    }

}
