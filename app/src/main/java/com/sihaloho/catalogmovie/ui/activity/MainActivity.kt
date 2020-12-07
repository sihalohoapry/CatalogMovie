package com.sihaloho.catalogmovie.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sihaloho.catalogmovie.R
import com.sihaloho.catalogmovie.data.viewmodel.MovieViewModel
import com.sihaloho.catalogmovie.data.viewmodel.TvShowViewModel
import com.sihaloho.catalogmovie.data.viewmodel.ViewModelFactory
import com.sihaloho.catalogmovie.data.vo.Status
import com.sihaloho.catalogmovie.databinding.ActivityMainBinding
import com.sihaloho.catalogmovie.ui.adapter.MovieAdapter
import com.sihaloho.catalogmovie.ui.adapter.TvShowAdapter

class MainActivity : AppCompatActivity(){
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel : MovieViewModel
    private lateinit var tvShowViewModel : TvShowViewModel
    private lateinit var adapter : MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvMovie.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvMovie.setHasFixedSize(true)
        adapter = MovieAdapter()
        binding.rvMovie.adapter = adapter

        val factory = ViewModelFactory.getInstance(this)
        mainViewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]
        mainViewModel.getMovies().observe(this,{ movies ->

            if (movies != null) {
                when (movies.status) {
                    Status.LOADING -> binding.progressBar.visibility = View.VISIBLE
                    Status.SUCCESS -> {
                        binding.progressBar.visibility = View.GONE
                        adapter.submitList(movies.data)
                        binding.rvMovie.adapter = adapter
                        adapter.notifyDataSetChanged()
                    }
                    Status.ERROR -> {
                        binding.progressBar.visibility = View.GONE
                        Toast.makeText(this, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })


        val adapterTv = TvShowAdapter()
        adapterTv.notifyDataSetChanged()
        binding.rvTvShow.setHasFixedSize(true)
        binding.rvTvShow.adapter = adapterTv
        val factoryTvShow = ViewModelFactory.getInstance(this)
        tvShowViewModel = ViewModelProvider(this, factoryTvShow)[TvShowViewModel::class.java]
        tvShowViewModel.getTvShow().observe(this,{ tvShow->
            if (tvShow != null) {
                when (tvShow.status) {
                    Status.LOADING -> binding.progressBar.visibility = View.VISIBLE
                    Status.SUCCESS -> {
                        binding.progressBar.visibility = View.GONE
                        adapterTv.submitList(tvShow.data)
                        adapterTv.notifyDataSetChanged()
                    }
                    Status.ERROR -> {
                        binding.progressBar.visibility = View.GONE
                        Toast.makeText(this, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.item_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.fav_movie ->{
                startActivity(Intent(this, FavMovieActivity::class.java))
            }

            R.id.fav_tv_show ->{
                startActivity(Intent(this, FavTvShowActivity::class.java))
            }

        }
        return super.onOptionsItemSelected(item)
    }

}