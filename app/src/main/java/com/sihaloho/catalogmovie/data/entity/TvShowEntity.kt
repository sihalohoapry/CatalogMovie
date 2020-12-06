package com.sihaloho.catalogmovie.data.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import org.jetbrains.annotations.NotNull

@Parcelize

data class TvShowEntity(


    val id : String,
    val original_name : String,
    val vote_average: Float,
    val overview: String?,
    val backdrop_path: String?,
    val poster_path: String,
    val first_air_date: String,
) : Parcelable{
    val baseUrl get() = "https://image.tmdb.org/t/p/w500/"
}