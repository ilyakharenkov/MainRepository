package com.example.deliveryprojecttest.data.repository

import com.example.deliveryprojecttest.data.repository.model.ResponseCategories

interface Repository {

    suspend fun getCategory(): ResponseCategories

}