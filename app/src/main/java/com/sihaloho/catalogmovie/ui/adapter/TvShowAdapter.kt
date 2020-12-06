package com.sihaloho.catalogmovie.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.sihaloho.catalogmovie.R
import com.sihaloho.catalogmovie.data.entity.TvShowEntity
import com.sihaloho.catalogmovie.databinding.ItemListTvshowBinding
import com.sihaloho.catalogmovie.ui.activity.DetailMovieActivity

class TvShowAdapter : RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {

    lateinit var contextAdapter : Context
    private val listData = ArrayList<TvShowEntity>()

    fun setData(data: List<TvShowEntity>) {
        listData.clear()
        listData.addAll(data)
        notifyDataSetChanged()
    }

    inner class TvShowViewHolder(private val binding: ItemListTvshowBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(tvShow: TvShowEntity) {
            Glide.with(itemView)
                .load("${tvShow.baseUrl}${tvShow.poster_path}")
                .transition(DrawableTransitionOptions.withCrossFade())
                .error(R.drawable.ic_error)
                .into(binding.ivPoster)
            binding.tvTitle.text = tvShow.original_name
            binding.tvDate.text = tvShow.first_air_date
            binding.tvOverview.text = tvShow.overview
        }
    }


    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        holder.bind(listData[position])
        holder.itemView.setOnClickListener {
            val intent = Intent(contextAdapter, DetailMovieActivity::class.java)
            intent.putExtra(DetailMovieActivity.EXTRA_TV_SHOW, listData[position])
            contextAdapter.startActivity(intent)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowAdapter.TvShowViewHolder {
        contextAdapter = parent.context
        val binding =
            ItemListTvshowBinding.inflate(LayoutInflater.from(contextAdapter), parent, false)
        return TvShowViewHolder(binding)
    }

    override fun getItemCount(): Int = listData.size

}