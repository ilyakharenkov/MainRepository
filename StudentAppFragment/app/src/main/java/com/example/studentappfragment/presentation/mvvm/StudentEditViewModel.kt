package com.example.studentappfragment.presentation.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.studentappfragment.data.entity.StudentEntity
import com.example.studentappfragment.data.models.Information
import com.example.studentappfragment.data.repository.StudentRepository
import kotlinx.coroutines.launch

class StudentEditViewModel(private val studentRepository: StudentRepository) : ViewModel() {

    private val _information = MutableLiveData<Information>()
    val information: LiveData<Information> = _information

    private val _idStudent = MutableLiveData<Int>()

    fun initInformationStudent(id: Int) {
        _idStudent.value = id
        viewModelScope.launch {
            val student = studentRepository.getById(id = id)
            _information.value = Information(
                urlImage = student.imageStudent,
                name = student.nameStudent,
                age = student.ageStudent
            )
        }
    }

    fun createStudent(information: Information) {
        val studentEntity = StudentEntity(
            idStudent = null,
            imageStudent = information.urlImage,
            nameStudent = information.name,
            ageStudent = information.age
        )
        viewModelScope.launch {
            studentRepository.create(studentEntity = studentEntity)
        }
    }

    fun updateStudent(information: Information) {
        val id = _idStudent.value ?: return
        viewModelScope.launch {
            studentRepository.update(
                id = id,
                image = information.urlImage,
                name = information.name,
                age = information.age
            )
        }
    }
}