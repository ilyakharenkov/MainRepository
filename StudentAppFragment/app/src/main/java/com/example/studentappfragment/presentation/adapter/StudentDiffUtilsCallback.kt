package com.example.studentappfragment.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.studentappfragment.data.entity.StudentEntity

class StudentDiffUtilsCallback(
    private val oldList: List<StudentEntity>,
    private val newList: List<StudentEntity>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].idStudent == newList[newItemPosition].idStudent
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}