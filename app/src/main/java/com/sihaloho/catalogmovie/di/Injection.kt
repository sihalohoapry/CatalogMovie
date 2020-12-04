package com.sihaloho.catalogmovie.di

import com.sihaloho.catalogmovie.data.RemoteDataSource
import com.sihaloho.catalogmovie.data.repository.CatalogRepository

object Injection {
    fun provideRepository(): CatalogRepository {

        val remoteDataSource = RemoteDataSource.getInstance()
        return CatalogRepository.getInstance(remoteDataSource)
    }
}