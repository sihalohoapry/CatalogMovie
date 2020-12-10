package com.sihaloho.catalogmovie.data

import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sihaloho.catalogmovie.data.entity.MovieEntity
import com.sihaloho.catalogmovie.data.entity.TvShowEntity
import com.sihaloho.catalogmovie.data.retrofit.ApiConfig
import com.sihaloho.catalogmovie.utils.EspressoIdlingResource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import retrofit2.await
import java.io.IOException

class RemoteDataSource  {

    private val handler = Handler()


    companion object {
        private const val SERVICE_LATENCY_IN_MILLIS: Long = 2000

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource()
            }
    }

    fun getMovies() : LiveData<ApiResponse<List<MovieEntity>>> {
        EspressoIdlingResource.increment()
        val resultMovie = MutableLiveData<ApiResponse<List<MovieEntity>>>()
        handler.postDelayed({

            CoroutineScope(IO).launch {
                try {
                    val response = ApiConfig.instance.getMovies().await()
                    resultMovie.postValue(ApiResponse.success(response.results))
                    EspressoIdlingResource.decrement()

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


        }, SERVICE_LATENCY_IN_MILLIS)
        return resultMovie


    }
    fun getTvShow() : LiveData<ApiResponse<List<TvShowEntity>>> {
        EspressoIdlingResource.increment()
        val resultTvShow = MutableLiveData<ApiResponse<List<TvShowEntity>>>()

        handler.postDelayed({
            CoroutineScope(IO).launch {
                try {
                    val response = ApiConfig.instance.getTvShow().await()
                    resultTvShow.postValue(ApiResponse.success(response.results))
                    EspressoIdlingResource.decrement()

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

        }, SERVICE_LATENCY_IN_MILLIS)
        return resultTvShow


    }


}
