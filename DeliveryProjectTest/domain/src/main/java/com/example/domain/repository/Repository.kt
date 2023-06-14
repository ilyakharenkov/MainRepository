package com.example.domain.repository

import com.example.domain.model.ResponseCategories
import com.example.domain.model.ResponseDishes

interface Repository {

    suspend fun getCategory(): ResponseCategories

    suspend fun getDishes(): ResponseDishes

}