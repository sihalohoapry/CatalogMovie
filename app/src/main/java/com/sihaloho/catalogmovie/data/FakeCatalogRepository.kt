package com.sihaloho.catalogmovie.data

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.sihaloho.catalogmovie.data.entity.MovieEntity
import com.sihaloho.catalogmovie.data.entity.MovieEntityRoom
import com.sihaloho.catalogmovie.data.entity.TvShowEntity
import com.sihaloho.catalogmovie.data.entity.TvShowEntityRoom
import com.sihaloho.catalogmovie.data.room.LocalDataSource
import com.sihaloho.catalogmovie.data.vo.Resource
import com.sihaloho.catalogmovie.utils.AppExecutors
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FakeCatalogRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) :
    CatalogDataSource {


    //movie
    override fun getMovies(): LiveData<Resource<PagedList<MovieEntityRoom>>> {
        return object : NetworkBoundResource<PagedList<MovieEntityRoom>, List<MovieEntity>>(appExecutors) {
            public override fun loadFromDB(): LiveData<PagedList<MovieEntityRoom>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllMovie(), config).build()
            }

            override fun shouldFetch(data: PagedList<MovieEntityRoom>?): Boolean =
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
                        false
                    )
                    courseList.add(course)
                }

                localDataSource.insertMovie(courseList)
            }
        }.asLiveData()

    }

    override fun getMovieFavorite(): LiveData<PagedList<MovieEntityRoom>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getMovieFavorite(), config).build()

    }


    override fun setMovieFavorite(movie: MovieEntityRoom) {
        CoroutineScope(Dispatchers.IO).launch {
            localDataSource.setMovieFavorite(movie)
        }
    }

    fun getMovieDetail(movieId: String): LiveData<MovieEntityRoom> =
        localDataSource.getDetailMovie(movieId)


    //tvShow
    override fun getTvShow(): LiveData<Resource<PagedList<TvShowEntityRoom>>> {

        return object : NetworkBoundResource<PagedList<TvShowEntityRoom>, List<TvShowEntity>>(appExecutors) {
            public override fun loadFromDB(): LiveData<PagedList<TvShowEntityRoom>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllTvShow(), config).build()
            }

            override fun shouldFetch(data: PagedList<TvShowEntityRoom>?): Boolean =
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
                        false
                    )
                    courseList.add(course)
                }

                localDataSource.insertTvShow(courseList)
            }
        }.asLiveData()


    }

    override fun getTvShowFavorite(): LiveData<PagedList<TvShowEntityRoom>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getTvShowFavorite(), config).build()
    }

    override fun setTvShowFavorite(tvShow: TvShowEntityRoom) {
        CoroutineScope(Dispatchers.IO).launch {
            localDataSource.setTvShowFavorite(tvShow)
        }
    }

    fun getTvShowDetail(tvShowId: String): LiveData<TvShowEntityRoom> =
        localDataSource.getDetailTvShow(tvShowId)


}