package com.sihaloho.catalogmovie.data.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.sihaloho.catalogmovie.data.entity.MovieEntity
import com.sihaloho.catalogmovie.data.entity.MovieEntityRoom
import com.sihaloho.catalogmovie.data.entity.TvShowEntity
import com.sihaloho.catalogmovie.data.entity.TvShowEntityRoom
import com.sihaloho.catalogmovie.data.repository.CatalogRepository
import com.sihaloho.catalogmovie.data.vo.Resource

class MovieViewModel(private val repository: CatalogRepository) : ViewModel() {
    fun getMovies(): LiveData<Resource<List<MovieEntityRoom>>> = repository.getMovies()
    fun getMovieDetail(movieId: String): LiveData<MovieEntityRoom> =
        repository.getMovieDetail(movieId)
    fun getTvShowDetail(tvShowId: String): LiveData<TvShowEntityRoom> =
        repository.getTvShowDetail(tvShowId)


    fun getFavoriteMovie(): LiveData<List<MovieEntityRoom>> {
        return repository.getMovieFavorite()
    }

    fun setFavoriteMovie(movie: MovieEntityRoom){
        repository.setMovieFavorite(movie)
    }
    fun setFavoriteTvShow(tvShow: TvShowEntityRoom, state: Boolean){
        repository.setTvShowFavorite(tvShow,state)
    }

}