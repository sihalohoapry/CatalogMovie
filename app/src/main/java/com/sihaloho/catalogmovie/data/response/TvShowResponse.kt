package com.sihaloho.catalogmovie.data.response

import com.sihaloho.catalogmovie.data.entity.TvShowEntity

data class TvShowResponse(
    val results : List<TvShowEntity>
)