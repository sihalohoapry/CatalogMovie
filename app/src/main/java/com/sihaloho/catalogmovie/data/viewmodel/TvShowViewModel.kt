package com.sihaloho.catalogmovie.data.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.sihaloho.catalogmovie.data.entity.TvShowEntity
import com.sihaloho.catalogmovie.data.repository.CatalogRepository

class TvShowViewModel (private val repository: CatalogRepository) : ViewModel() {
    fun getTvShow(): LiveData<List<TvShowEntity>> = repository.getTvShow()
}