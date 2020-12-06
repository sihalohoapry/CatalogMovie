package com.sihaloho.catalogmovie.di

import android.content.Context
import com.sihaloho.catalogmovie.data.RemoteDataSource
import com.sihaloho.catalogmovie.data.repository.CatalogRepository
import com.sihaloho.catalogmovie.data.room.CatalogDatabase
import com.sihaloho.catalogmovie.data.room.LocalDataSource
import com.sihaloho.catalogmovie.utils.AppExecutors

object Injection {
    fun provideRepository(context: Context): CatalogRepository {

        val database = CatalogDatabase.getInstance(context)
        val localDataSource = LocalDataSource.getInstance(database.catalogDao())
        val appExecutors = AppExecutors()
        val remoteDataSource = RemoteDataSource.getInstance()
        return CatalogRepository.getInstance(remoteDataSource,localDataSource,appExecutors)
    }
}