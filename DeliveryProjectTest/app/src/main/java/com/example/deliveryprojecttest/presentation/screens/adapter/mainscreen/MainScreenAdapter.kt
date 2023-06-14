package com.example.deliveryprojecttest.presentation.screens.adapter.mainscreen

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.deliveryprojecttest.R
import com.example.deliveryprojecttest.databinding.ItemCategoriesBinding
import com.example.deliveryprojecttest.domain.model.Categories

class MainScreenAdapter(private val click: (category: String) -> Unit) : RecyclerView.Adapter<MainScreenAdapter.MainScreenViewHolder>() {

    var listCategories: List<Categories> = listOf()
        set(value) {
            val mainScreenDiffUtils = MainScreenDiffUtils(field, value)
            val diffUtil = DiffUtil.calculateDiff(mainScreenDiffUtils)
            field = value
            diffUtil.dispatchUpdatesTo(this)
        }

    class MainScreenViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding: ItemCategoriesBinding = ItemCategoriesBinding.bind(view)

        fun bind(categories: Categories, click: (category: String) -> Unit) {

            Glide
                .with(binding.imageBackground.context)
                .load(categories.image_url)
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .addListener(object : RequestListener<Drawable> {
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        binding.progressBar.visibility = View.INVISIBLE
                        return false
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        binding.progressBar.visibility = View.INVISIBLE
                        return false
                    }
                })
                .error(R.drawable.ic_food_place_holder)
                .into(binding.imageBackground)

            binding.nameCategories.text = categories.name

            itemView.setOnClickListener {
                click(categories.name)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainScreenViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCategoriesBinding.inflate(inflater, parent, false)
        return MainScreenViewHolder(view = binding.root)
    }

    override fun getItemCount(): Int {
        return listCategories.size
    }

    override fun onBindViewHolder(mainScreenViewHolder: MainScreenViewHolder, position: Int) {
        mainScreenViewHolder.bind(categories = listCategories[position], click = click)
    }

}