package com.example.deliveryprojecttest.presentation.screens.adapter.mainscreen

import androidx.recyclerview.widget.DiffUtil
import com.example.deliveryprojecttest.domain.model.Categories

class MainScreenDiffUtils(private val oldList: List<Categories>, private val newList: List<Categories>) : DiffUtil.Callback() {

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