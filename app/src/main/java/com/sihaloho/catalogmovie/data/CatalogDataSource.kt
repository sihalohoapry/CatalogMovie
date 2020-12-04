package com.sihaloho.catalogmovie.data

import androidx.lifecycle.LiveData
import com.sihaloho.catalogmovie.data.entity.MovieEntity

interface CatalogDataSource {
    fun getMovies(): LiveData<List<MovieEntity>>
    fun getTvShow(): LiveData<List<MovieEntity>>
}