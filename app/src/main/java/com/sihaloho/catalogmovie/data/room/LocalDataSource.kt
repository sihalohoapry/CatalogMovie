package com.sihaloho.catalogmovie.data.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.sihaloho.catalogmovie.data.entity.MovieEntityRoom
import com.sihaloho.catalogmovie.data.entity.TvShowEntityRoom

class LocalDataSource private constructor(private val mCatalogDao: CatalogDao){
    companion object{
        private var INSTANCE : LocalDataSource? = null

        fun getInstance(catalogDao: CatalogDao) : LocalDataSource =
            INSTANCE ?: LocalDataSource(catalogDao)
    }

    //movie
    fun getAllMovie(): DataSource.Factory<Int, MovieEntityRoom> = mCatalogDao.getAllMovie()

    fun insertMovie(movie: List<MovieEntityRoom>) = mCatalogDao.insertMovie(movie)
    fun getDetailMovie(movieId: String) : LiveData<MovieEntityRoom> = mCatalogDao.getDetailMovieById(movieId)


    //tvShow
    fun getAllTvShow(): DataSource.Factory<Int, TvShowEntityRoom> = mCatalogDao.getAllTvShow()
    fun insertTvShow(tvShow: List<TvShowEntityRoom>) = mCatalogDao.insertTvShow(tvShow)
    fun getDetailTvShow(tvShowId: String) : LiveData<TvShowEntityRoom> = mCatalogDao.getDetailTvShowById(tvShowId)

    //favorite
    fun getMovieFavorite(): DataSource.Factory<Int, MovieEntityRoom> = mCatalogDao.getMovieFavorite()

    fun getTvShowFavorite(): DataSource.Factory<Int, TvShowEntityRoom> = mCatalogDao.getTvShowFavorite()



    fun setMovieFavorite(movie : MovieEntityRoom) {
        movie.favorite_movie = !movie.favorite_movie
        mCatalogDao.updateMovie(movie)
    }

    fun setTvShowFavorite(tvShow: TvShowEntityRoom) {
        tvShow.favorite_tv_show = !tvShow.favorite_tv_show
        mCatalogDao.updateTvShow(tvShow)
    }

}