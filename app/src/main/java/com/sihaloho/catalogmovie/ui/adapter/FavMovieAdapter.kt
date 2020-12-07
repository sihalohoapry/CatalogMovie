package com.sihaloho.catalogmovie.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.sihaloho.catalogmovie.R
import com.sihaloho.catalogmovie.data.entity.MovieEntityRoom
import com.sihaloho.catalogmovie.databinding.ItemListTvshowBinding
import com.sihaloho.catalogmovie.ui.activity.DetailMovieActivity

class FavMovieAdapter : PagedListAdapter<MovieEntityRoom, FavMovieAdapter.MovieViewHolder>(DIFF_CALLBACK) {

    lateinit var contextAdapter : Context

    fun getSwipedData(swipedPosition: Int): MovieEntityRoom? = getItem(swipedPosition)

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieEntityRoom>() {
            override fun areItemsTheSame(oldItem: MovieEntityRoom, newItem: MovieEntityRoom): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: MovieEntityRoom,
                newItem: MovieEntityRoom
            ): Boolean {
                return oldItem == newItem
            }
        }
    }


    class MovieViewHolder(private val binding: ItemListTvshowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MovieEntityRoom) {
            Glide.with(itemView)
                .load("${movie.baseUrl}${movie.poster_path}")
                .transition(DrawableTransitionOptions.withCrossFade())
                .error(R.drawable.ic_error)
                .into(binding.ivPoster)
            binding.tvTitle.text = movie.title
            binding.tvDate.text = movie.release_date
            binding.tvOverview.text = movie.overview
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, DetailMovieActivity::class.java)
                intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, movie)
                itemView.context.startActivity(intent)
            }
        }


    }


    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = getItem(position)
        if (movie != null){
            holder.bind(movie)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        contextAdapter = parent.context
        val binding =
            ItemListTvshowBinding.inflate(LayoutInflater.from(contextAdapter), parent, false)
        return MovieViewHolder(binding)
    }


}