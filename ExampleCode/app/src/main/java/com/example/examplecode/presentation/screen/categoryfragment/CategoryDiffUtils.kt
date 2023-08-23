package com.example.examplecode.presentation.screen.categoryfragment

import androidx.recyclerview.widget.DiffUtil
import com.example.examplecode.domain.model.Category

class CategoryDiffUtils(private val oldList: List<Category>, private val newList: List<Category>) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

}