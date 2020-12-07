package com.sihaloho.catalogmovie.data

import androidx.lifecycle.LiveData
import androidx.room.Query
import com.sihaloho.catalogmovie.data.entity.MovieEntityRoom
import com.sihaloho.catalogmovie.data.entity.TvShowEntityRoom
import com.sihaloho.catalogmovie.data.vo.Resource

interface CatalogDataSource {
    //movies
    fun getMovies(): LiveData<Resource<List<MovieEntityRoom>>>
    fun getMovieFavorite(): LiveData<List<MovieEntityRoom>>
    fun setMovieFavorite(movie: MovieEntityRoom)





    //tvShow
    fun getTvShow(): LiveData<Resource<List<TvShowEntityRoom>>>
    fun getTvShowFavorite(): LiveData<List<TvShowEntityRoom>>
    fun setTvShowFavorite(tvShow: TvShowEntityRoom, state: Boolean)




}