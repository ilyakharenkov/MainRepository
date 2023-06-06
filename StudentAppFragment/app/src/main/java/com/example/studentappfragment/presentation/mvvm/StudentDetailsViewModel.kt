package com.example.studentappfragment.presentation.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.studentappfragment.data.models.Information
import com.example.studentappfragment.data.repository.StudentRepository
import kotlinx.coroutines.launch

class StudentDetailsViewModel(private val studentRepository: StudentRepository) : ViewModel() {

    private val _idStudent = MutableLiveData<Int>()
    val idStudent: LiveData<Int> = _idStudent

    private val _informationModel = MutableLiveData<Information>()
    val informStudent: LiveData<Information> = _informationModel

    fun initIdStudent(id: Int) {
        _idStudent.value = id
    }

    fun initInformationStudent() {
        val id = idStudent.value ?: return
        viewModelScope.launch {
            val student = studentRepository.getById(id = id)
            _informationModel.value = Information(
                urlImage = student.imageStudent,
                name = student.nameStudent,
                age = student.ageStudent
            )
        }
    }

    fun delete() {
        val id = idStudent.value ?: return
        viewModelScope.launch {
            studentRepository.delete(id = id)
        }
    }
}