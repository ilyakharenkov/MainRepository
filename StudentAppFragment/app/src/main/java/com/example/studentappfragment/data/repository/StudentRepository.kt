package com.example.studentappfragment.data.repository

import com.example.studentappfragment.data.entity.StudentEntity
import kotlinx.coroutines.flow.Flow

interface StudentRepository {

    fun listStudent(): Flow<List<StudentEntity>>

    suspend fun search(name: String): List<StudentEntity>

    suspend fun create(studentEntity: StudentEntity)

    suspend fun update(id: Int, image: String, name: String, age: Int)

    suspend fun getById(id: Int): StudentEntity

    suspend fun delete(id: Int)


}