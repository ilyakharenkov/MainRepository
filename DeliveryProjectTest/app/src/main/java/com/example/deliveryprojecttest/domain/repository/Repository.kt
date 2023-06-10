package com.example.deliveryprojecttest.domain.repository

import com.example.deliveryprojecttest.domain.model.ResponseCategories

interface Repository {

    suspend fun getCategory(): ResponseCategories

}