package com.sihaloho.catalogmovie.data.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import org.jetbrains.annotations.NotNull

@Parcelize

@Entity(tableName = "tv_show_entities")
data class TvShowEntityRoom(

    @PrimaryKey
    @NotNull
    @ColumnInfo(name = "id")
    val id : String,

    @ColumnInfo(name = "original_name")
    val original_name : String,

    @ColumnInfo(name = "vote_average")
    val vote_average: Float,

    @ColumnInfo(name = "overview")
    val overview: String?,

    @ColumnInfo(name = "backdrop_path")
    val backdrop_path: String?,

    @ColumnInfo(name = "poster_path")
    val poster_path: String?,

    @ColumnInfo(name = "first_air_date")
    val first_air_date: String,

    @ColumnInfo(name = "favorite_tv_show")
    var favorite_tv_show: Boolean = false

) : Parcelable{
    val baseUrl get() = "https://image.tmdb.org/t/p/w500/"
}