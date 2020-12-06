package com.sihaloho.catalogmovie.data.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "movie_entities")
data class MovieEntityRoom(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    val id: String,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "release_date")
    val release_date: String,

    @ColumnInfo(name = "vote_average")
    val vote_average: Float,

    @ColumnInfo(name = "overview")
    val overview: String?,

    @ColumnInfo(name = "backdrop_path")
    val backdrop_path: String?,

    @ColumnInfo(name = "poster_path")
    val poster_path: String,

    @ColumnInfo(name = "favorite_movie")
    var favorite_movie: Boolean = false

) : Parcelable {
    val baseUrl get() = "https://image.tmdb.org/t/p/w500/"
}