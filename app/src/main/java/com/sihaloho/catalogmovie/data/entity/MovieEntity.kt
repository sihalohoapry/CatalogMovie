package com.sihaloho.catalogmovie.data.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieEntity(
    val id : String,
    val title: String,
    val release_date: String,
    val vote_average: Float,
    val overview: String?,
    val backdrop_path: String,
    val poster_path: String
) : Parcelable {
    val baseUrl get() = "https://image.tmdb.org/t/p/w500/"
}