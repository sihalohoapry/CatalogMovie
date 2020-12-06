package com.sihaloho.catalogmovie.data.room

import androidx.lifecycle.LiveData
import com.sihaloho.catalogmovie.data.entity.MovieEntityRoom
import com.sihaloho.catalogmovie.data.entity.TvShowEntityRoom

class LocalDataSource private constructor(private val mCatalogDao: CatalogDao){
    companion object{
        private var INSTANCE : LocalDataSource? = null

        fun getInstance(catalogDao: CatalogDao) : LocalDataSource =
            INSTANCE ?: LocalDataSource(catalogDao)
    }

    fun getAllMovie(): LiveData<List<MovieEntityRoom>> = mCatalogDao.getAllMovie()
    fun insertMovie(movie: List<MovieEntityRoom>) = mCatalogDao.insertMovie(movie)
    fun getFavMovie(): LiveData<List<MovieEntityRoom>> = mCatalogDao.getFavMovie()
    fun setFavMovie(movie: MovieEntityRoom, newState: Boolean) {
        movie.favorite_movie = newState
        mCatalogDao.updateMovie(movie)
    }

    fun getAllTvShow(): LiveData<List<TvShowEntityRoom>> = mCatalogDao.getAllTvShow()
    fun insertTvShow(tvShow: List<TvShowEntityRoom>) = mCatalogDao.insertTvShow(tvShow)
    fun getFavTvShow(): LiveData<List<TvShowEntityRoom>> = mCatalogDao.getFavTvShow()
    fun setFavTvShow(tvShowEntity: TvShowEntityRoom, newState: Boolean) {
        tvShowEntity.favorite_tv_show = newState
        mCatalogDao.updateTvShow(tvShowEntity)
    }




}