package com.sihaloho.catalogmovie.data

import androidx.lifecycle.LiveData
import com.sihaloho.catalogmovie.data.entity.MovieEntity
import com.sihaloho.catalogmovie.data.entity.TvShowEntity

interface CatalogDataSource {
    fun getMovies(): LiveData<List<MovieEntity>>
    fun getTvShow(): LiveData<List<TvShowEntity>>
}