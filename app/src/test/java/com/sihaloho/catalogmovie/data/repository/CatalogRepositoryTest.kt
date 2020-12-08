package com.sihaloho.catalogmovie.data.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.paging.DataSource
import org.junit.Assert.*
import org.junit.Rule
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.doAnswer
import com.sihaloho.catalogmovie.data.FakeCatalogRepository
import com.sihaloho.catalogmovie.data.PagedListUtil
import com.sihaloho.catalogmovie.data.RemoteDataSource
import com.sihaloho.catalogmovie.data.entity.MovieEntityRoom
import com.sihaloho.catalogmovie.data.entity.TvShowEntityRoom
import com.sihaloho.catalogmovie.data.room.LocalDataSource
import com.sihaloho.catalogmovie.data.vo.Resource
import com.sihaloho.catalogmovie.ui.DataDumy
import com.sihaloho.catalogmovie.utils.AppExecutors
import com.sihaloho.catalogmovie.utils.LiveDataTestUtil
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock

class CatalogRepositoryTest{
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)

    private val catalogRepository = FakeCatalogRepository(remote,local,appExecutors)

    private val listMovieResponse = DataDumy.dataMovie()

    private val listTvShowResponse = DataDumy.dataTvShow()


    @Test
    fun getMovies() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntityRoom>
        Mockito.`when`(local.getAllMovie()).thenReturn(dataSourceFactory)
        catalogRepository.getMovies()

        val movieEntities = Resource.success(PagedListUtil.mockPagedList(DataDumy.dataMovie()))
        verify(local).getAllMovie()
        assertNotNull(movieEntities.data)
        assertEquals(listMovieResponse.size.toLong(), movieEntities.data?.size?.toLong())

    }

    @Test
    fun getTvShow() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntityRoom>
        Mockito.`when`(local.getAllTvShow()).thenReturn(dataSourceFactory)
        catalogRepository.getTvShow()

        val tvShowEntities = Resource.success(PagedListUtil.mockPagedList(DataDumy.dataTvShow()))
        verify(local).getAllTvShow()
        assertNotNull(tvShowEntities.data)
        assertEquals(listTvShowResponse.size.toLong(), tvShowEntities.data?.size?.toLong())
    }

}