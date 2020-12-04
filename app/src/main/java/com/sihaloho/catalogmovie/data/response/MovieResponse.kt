package com.sihaloho.catalogmovie.data.response

import com.sihaloho.catalogmovie.data.entity.MovieEntity

data class MovieResponse(
    val results : List<MovieEntity>
)