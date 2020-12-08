package com.sihaloho.catalogmovie.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.sihaloho.catalogmovie.data.entity.MovieEntityRoom
import com.sihaloho.catalogmovie.data.entity.TvShowEntityRoom
import com.sihaloho.catalogmovie.data.vo.Resource

interface CatalogDataSource {
    //movies
    fun getMovies(): LiveData<Resource<PagedList<MovieEntityRoom>>>
    fun getMovieFavorite(): LiveData<PagedList<MovieEntityRoom>>

    fun setMovieFavorite(movie: MovieEntityRoom)





    //tvShow
    fun getTvShow(): LiveData<Resource<PagedList<TvShowEntityRoom>>>
    fun getTvShowFavorite(): LiveData<PagedList<TvShowEntityRoom>>
    fun setTvShowFavorite(tvShow: TvShowEntityRoom)




}