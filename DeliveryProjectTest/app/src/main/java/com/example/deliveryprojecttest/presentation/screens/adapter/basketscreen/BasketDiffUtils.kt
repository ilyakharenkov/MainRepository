package com.example.deliveryprojecttest.presentation.screens.adapter.basketscreen

import androidx.recyclerview.widget.DiffUtil
import com.example.deliveryprojecttest.domain.model.Dishes

class BasketDiffUtils(private val oldList: List<Dishes>, private val newList: List<Dishes>) :
    DiffUtil.Callback() {

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