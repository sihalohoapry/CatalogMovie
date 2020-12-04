package com.sihaloho.catalogmovie.data.viewmodel


import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.sihaloho.catalogmovie.data.repository.MovieRepository

class MovieViewModel @ViewModelInject constructor(private val repository: MovieRepository) : ViewModel() {
    val movies = repository.getDataMovie()
}