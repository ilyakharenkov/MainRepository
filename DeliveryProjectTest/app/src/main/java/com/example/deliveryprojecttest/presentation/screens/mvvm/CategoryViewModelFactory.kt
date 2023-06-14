package com.example.deliveryprojecttest.presentation.screens.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.usecase.GetDishesUseCase

class CategoryViewModelFactory(private val getDishesUseCase: com.example.domain.usecase.GetDishesUseCase) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CategoryViewModel(getDishesUseCase = getDishesUseCase) as T
    }

}