package com.sihaloho.catalogmovie.data.repository

import androidx.lifecycle.LiveData
import com.sihaloho.catalogmovie.data.ApiResponse
import com.sihaloho.catalogmovie.data.CatalogDataSource
import com.sihaloho.catalogmovie.data.NetworkBoundResource
import com.sihaloho.catalogmovie.data.RemoteDataSource
import com.sihaloho.catalogmovie.data.entity.MovieEntity
import com.sihaloho.catalogmovie.data.entity.MovieEntityRoom
import com.sihaloho.catalogmovie.data.entity.TvShowEntity
import com.sihaloho.catalogmovie.data.entity.TvShowEntityRoom
import com.sihaloho.catalogmovie.data.room.LocalDataSource
import com.sihaloho.catalogmovie.data.vo.Resource
import com.sihaloho.catalogmovie.utils.AppExecutors

class CatalogRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) :
    CatalogDataSource {
    companion object {
        @Volatile
        private var instance: CatalogRepository? = null
        fun getInstance(
            remoteData: RemoteDataSource,
            localData: LocalDataSource,
            appExecutors: AppExecutors
        ): CatalogRepository =
            instance ?: synchronized(this) {
                instance ?: CatalogRepository(remoteData, localData, appExecutors)
            }
    }

    override fun getMovies(): LiveData<Resource<List<MovieEntityRoom>>> {
        return object :
            NetworkBoundResource<List<MovieEntityRoom>, List<MovieEntity>>(appExecutors) {
            public override fun loadFromDB(): LiveData<List<MovieEntityRoom>> =
                localDataSource.getAllMovie()

            override fun shouldFetch(data: List<MovieEntityRoom>?): Boolean =
                data == null || data.isEmpty()


            public override fun createCall(): LiveData<ApiResponse<List<MovieEntity>>> =
                remoteDataSource.getMovies()

            public override fun saveCallResult(courseResponses: List<MovieEntity>) {
                val courseList = ArrayList<MovieEntityRoom>()
                for (response in courseResponses) {
                    val course = MovieEntityRoom(
                        response.id,
                        response.title,
                        response.release_date,
                        response.vote_average,
                        response.overview,
                        response.backdrop_path,
                        response.poster_path,
                        false)
                    courseList.add(course)
                }

                localDataSource.insertMovie(courseList)
            }
        }.asLiveData()

    }

    override fun getFavMovie(): LiveData<List<MovieEntityRoom>> =
        localDataSource.getFavMovie()

    override fun setMovieFav(movie: MovieEntityRoom, state: Boolean) {
        appExecutors.diskIO().execute { localDataSource.setFavMovie(movie, state) }
    }


    override fun getTvShow(): LiveData<Resource<List<TvShowEntityRoom>>> {

        return object :
            NetworkBoundResource<List<TvShowEntityRoom>, List<TvShowEntity>>(appExecutors) {
            public override fun loadFromDB(): LiveData<List<TvShowEntityRoom>> =
                localDataSource.getAllTvShow()

            override fun shouldFetch(data: List<TvShowEntityRoom>?): Boolean =
                data == null || data.isEmpty()


            public override fun createCall(): LiveData<ApiResponse<List<TvShowEntity>>> =
                remoteDataSource.getTvShow()

            public override fun saveCallResult(courseResponses: List<TvShowEntity>) {
                val courseList = ArrayList<TvShowEntityRoom>()
                for (response in courseResponses) {
                    val course = TvShowEntityRoom(
                        response.id,
                        response.original_name,
                        response.vote_average,
                        response?.overview,
                        response.backdrop_path,
                        response.poster_path,
                        response.first_air_date,
                        false)
                    courseList.add(course)
                }

                localDataSource.insertTvShow(courseList)
            }
        }.asLiveData()


    }

    override fun getFavTvShow(): LiveData<List<TvShowEntityRoom>> =
        localDataSource.getFavTvShow()

    override fun setTvShowFav(tvShow: TvShowEntityRoom, state: Boolean) {
        appExecutors.diskIO().execute { localDataSource.setFavTvShow(tvShow, state) }
    }
}


//        val tvShow = MutableLiveData<List<TvShowEntity>>()
//        CoroutineScope(IO).launch {
//            remoteDataSource.getTvShow(object : RemoteDataSource.LoadTvShowCallback {
//                override fun onAllTvShowReceived(tvShowResponse: List<TvShowEntity>) {
//                    val tvShowList = ArrayList<TvShowEntity>()
//                    for (response in tvShowResponse) {
//                        val movie = TvShowEntity(
//                            response.id,
//                            response.original_name,
//                            response.vote_average,
//                            response?.overview,
//                            response.backdrop_path,
//                            response.poster_path,
//                            response.first_air_date
//                        )
//                        tvShowList.add(movie)
//                    }
//                    tvShow.postValue(tvShowList)
//                }
//
//            })
//        }
//        return tvShow


//        val listMovie = MutableLiveData<List<MovieEntity>>()
//        CoroutineScope(IO).launch {
//            remoteDataSource.getMovies(object : RemoteDataSource.LoadMoviesCallback {
//                override fun onAllMoviesReceived(movieResponse: List<MovieEntity>) {
//                    val movieList = ArrayList<MovieEntity>()
//                    for (response in movieResponse) {
//                        val movie = MovieEntity(
//                            response.id,
//                            response.title,
//                            response.release_date,
//                            response.vote_average,
//                            response.overview,
//                            response.backdrop_path,
//                            response.poster_path
//                        )
//                        movieList.add(movie)
//                    }
//                    listMovie.postValue(movieList)
//                }
//            })
//        }
//        return listMovie