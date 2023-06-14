package com.example.deliveryprojecttest.presentation.screens.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.deliveryprojecttest.domain.usecase.AddBasketServiceUseCase
import com.example.deliveryprojecttest.domain.usecase.DeleteBasketUseCase

class BasketViewModelFactory(
    private val addBasketServiceUseCase: AddBasketServiceUseCase,
    private val deleteBasketUseCase: DeleteBasketUseCase
) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return BasketViewModel(
            addBasketServiceUseCase = addBasketServiceUseCase,
            deleteBasketUseCase = deleteBasketUseCase
        ) as T
    }

}