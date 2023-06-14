package com.example.deliveryprojecttest.presentation.screens.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.usecase.BasketServiceUseCase
import com.example.domain.usecase.GetDishesUseCase

class ProductViewModelFactory(
    private val basketServiceUseCase: com.example.domain.usecase.BasketServiceUseCase,
    private val getDishesUseCase: com.example.domain.usecase.GetDishesUseCase
    ): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProductViewModel(basketServiceUseCase = basketServiceUseCase, getDishesUseCase = getDishesUseCase) as T
    }

}