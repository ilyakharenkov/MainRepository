package com.example.deliveryprojecttest.presentation.screens.adapter.categoryscreen

import androidx.recyclerview.widget.DiffUtil
import com.example.domain.model.Dishes

class DishesDiffUtils(private val oldList: List<com.example.domain.model.Dishes>, private val newList: List<com.example.domain.model.Dishes>) : DiffUtil.Callback() {

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