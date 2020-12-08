package com.sihaloho.catalogmovie.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sihaloho.catalogmovie.data.viewmodel.MovieViewModel
import com.sihaloho.catalogmovie.data.viewmodel.ViewModelFactory
import com.sihaloho.catalogmovie.databinding.ActivityFavMovieBinding
import com.sihaloho.catalogmovie.ui.adapter.FavMovieAdapter

class FavMovieActivity : AppCompatActivity() {

    private lateinit var binding : ActivityFavMovieBinding
    private lateinit var mainViewModel : MovieViewModel


    private lateinit var adapter: FavMovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = FavMovieAdapter()
        adapter.notifyDataSetChanged()
        binding.rvMovieFav.layoutManager = LinearLayoutManager(this)
        binding.rvMovieFav.setHasFixedSize(true)
        binding.rvMovieFav.adapter = adapter
        val factory = ViewModelFactory.getInstance(this)
        mainViewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]
        mainViewModel.getFavoriteMovie().observe(this, { movies ->
            adapter.submitList(movies)
            adapter.notifyDataSetChanged()
        })

    }


}