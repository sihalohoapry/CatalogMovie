package com.sihaloho.catalogmovie.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.sihaloho.catalogmovie.R
import com.sihaloho.catalogmovie.data.viewmodel.MovieViewModel
import com.sihaloho.catalogmovie.data.viewmodel.ViewModelFactory
import com.sihaloho.catalogmovie.databinding.ActivityFavMovieBinding
import com.sihaloho.catalogmovie.ui.adapter.FavMovieAdapter
import com.sihaloho.catalogmovie.ui.adapter.MovieAdapter

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