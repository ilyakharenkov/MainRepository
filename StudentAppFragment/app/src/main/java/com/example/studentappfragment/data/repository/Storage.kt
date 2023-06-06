package com.example.studentappfragment.data.repository

interface Storage {

    suspend fun save(name: String)

    suspend fun read(): String?

}