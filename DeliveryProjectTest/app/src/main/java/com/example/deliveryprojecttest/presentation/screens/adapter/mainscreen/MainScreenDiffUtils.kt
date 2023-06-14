package com.example.deliveryprojecttest.presentation.screens.adapter.mainscreen

import androidx.recyclerview.widget.DiffUtil
import com.example.domain.model.Categories

class MainScreenDiffUtils(private val oldList: List<com.example.domain.model.Categories>, private val newList: List<com.example.domain.model.Categories>) : DiffUtil.Callback() {

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