package com.example.deliveryprojecttest.presentation.screens.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.deliveryprojecttest.domain.usecase.GetCategoriesUseCase

class BasketViewModelFactory(private val getCategoriesUseCase: GetCategoriesUseCase) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return BasketViewModel(getCategoriesUseCase = getCategoriesUseCase) as T
    }

}