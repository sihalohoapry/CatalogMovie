package com.sihaloho.catalogmovie.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.sihaloho.catalogmovie.R
import com.sihaloho.catalogmovie.data.entity.MovieEntity
import com.sihaloho.catalogmovie.data.entity.TvShowEntity
import com.sihaloho.catalogmovie.databinding.ActivityDetailMovieBinding

class DetailMovieActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
        const val EXTRA_TV_SHOW = "extra_tv_show"
    }
    private lateinit var binding : ActivityDetailMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<MovieEntity?>(EXTRA_MOVIE)
        val dataTvShow = intent.getParcelableExtra<TvShowEntity?>(EXTRA_TV_SHOW)
        if (data!=null){
            binding.apply {
                Glide.with(baseContext)
                        .load("${data.baseUrl}${data.poster_path}")
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .error(R.drawable.ic_error)
                        .into(ivPosterDetail)
                Glide.with(baseContext)
                        .load("${data.baseUrl}${data.backdrop_path}")
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .error(R.drawable.ic_error)
                        .into(ivBannerDetail)
                tvTitile.text = data.title
                tvDateDetail.text = data.release_date
                tvOverviewDetail.text = data.overview
                voteAverage.text = data.vote_average.toString()
            }
        }
        if (dataTvShow!=null){
            binding.apply {
                Glide.with(baseContext)
                        .load("${dataTvShow.baseUrl}${dataTvShow.poster_path}")
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .error(R.drawable.ic_error)
                        .into(ivPosterDetail)
                Glide.with(baseContext)
                        .load("${dataTvShow.baseUrl}${dataTvShow.backdrop_path}")
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .error(R.drawable.ic_error)
                        .into(ivBannerDetail)

                tvTitile.text = dataTvShow.original_name
                tvDateDetail.text = dataTvShow.first_air_date
                tvOverviewDetail.text = dataTvShow.overview
                voteAverage.text = dataTvShow.vote_average.toString()
            }
        }
        binding.ivArrowLeft.setOnClickListener {
            super.onBackPressed()
        }



    }
}