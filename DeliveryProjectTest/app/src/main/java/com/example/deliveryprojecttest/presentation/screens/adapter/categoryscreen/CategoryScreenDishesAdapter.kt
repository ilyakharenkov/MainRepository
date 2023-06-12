package com.example.deliveryprojecttest.presentation.screens.adapter.categoryscreen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.deliveryprojecttest.R
import com.example.deliveryprojecttest.databinding.ItemDishesBinding
import com.example.deliveryprojecttest.domain.model.Dishes

class CategoryScreenDishesAdapter :
    RecyclerView.Adapter<CategoryScreenDishesAdapter.CategoryScreenDishesViewHolder>() {

    var list: List<Dishes> = emptyList()
        set(value) {
            val dishesDiffUtils = DishesDiffUtils(field, value)
            val diffUtil = DiffUtil.calculateDiff(dishesDiffUtils)
            field = value
            diffUtil.dispatchUpdatesTo(this)
        }

    class CategoryScreenDishesViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding = ItemDishesBinding.bind(view)

        fun bind(dishes: Dishes) {

            Glide
                .with(binding.imageUrlView.context)
                .load(dishes.image_url)
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .error(R.drawable.ic_food_place_holder)
                .into(binding.imageUrlView)

            binding.textViewName.text = dishes.name

        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryScreenDishesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ItemDishesBinding = ItemDishesBinding.inflate(inflater, parent, false)
        return CategoryScreenDishesViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(
        categoryScreenDishesViewHolder: CategoryScreenDishesViewHolder,
        position: Int
    ) {
        categoryScreenDishesViewHolder.bind(list[position])
    }


}