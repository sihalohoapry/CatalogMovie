package com.sihaloho.catalogmovie.data

import com.sihaloho.catalogmovie.data.entity.MovieEntity
import com.sihaloho.catalogmovie.data.entity.TvShowEntity
import com.sihaloho.catalogmovie.data.response.MovieResponse
import com.sihaloho.catalogmovie.data.retrofit.ApiConfig
import com.sihaloho.catalogmovie.data.retrofit.MovieApi
import retrofit2.await
import javax.inject.Inject

class RemoteDataSource @Inject constructor(apiConfig: ApiConfig) {
    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(apiConfig: ApiConfig): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(apiConfig)
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
