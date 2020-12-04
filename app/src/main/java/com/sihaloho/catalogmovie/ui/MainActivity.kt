package com.sihaloho.catalogmovie.ui

import android.content.Intent
import android.content.Intent.EXTRA_USER
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.sihaloho.catalogmovie.data.entity.MovieEntity
import com.sihaloho.catalogmovie.data.entity.TvShowEntity
import com.sihaloho.catalogmovie.data.viewmodel.MovieViewModel
import com.sihaloho.catalogmovie.data.viewmodel.TvShowViewModel
import com.sihaloho.catalogmovie.databinding.ActivityMainBinding
import com.sihaloho.catalogmovie.ui.adapter.MovieAdapter
import com.sihaloho.catalogmovie.ui.adapter.TvShowAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(){
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel : MovieViewModel by viewModels<MovieViewModel>()
    private val tvViewModel : TvShowViewModel by viewModels<TvShowViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = MovieAdapter()
        adapter.notifyDataSetChanged()

        binding.rvMovie.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvMovie.setHasFixedSize(true)
        binding.rvMovie.adapter = adapter
        mainViewModel.movies.observe(this){
            adapter.setData(it)
        }

        val adapterTv = TvShowAdapter()
        adapterTv.notifyDataSetChanged()

        binding.rvTvShow.setHasFixedSize(true)
        binding.rvTvShow.adapter = adapterTv
        tvViewModel.tvShow.observe(this){
            adapterTv.setData(it)
        }

    }

}