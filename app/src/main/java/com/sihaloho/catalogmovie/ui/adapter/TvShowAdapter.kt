package com.sihaloho.catalogmovie.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.sihaloho.catalogmovie.R
import com.sihaloho.catalogmovie.data.entity.TvShowEntityRoom
import com.sihaloho.catalogmovie.databinding.ItemListTvshowBinding
import com.sihaloho.catalogmovie.ui.activity.DetailMovieActivity

class TvShowAdapter : RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {

    private val listData = ArrayList<TvShowEntityRoom>()

    fun setData(data: List<TvShowEntityRoom>) {
        listData.clear()
        listData.addAll(data)
        notifyDataSetChanged()
    }

    inner class TvShowViewHolder(private val binding: ItemListTvshowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: TvShowEntityRoom) {
            with(binding){
                Glide.with(itemView.context)
                    .load("${tvShow.baseUrl}${tvShow.poster_path}")
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .error(R.drawable.ic_error)
                    .into(binding.ivPoster)
                tvTitle.text = tvShow.original_name
                tvDate.text = tvShow.first_air_date
                tvOverview.text = tvShow.overview

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailMovieActivity::class.java)
                    intent.putExtra(DetailMovieActivity.EXTRA_TV_SHOW, listData[position])
                    itemView.context.startActivity(intent)
                }
            }
        }
    }


    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        holder.bind(listData[position])

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowAdapter.TvShowViewHolder {
        val binding =
            ItemListTvshowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowViewHolder(binding)
    }

    override fun getItemCount(): Int = listData.size

}