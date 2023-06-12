package com.example.deliveryprojecttest.domain.repository

import com.example.deliveryprojecttest.domain.model.ResponseCategories
import com.example.deliveryprojecttest.domain.model.ResponseDishes

interface Repository {

    suspend fun getCategory(): ResponseCategories

    suspend fun getDishes(): ResponseDishes

}