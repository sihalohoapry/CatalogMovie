package com.sihaloho.catalogmovie.data.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Assert.*
import org.junit.Rule
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.doAnswer
import com.sihaloho.catalogmovie.data.FakeCatalogRepository
import com.sihaloho.catalogmovie.data.RemoteDataSource
import com.sihaloho.catalogmovie.ui.DataDumy
import com.sihaloho.catalogmovie.utils.LiveDataTestUtil
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.mockito.Mockito.mock

class CatalogRepositoryTest{
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val catalogRepository = FakeCatalogRepository(remote)

    private val listMovieResponse = DataDumy.dataMovie()
    private val listTvShowResponse = DataDumy.dataTvShow()

    @Test
    fun getMovies() {
        runBlocking {
            doAnswer {invocation ->
                (invocation.arguments[0] as RemoteDataSource.LoadMoviesCallback).onAllMoviesReceived(listMovieResponse)
                null
            }.`when`(remote).getMovies(any())
        }

        val data = LiveDataTestUtil.getValue(catalogRepository.getMovies())

        runBlocking {
            verify(remote).getMovies(any())
        }

        assertNotNull(data)

        assertEquals(listMovieResponse.size.toLong(), data.size.toLong())

    }

    @Test
    fun getTvShow() {
        runBlocking {
            doAnswer { invocation ->
                (invocation.arguments[0] as RemoteDataSource.LoadTvShowCallback).onAllTvShowReceived(listTvShowResponse)
                null
            }.`when`(remote).getTvShow(any())
        }

        val data = LiveDataTestUtil.getValue(catalogRepository.getTvShow())

        runBlocking {
            verify(remote).getTvShow(any())
        }

        assertNotNull(data)
        assertEquals(listTvShowResponse.size.toLong(), data.size.toLong())
    }

}