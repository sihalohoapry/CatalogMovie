package com.sihaloho.catalogmovie.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sihaloho.catalogmovie.data.viewmodel.MovieViewModel
import com.sihaloho.catalogmovie.data.viewmodel.ViewModelFactory
import com.sihaloho.catalogmovie.databinding.ActivityFavTvShowBinding
import com.sihaloho.catalogmovie.ui.adapter.TvShowAdapter

class FavTvShowActivity : AppCompatActivity() {


    private lateinit var binding: ActivityFavTvShowBinding
    private lateinit var adapter: TvShowAdapter
    private lateinit var mainViewModel : MovieViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavTvShowBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = TvShowAdapter()
        binding.rvTvShowFav.layoutManager = LinearLayoutManager(this)
        binding.rvTvShowFav.setHasFixedSize(true)
        binding.rvTvShowFav.adapter = adapter
        val factory = ViewModelFactory.getInstance(this)
        mainViewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]
        mainViewModel.getFavoriteTvShow().observe(this, { tvShow ->
            adapter.submitList(tvShow)
            adapter.notifyDataSetChanged()
        })



    }
}