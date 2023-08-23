package com.example.examplecode.presentation.screen.categoryfragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.examplecode.databinding.ItemCategoryBinding
import com.example.examplecode.domain.model.Category

class CategoryAdapter(private val click: (Category) -> Unit) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    var listCategory = listOf<Category>()
        set(value) {
            val categoryDiffUtil = CategoryDiffUtils(field, value)
            val diffUtil = DiffUtil.calculateDiff(categoryDiffUtil)
            field = value
            diffUtil.dispatchUpdatesTo(this)
        }

    class CategoryViewHolder(view: View) : ViewHolder(view){

        private val binding = ItemCategoryBinding.bind(view)

        fun bind(category: Category, click: (Category) -> Unit){
            binding.textView.text = category.name
            itemView.setOnClickListener {
                click(category)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCategoryBinding.inflate(inflater, parent, false)
        return CategoryViewHolder(view = binding.root)
    }

    override fun getItemCount(): Int {
        return listCategory.size
    }

    override fun onBindViewHolder(categoryViewHolder: CategoryViewHolder, position: Int) {
        categoryViewHolder.bind(category = listCategory[position], click = click)
    }

}