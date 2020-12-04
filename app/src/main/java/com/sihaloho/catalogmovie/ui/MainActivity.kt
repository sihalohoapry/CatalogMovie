package com.sihaloho.catalogmovie.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.sihaloho.catalogmovie.data.viewmodel.MovieViewModel
import com.sihaloho.catalogmovie.data.viewmodel.TvShowViewModel
import com.sihaloho.catalogmovie.data.viewmodel.ViewModelFactory
import com.sihaloho.catalogmovie.databinding.ActivityMainBinding
import com.sihaloho.catalogmovie.ui.adapter.MovieAdapter
import com.sihaloho.catalogmovie.ui.adapter.TvShowAdapter

class MainActivity : AppCompatActivity(){
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel : MovieViewModel
    private lateinit var tvShowViewModel : TvShowViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = MovieAdapter()
        adapter.notifyDataSetChanged()
        binding.rvMovie.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvMovie.setHasFixedSize(true)
        binding.rvMovie.adapter = adapter
        val factory = ViewModelFactory.getInstance(this)
        mainViewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]
        mainViewModel.getMovies().observe(this){
            adapter.setData(it)
        }


        val adapterTv = TvShowAdapter()
        adapterTv.notifyDataSetChanged()
        binding.rvTvShow.setHasFixedSize(true)
        binding.rvTvShow.adapter = adapterTv
        val factoryTvShow = ViewModelFactory.getInstance(this)
        tvShowViewModel = ViewModelProvider(this, factoryTvShow)[TvShowViewModel::class.java]
        tvShowViewModel.getTvShow().observe(this){
            adapterTv.setData(it)
        }

    }

}