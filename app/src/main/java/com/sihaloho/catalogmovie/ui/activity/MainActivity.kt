package com.sihaloho.catalogmovie.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sihaloho.catalogmovie.R
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