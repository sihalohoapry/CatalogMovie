package com.sihaloho.catalogmovie.data

import androidx.lifecycle.LiveData
import com.sihaloho.catalogmovie.data.entity.MovieEntityRoom
import com.sihaloho.catalogmovie.data.entity.TvShowEntityRoom
import com.sihaloho.catalogmovie.data.vo.Resource

interface CatalogDataSource {
    fun getMovies(): LiveData<Resource<List<MovieEntityRoom>>>
    fun getFavMovie(): LiveData<List<MovieEntityRoom>>
    fun setMovieFav(movie: MovieEntityRoom, state: Boolean)

    fun getTvShow(): LiveData<Resource<List<TvShowEntityRoom>>>
    fun getFavTvShow(): LiveData<List<TvShowEntityRoom>>
    fun setTvShowFav(tvShow: TvShowEntityRoom, state: Boolean)

}