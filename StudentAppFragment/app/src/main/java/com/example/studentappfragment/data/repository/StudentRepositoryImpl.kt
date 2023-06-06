package com.example.studentappfragment.data.repository

import com.example.studentappfragment.data.dao.DaoStudent
import com.example.studentappfragment.data.entity.StudentEntity
import kotlinx.coroutines.flow.Flow

class StudentRepositoryImpl(private val dao: DaoStudent) : StudentRepository {

    override fun listStudent(): Flow<List<StudentEntity>> {
        return dao.getListStudent()
    }

    //Поиск студентов в списке
    override suspend fun search(name: String): List<StudentEntity> {
        return dao.search(name = name)
    }

    override suspend fun create(studentEntity: StudentEntity) {
        dao.create(studentEntity = studentEntity)
    }

    override suspend fun update(id: Int, image: String, name: String, age: Int) {
        dao.update(id = id, image = image, name = name, age = age)
    }

    override suspend fun getById(id: Int): StudentEntity {
        return dao.studentGetById(id = id)
    }

    override suspend fun delete(id: Int) {
        dao.delete(id = id)
    }

}

