package com.sihaloho.catalogmovie.ui.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.sihaloho.catalogmovie.R
import com.sihaloho.catalogmovie.data.entity.MovieEntityRoom
import com.sihaloho.catalogmovie.data.entity.TvShowEntityRoom
import com.sihaloho.catalogmovie.data.viewmodel.MovieViewModel
import com.sihaloho.catalogmovie.data.viewmodel.ViewModelFactory
import com.sihaloho.catalogmovie.databinding.ActivityDetailMovieBinding

class DetailMovieActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
        const val EXTRA_TV_SHOW = "extra_tv_show"
    }

    private lateinit var binding: ActivityDetailMovieBinding
    private lateinit var viewModel: MovieViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]

        val data = intent.getParcelableExtra<MovieEntityRoom?>(EXTRA_MOVIE)
        val dataTvShow = intent.getParcelableExtra<TvShowEntityRoom?>(EXTRA_TV_SHOW)
        if (data != null) {
            val movieId = data.id
            detailMovie(movieId)
        }
        if (dataTvShow != null) {
            val tvShowId = dataTvShow.id
            detailTvShow(tvShowId)
        }
        binding.ivArrowLeft.setOnClickListener {
            super.onBackPressed()
        }

    }


    private fun detailTvShow(tvShowId: String) {
        viewModel.getTvShowDetail(tvShowId).observe(this, Observer {
            displayDataTvShow(it)
        })
    }

    private fun displayDataTvShow(tvShow: TvShowEntityRoom) {
        binding.apply {
            Glide.with(baseContext)
                .load("${tvShow.baseUrl}${tvShow.poster_path}")
                .transition(DrawableTransitionOptions.withCrossFade())
                .error(R.drawable.ic_error)
                .into(ivPosterDetail)
            Glide.with(baseContext)
                .load("${tvShow.baseUrl}${tvShow.backdrop_path}")
                .transition(DrawableTransitionOptions.withCrossFade())
                .error(R.drawable.ic_error)
                .into(ivBannerDetail)

            tvTitile.text = tvShow.original_name
            tvDateDetail.text = tvShow.first_air_date
            tvOverviewDetail.text = tvShow.overview
            voteAverage.text = tvShow.vote_average.toString()
            val statusFav = tvShow.favorite_tv_show

            statusFav.let { status ->
                setFavStatus(status)
            }
            binding.fabLove.setOnClickListener {
                val dataTvShow = intent.getParcelableExtra<TvShowEntityRoom?>(EXTRA_TV_SHOW)
                if (dataTvShow != null) {
                    setFavoriteTvShow(tvShow)
                }


            }


        }
    }

    private fun setFavoriteTvShow(dataTvShow: TvShowEntityRoom) {
        if (dataTvShow != null) {
            if (dataTvShow.favorite_tv_show) {
                Toast.makeText(this, "Removed from favorite", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Added to favorite", Toast.LENGTH_SHORT).show()
            }
            viewModel.setFavoriteTvShow(dataTvShow)
        }
    }

    private fun detailMovie(movieId: String) {
        viewModel.getMovieDetail(movieId).observe(this, Observer {
            displayDataMovie(it)
        })
    }

    private fun displayDataMovie(movie: MovieEntityRoom) {
        binding.apply {
            Glide.with(baseContext)
                .load("${movie.baseUrl}${movie.poster_path}")
                .transition(DrawableTransitionOptions.withCrossFade())
                .error(R.drawable.ic_error)
                .into(ivPosterDetail)
            Glide.with(baseContext)
                .load("${movie.baseUrl}${movie.backdrop_path}")
                .transition(DrawableTransitionOptions.withCrossFade())
                .error(R.drawable.ic_error)
                .into(ivBannerDetail)
            tvTitile.text = movie.title
            tvDateDetail.text = movie.release_date
            tvOverviewDetail.text = movie.overview
            voteAverage.text = movie.vote_average.toString()

            val statusFav = movie.favorite_movie

            statusFav?.let { status ->
                setFavoriteState(status)
            }

            binding.fabLove.setOnClickListener {
                val data = intent.getParcelableExtra<MovieEntityRoom?>(EXTRA_MOVIE)
                if (data != null){
                    setFavoriteMovie(movie)
                }


            }




        }
    }

    private fun setFavoriteMovie(movie: MovieEntityRoom) {
        if (movie != null) {
            if (movie.favorite_movie) {
                Toast.makeText(this, getString(R.string.remove), Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, getString(R.string.added), Toast.LENGTH_SHORT).show()
            }
            viewModel.setFavoriteMovie(movie)
        }
    }

    private fun setFavoriteState(status: Boolean) {
        if (status) {
            binding.fabLove.setImageResource(R.drawable.ic_fav_ok)
        } else {
            binding.fabLove.setImageResource(R.drawable.ic_fav_border)
        }
    }

    private fun setFavStatus(statusFav: Boolean) {

        if (statusFav) {
            binding.fabLove.setImageResource(R.drawable.ic_fav_ok)
        } else {
            binding.fabLove.setImageResource(R.drawable.ic_fav_border)
        }

    }

}