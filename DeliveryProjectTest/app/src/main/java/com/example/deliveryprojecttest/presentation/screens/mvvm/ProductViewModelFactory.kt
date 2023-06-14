package com.example.deliveryprojecttest.presentation.screens.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.deliveryprojecttest.domain.usecase.BasketServiceUseCase
import com.example.deliveryprojecttest.domain.usecase.GetDishesUseCase

class ProductViewModelFactory(
    private val basketServiceUseCase: BasketServiceUseCase,
    private val getDishesUseCase: GetDishesUseCase
    ): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProductViewModel(basketServiceUseCase = basketServiceUseCase, getDishesUseCase = getDishesUseCase) as T
    }

}