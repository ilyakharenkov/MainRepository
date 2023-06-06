package com.example.studentappfragment.presentation.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.studentappfragment.data.repository.StudentRepository

class StudentDetailsViewModelFactory(private val studentRepository: StudentRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return StudentDetailsViewModel(studentRepository = studentRepository) as T
    }

}