package com.sihaloho.catalogmovie.data.room

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao
import com.sihaloho.catalogmovie.data.entity.MovieEntity
import com.sihaloho.catalogmovie.data.entity.MovieEntityRoom
import com.sihaloho.catalogmovie.data.entity.TvShowEntity
import com.sihaloho.catalogmovie.data.entity.TvShowEntityRoom

@Dao
interface CatalogDao {

    //movie
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movieEntity: List<MovieEntityRoom>)

    @Update
    fun updateMovie(movieEntity: MovieEntityRoom)

    @Delete
    fun deleteMovie(movieEntity: MovieEntityRoom)

    @Query("SELECT * from movie_entities")
    fun getAllMovie(): LiveData<List<MovieEntityRoom>>

    @Query("SELECT * FROM movie_entities WHERE id = :movieId")
    fun getDetailMovieById(movieId: String) : LiveData<MovieEntityRoom>

    @Query("SELECT * FROM movie_entities where favorite_movie = 1")
    fun getMovieFavorite(): LiveData<List<MovieEntityRoom>>



    //tvShow
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvShow(tvShowEntity: List<TvShowEntityRoom>)

    @Update
    fun updateTvShow(tvShowEntity: TvShowEntityRoom)

    @Delete
    fun deleteTvShow(tvShowEntity: TvShowEntityRoom)

    @Query("SELECT * from tv_show_entities")
    fun getAllTvShow(): LiveData<List<TvShowEntityRoom>>


    @Query("SELECT * FROM tv_show_entities WHERE id = :tvShowId")
    fun getDetailTvShowById(tvShowId: String) : LiveData<TvShowEntityRoom>

    @Query("SELECT * FROM tv_show_entities where favorite_tv_show = 1")
    fun getTvShowFavorite(): LiveData<List<TvShowEntityRoom>>








}