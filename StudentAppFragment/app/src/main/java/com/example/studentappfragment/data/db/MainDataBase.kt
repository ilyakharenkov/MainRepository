package com.example.studentappfragment.data.db

import android.content.ContentValues
import android.content.Context
import androidx.room.Database
import androidx.room.OnConflictStrategy
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.studentappfragment.data.dao.DaoStudent
import com.example.studentappfragment.data.entity.StudentEntity
import com.github.javafaker.Faker
import kotlin.random.Random

@Database(entities = [StudentEntity::class], version = 1)
abstract class MainDataBase : RoomDatabase() {

    abstract fun dao(): DaoStudent

    companion object {

        @Volatile
        private var INSTANCE: MainDataBase? = null

        fun mainDataBase(context: Context): MainDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MainDataBase::class.java,
                    "student_db"
                ).addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        defaultList(db = db)
                    }
                })
                    .build()
                instance
            }
        }


        /**
          Generate started list
         * */
        private fun defaultList(db: SupportSQLiteDatabase) {

            var list: List<StudentEntity>
            val urlPhotoImage = mutableListOf(
                "https://images.unsplash.com/photo-1494790108377-be9c29b29330?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NHx8ZmFjZXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60",
                "https://images.unsplash.com/photo-1557296387-5358ad7997bb?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=914&q=80",
                "https://images.unsplash.com/photo-1554151228-14d9def656e4?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8M3x8ZmFjZXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60",
                "https://images.unsplash.com/photo-1601412436009-d964bd02edbc?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTJ8fGZhY2V8ZW58MHx8MHx8&auto=format&fit=crop&w=500&q=60",
                "https://images.unsplash.com/photo-1500648767791-00dcc994a43e?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTF8fGZhY2V8ZW58MHx8MHx8&auto=format&fit=crop&w=500&q=60",
                "https://images.unsplash.com/photo-1616766098946-e4fabb7d6da0?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTh8fGZhY2V8ZW58MHx8MHx8&auto=format&fit=crop&w=500&q=60",
                "https://images.unsplash.com/photo-1499996860823-5214fcc65f8f?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Nnx8ZmFjZXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60"
            )
            var faker: Faker

            fun generateList(): List<StudentEntity> {
                faker = Faker.instance()
                urlPhotoImage.shuffle()
                list = (0..6).map {
                    StudentEntity(
                        idStudent = null,
                        imageStudent = urlPhotoImage[it % urlPhotoImage.size],
                        nameStudent = faker.name().name(),
                        ageStudent = Random.nextInt(18, 30)
                    )
                }.toMutableList()
                return list
            }

            db.beginTransaction()
            try {
                for (student in generateList()) {
                    val contentValues = ContentValues()
                    contentValues.put("id_student", student.idStudent)
                    contentValues.put("image_student", student.imageStudent)
                    contentValues.put("name_student", student.nameStudent)
                    contentValues.put("age_student", student.ageStudent)
                    db.insert("student_entity", OnConflictStrategy.IGNORE, contentValues)
                }
                db.setTransactionSuccessful()
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                db.endTransaction()
            }
        }
    }
}