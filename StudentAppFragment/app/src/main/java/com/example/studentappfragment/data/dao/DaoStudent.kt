package com.example.studentappfragment.data.dao

import androidx.room.*
import com.example.studentappfragment.data.entity.StudentEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DaoStudent {

    @Query("SELECT * FROM ${StudentEntity.TABLE_NAME}")
    fun getListStudent(): Flow<List<StudentEntity>>

    @Insert
    suspend fun create(studentEntity: StudentEntity)

    @Query("SELECT * FROM ${StudentEntity.TABLE_NAME} WHERE ${StudentEntity.COLUMN_ID} IS :id")
    suspend fun studentGetById(id: Int): StudentEntity

    @Query("UPDATE ${StudentEntity.TABLE_NAME} SET ${StudentEntity.COLUMN_IMAGE} = :image, ${StudentEntity.COLUMN_NAME} = :name, ${StudentEntity.COLUMN_AGE} = :age WHERE ${StudentEntity.COLUMN_ID} = :id")
    suspend fun update(id: Int, image: String, name: String, age: Int)

    @Query("DELETE FROM ${StudentEntity.TABLE_NAME} WHERE ${StudentEntity.COLUMN_ID} IS :id")
    suspend fun delete(id: Int)

    @Query("SELECT * FROM ${StudentEntity.TABLE_NAME} WHERE ${StudentEntity.COLUMN_NAME} LIKE '%' || :name || '%'")
    suspend fun search(name: String): List<StudentEntity>

}