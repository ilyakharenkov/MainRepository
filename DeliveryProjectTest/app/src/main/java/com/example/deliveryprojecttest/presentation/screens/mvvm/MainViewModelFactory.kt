package com.example.deliveryprojecttest.presentation.screens.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.deliveryprojecttest.domain.usecase.GetCategoriesUseCase

class MainViewModelFactory(private val getCategoriesUseCase: GetCategoriesUseCase) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(getCategoriesUseCase = getCategoriesUseCase) as T
    }

}