package com.sihaloho.catalogmovie.data.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.sihaloho.catalogmovie.data.entity.MovieEntity
import com.sihaloho.catalogmovie.data.entity.MovieEntityRoom
import com.sihaloho.catalogmovie.data.repository.CatalogRepository
import com.sihaloho.catalogmovie.data.vo.Resource

class MovieViewModel(private val repository: CatalogRepository) : ViewModel() {
    fun getMovies(): LiveData<Resource<List<MovieEntityRoom>>> = repository.getMovies()
}