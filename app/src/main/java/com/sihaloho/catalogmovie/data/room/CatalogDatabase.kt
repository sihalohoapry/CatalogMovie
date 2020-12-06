package com.sihaloho.catalogmovie.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sihaloho.catalogmovie.data.entity.MovieEntity
import com.sihaloho.catalogmovie.data.entity.MovieEntityRoom
import com.sihaloho.catalogmovie.data.entity.TvShowEntity
import com.sihaloho.catalogmovie.data.entity.TvShowEntityRoom

@Database(entities = [MovieEntityRoom::class, TvShowEntityRoom::class],version = 1, exportSchema = false)
abstract class CatalogDatabase : RoomDatabase() {
    abstract fun catalogDao() : CatalogDao

    companion object{

        @Volatile
        private  var INSTANCE: CatalogDatabase? = null
        fun getInstance(context: Context): CatalogDatabase =
            INSTANCE ?: synchronized(this){
                INSTANCE ?: Room.databaseBuilder(context.applicationContext,
                    CatalogDatabase::class.java,"Catalog.db").build()
            }

    }

}