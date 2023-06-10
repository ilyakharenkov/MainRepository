package com.example.deliveryprojecttest.presentation.screens.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.deliveryprojecttest.Di
import com.example.deliveryprojecttest.domain.model.ResponseCategories
import com.example.deliveryprojecttest.domain.usecase.GetCategoriesUseCase
import kotlinx.coroutines.launch

class BasketViewModel(private val getCategoriesUseCase: GetCategoriesUseCase) : ViewModel() {

    private val _categories = MutableLiveData<ResponseCategories>()
    val categories: LiveData<ResponseCategories> = _categories

    init {
        getCategories()
    }


    private fun getCategories() {
        viewModelScope.launch {
//            _categories.value = Di.repository.getCategory()
            _categories.value = getCategoriesUseCase.execute()
        }
    }


}