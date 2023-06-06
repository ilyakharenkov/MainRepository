package com.example.studentappfragment.presentation.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.studentappfragment.data.entity.StudentEntity
import com.example.studentappfragment.data.repository.StudentRepository
import com.example.studentappfragment.data.repository.StorageImpl
import kotlinx.coroutines.launch

class StudentListViewModel(
    private val studentRepository: StudentRepository, private val storageImpl: StorageImpl
) : ViewModel() {

    val allStudent: LiveData<List<StudentEntity>> = studentRepository.listStudent().asLiveData()

    private val _list: MutableLiveData<List<StudentEntity>> = MutableLiveData<List<StudentEntity>>()
    val list: LiveData<List<StudentEntity>> = _list

    private val _readSearch = MutableLiveData<String>()
    val readSearch: LiveData<String> = _readSearch

    fun searchVM(text: String) {
        viewModelScope.launch {
            if (text.isNotEmpty()) {
                _list.value = studentRepository.search(name = text)
            } else {
                _list.value = allStudent.value ?: return@launch
            }
        }
    }

    fun saveStorage(name: String) {
        viewModelScope.launch {
            storageImpl.save(name = name)
        }
    }

    fun readStorage() {
        viewModelScope.launch {
            _readSearch.value = storageImpl.read()
        }
    }
}