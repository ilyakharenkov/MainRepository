package com.example.studentappfragment.presentation.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.studentappfragment.data.repository.StudentRepository
import com.example.studentappfragment.data.repository.StorageImpl

class StudentListViewModelFactory(
    private val studentRepository: StudentRepository,
    private val storageImpl: StorageImpl
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return StudentListViewModel(
            studentRepository = studentRepository,
            storageImpl = storageImpl
        ) as T
    }
}