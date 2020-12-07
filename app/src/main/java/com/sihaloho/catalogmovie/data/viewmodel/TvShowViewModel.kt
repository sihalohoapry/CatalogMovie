package com.sihaloho.catalogmovie.data.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.sihaloho.catalogmovie.data.entity.TvShowEntityRoom
import com.sihaloho.catalogmovie.data.repository.CatalogRepository
import com.sihaloho.catalogmovie.data.vo.Resource

class TvShowViewModel (private val repository: CatalogRepository) : ViewModel() {
    fun getTvShow(): LiveData<Resource<PagedList<TvShowEntityRoom>>> = repository.getTvShow()
}