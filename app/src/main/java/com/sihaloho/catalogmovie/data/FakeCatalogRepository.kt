package com.sihaloho.catalogmovie.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sihaloho.catalogmovie.data.entity.MovieEntity
import com.sihaloho.catalogmovie.data.entity.TvShowEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class FakeCatalogRepository(private val remoteDataSource: RemoteDataSource) : CatalogDataSource {


    override fun getMovies(): LiveData<List<MovieEntity>> {
        val listMovie = MutableLiveData<List<MovieEntity>>()
        CoroutineScope(IO).launch {
            remoteDataSource.getMovies(object : RemoteDataSource.LoadMoviesCallback {
                override fun onAllMoviesReceived(movieResponse: List<MovieEntity>) {
                    val movieList = ArrayList<MovieEntity>()
                    for (response in movieResponse) {
                        val movie = MovieEntity(
                            response.id,
                            response.title,
                            response.release_date,
                            response.vote_average,
                            response.overview,
                            response.backdrop_path,
                            response.poster_path
                        )
                        movieList.add(movie)
                    }
                    listMovie.postValue(movieList)
                }
            })
        }
        return listMovie
    }

    override fun getTvShow(): LiveData<List<TvShowEntity>> {
        val tvShow = MutableLiveData<List<TvShowEntity>>()
        CoroutineScope(IO).launch {
            remoteDataSource.getTvShow(object : RemoteDataSource.LoadTvShowCallback {
                override fun onAllTvShowReceived(tvShowResponse: List<TvShowEntity>) {
                    val tvShowList = ArrayList<TvShowEntity>()
                    for (response in tvShowResponse) {
                        val movie = TvShowEntity(
                            response.id,
                            response.original_name,
                            response.vote_average,
                            response.overview,
                            response.backdrop_path,
                            response.poster_path,
                            response.first_air_date
                        )
                        tvShowList.add(movie)
                    }
                    tvShow.postValue(tvShowList)
                }

            })
        }
        return tvShow
    }

}