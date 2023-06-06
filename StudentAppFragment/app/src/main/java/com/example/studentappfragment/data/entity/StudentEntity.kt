package com.example.studentappfragment.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = StudentEntity.TABLE_NAME)
data class StudentEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_ID)
    val idStudent: Int?,

    @ColumnInfo(name = COLUMN_IMAGE)
    val imageStudent: String,

    @ColumnInfo(name = COLUMN_NAME)
    val nameStudent: String,

    @ColumnInfo(name = COLUMN_AGE)
    val ageStudent: Int
) {
    companion object {
        const val TABLE_NAME = "student_entity"
        const val COLUMN_ID = "id_student"
        const val COLUMN_IMAGE = "image_student"
        const val COLUMN_NAME = "name_student"
        const val COLUMN_AGE = "age_student"
    }
}
