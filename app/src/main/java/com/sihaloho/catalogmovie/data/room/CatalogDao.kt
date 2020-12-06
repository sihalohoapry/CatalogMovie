package com.sihaloho.catalogmovie.data.room

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao
import com.sihaloho.catalogmovie.data.entity.MovieEntityRoom
import com.sihaloho.catalogmovie.data.entity.TvShowEntityRoom

@Dao
interface CatalogDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movieEntity: List<MovieEntityRoom>)

    @Update
    fun updateMovie(movieEntity: MovieEntityRoom)

    @Delete
    fun deleteMovie(movieEntity: MovieEntityRoom)

    @Query("SELECT * from movie_entities")
    fun getAllMovie(): LiveData<List<MovieEntityRoom>>

    @Query("SELECT * FROM movie_entities where favorite_movie = 1")
    fun getFavMovie(): LiveData<List<MovieEntityRoom>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvShow(tvShowEntity: List<TvShowEntityRoom>)

    @Update
    fun updateTvShow(tvShowEntity: TvShowEntityRoom)

    @Delete
    fun deleteTvShow(tvShowEntity: TvShowEntityRoom)

    @Query("SELECT * from tv_show_entities")
    fun getAllTvShow(): LiveData<List<TvShowEntityRoom>>

    @Query("SELECT * FROM tv_show_entities where favorite_tv_show = 1")
    fun getFavTvShow(): LiveData<List<TvShowEntityRoom>>

}