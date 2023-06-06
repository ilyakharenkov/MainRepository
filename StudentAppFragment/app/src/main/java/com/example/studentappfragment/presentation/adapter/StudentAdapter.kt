package com.example.studentappfragment.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.studentappfragment.R
import com.example.studentappfragment.data.entity.StudentEntity
import com.example.studentappfragment.databinding.ItemStudentBinding

class StudentAdapter(
    private val listenerDetails: (student: StudentEntity) -> Unit
) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    var listStudent: List<StudentEntity> = emptyList()
        set(value) {
            val diffUtil = StudentDiffUtilsCallback(field, value)
            val diffResult = DiffUtil.calculateDiff(diffUtil)
            field = value
            diffResult.dispatchUpdatesTo(this)
        }

    class StudentViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding: ItemStudentBinding = ItemStudentBinding.bind(view)

        fun bind(student: StudentEntity, listenerDetails: (student: StudentEntity) -> Unit) {
            binding.tvNameStudent.text = student.nameStudent
            Glide
                .with(binding.imViewAvatarStudent.context)
                .load(student.imageStudent)
                .circleCrop()
                .placeholder(R.drawable.ic_avatar_student)
                .error(R.drawable.ic_avatar_student)
                .into(binding.imViewAvatarStudent)
            itemView.setOnClickListener {
                listenerDetails(student)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val viewBinding = ItemStudentBinding.inflate(inflater, parent, false)
        return StudentViewHolder(viewBinding.root)
    }

    override fun onBindViewHolder(studentViewHolder: StudentViewHolder, position: Int) {
        studentViewHolder.bind(listStudent[position], listenerDetails)
    }

    override fun getItemCount(): Int {
        return listStudent.size
    }

}