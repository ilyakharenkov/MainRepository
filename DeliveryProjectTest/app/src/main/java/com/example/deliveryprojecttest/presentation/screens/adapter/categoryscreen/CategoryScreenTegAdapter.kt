package com.example.deliveryprojecttest.presentation.screens.adapter.categoryscreen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.deliveryprojecttest.databinding.ItemTegBinding
import com.example.deliveryprojecttest.domain.model.TestModel

class CategoryScreenTegAdapter : RecyclerView.Adapter<CategoryScreenTegAdapter.CategoryScreenTegViewHolder>() {

    var list: List<String> = emptyList()
        set(value){
            val tegDiffUtils = TegDiffUtils(field, value)
            val diffUtils = DiffUtil.calculateDiff(tegDiffUtils)
            field = value
            diffUtils.dispatchUpdatesTo(this)
        }

    class CategoryScreenTegViewHolder(view: View) : RecyclerView.ViewHolder(view){

        private val binding = ItemTegBinding.bind(view)

        fun bind(teg: String){
            binding.textViewTeg.text = teg
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryScreenTegViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemTegBinding.inflate(inflater, parent,false)
        return CategoryScreenTegViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(categoryScreenTegViewHolder: CategoryScreenTegViewHolder, position: Int) {
        categoryScreenTegViewHolder.bind(list[position])
    }

}