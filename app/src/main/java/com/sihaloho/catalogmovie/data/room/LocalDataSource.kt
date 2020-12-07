package com.sihaloho.catalogmovie.data.room

import androidx.lifecycle.LiveData
import com.sihaloho.catalogmovie.data.entity.MovieEntity
import com.sihaloho.catalogmovie.data.entity.MovieEntityRoom
import com.sihaloho.catalogmovie.data.entity.TvShowEntity
import com.sihaloho.catalogmovie.data.entity.TvShowEntityRoom

class LocalDataSource private constructor(private val mCatalogDao: CatalogDao){
    companion object{
        private var INSTANCE : LocalDataSource? = null

        fun getInstance(catalogDao: CatalogDao) : LocalDataSource =
            INSTANCE ?: LocalDataSource(catalogDao)
    }

    //movie
    fun getAllMovie(): LiveData<List<MovieEntityRoom>> = mCatalogDao.getAllMovie()
    fun insertMovie(movie: List<MovieEntityRoom>) = mCatalogDao.insertMovie(movie)
    fun getDetailMovie(movieId: String) : LiveData<MovieEntityRoom> = mCatalogDao.getDetailMovieById(movieId)


    //tvShow
    fun getAllTvShow(): LiveData<List<TvShowEntityRoom>> = mCatalogDao.getAllTvShow()
    fun insertTvShow(tvShow: List<TvShowEntityRoom>) = mCatalogDao.insertTvShow(tvShow)
    fun getDetailTvShow(tvShowId: String) : LiveData<TvShowEntityRoom> = mCatalogDao.getDetailTvShowById(tvShowId)

    //favorite
    fun getMovieFavorite(): LiveData<List<MovieEntityRoom>> = mCatalogDao.getMovieFavorite()
    fun getTvShowFavorite(): LiveData<List<TvShowEntityRoom>> = mCatalogDao.getTvShowFavorite()

    //setFav
//    fun setMovieFavorite(movie: MovieEntityRoom, newState: Boolean) {
//        movie.favorite_movie = newState
//        mCatalogDao.updateMovie(movie)
//    }

    fun setMovieFavorite(movie : MovieEntityRoom) {
        movie.favorite_movie = !movie.favorite_movie
        mCatalogDao.updateMovie(movie)
    }

    fun setTvShowFavorite(tvShow: TvShowEntityRoom, newState: Boolean) {
        tvShow.favorite_tv_show = newState
        mCatalogDao.updateTvShow(tvShow)
    }

}