package com.sihaloho.catalogmovie.data.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.sihaloho.catalogmovie.data.repository.TvShowRepository

class TvShowViewModel @ViewModelInject constructor(private val repository: TvShowRepository) : ViewModel() {
    val tvShow = repository.getDataTvShow()
}