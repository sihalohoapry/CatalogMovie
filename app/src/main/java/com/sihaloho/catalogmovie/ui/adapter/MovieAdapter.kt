package com.sihaloho.catalogmovie.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.sihaloho.catalogmovie.R
import com.sihaloho.catalogmovie.data.entity.MovieEntity
import com.sihaloho.catalogmovie.databinding.ItemListMovieBinding
import com.sihaloho.catalogmovie.ui.DetailMovieActivity

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    lateinit var contextAdapter : Context
    private val listData = ArrayList<MovieEntity>()

    fun setData(data: List<MovieEntity>) {
        listData.clear()
        listData.addAll(data)
        notifyDataSetChanged()
    }

    inner class MovieViewHolder(private val binding: ItemListMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MovieEntity) {
            Glide.with(itemView)
                .load("${movie.baseUrl}${movie.poster_path}")
                .transition(DrawableTransitionOptions.withCrossFade())
                .error(R.drawable.ic_error)
                .into(binding.imageView2)
            binding.tvTitle.text = movie.title
            binding.tvDate.text = movie.release_date

        }


    }


    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(listData[position])
        holder.itemView.setOnClickListener {
            val intent = Intent(contextAdapter, DetailMovieActivity::class.java)
            intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, listData[position])
            contextAdapter.startActivity(intent)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        contextAdapter = parent.context
        val binding =
            ItemListMovieBinding.inflate(LayoutInflater.from(contextAdapter), parent, false)
        return MovieViewHolder(binding)
    }

    override fun getItemCount(): Int = listData.size

}