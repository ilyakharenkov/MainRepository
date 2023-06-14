package com.example.deliveryprojecttest.presentation.screens.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.usecase.BasketServiceUseCase

class BasketViewModelFactory(
    private val basketServiceUseCase: com.example.domain.usecase.BasketServiceUseCase
) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return BasketViewModel(
            basketServiceUseCase = basketServiceUseCase
        ) as T
    }

}