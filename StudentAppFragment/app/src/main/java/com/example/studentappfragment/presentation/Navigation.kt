package com.example.studentappfragment.presentation

interface Navigation {

    fun navigationToDetailsStudent(id: Int)

    fun navigationToUpdateStudent(id: Int)

    fun navigationToCreateStudent()

    fun back()

}