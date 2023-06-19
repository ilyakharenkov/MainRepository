package com.example.deliveryprojecttest.presentation.screens.adapter.basketscreen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.deliveryprojecttest.R
import com.example.deliveryprojecttest.databinding.ItemBasketBinding
import com.example.deliveryprojecttest.domain.model.Dishes

class BasketScreenAdapter(private val onClickSum:(dishes: Dishes) -> Unit, private val onClickDiff:(dishes: Dishes) -> Unit) : RecyclerView.Adapter<BasketScreenAdapter.BasketScreenViewHolder>() {

    var list: List<Dishes> = emptyList()
        set(value) {
            val basketDiffUtil = BasketDiffUtils(field, value)
            val diffUtil = DiffUtil.calculateDiff(basketDiffUtil)
            field = value
            diffUtil.dispatchUpdatesTo(this)
        }

    class BasketScreenViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding = ItemBasketBinding.bind(view)

        fun bind(dishes: Dishes, onClickSum:(dishes: Dishes) -> Unit, onClickDiff:(dishes: Dishes) -> Unit) {

            Glide
                .with(binding.imageView.context)
                .load(dishes.image_url)
                .error(R.drawable.ic_food_place_holder)
                .into(binding.imageView)

            binding.tvNameDishes.text = dishes.name
            binding.tvPriceDishes.text = dishes.price.toString()
            binding.tvWeightDishes.text = dishes.weight.toString()

            binding.btnDiff.setOnClickListener {
                onClickDiff(dishes)
            }
            binding.btnSum.setOnClickListener {
                onClickSum(dishes)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasketScreenViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBasketBinding.inflate(inflater, parent, false)
        return BasketScreenViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(basketScreenViewHolder: BasketScreenViewHolder, position: Int) {
        basketScreenViewHolder.bind(list[position], onClickSum, onClickDiff)
    }

}