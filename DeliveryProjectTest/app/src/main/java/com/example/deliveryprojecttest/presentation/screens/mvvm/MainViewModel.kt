package com.example.deliveryprojecttest.presentation.screens.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.deliveryprojecttest.domain.model.Categories
import com.example.deliveryprojecttest.domain.usecase.GetCategoriesUseCase
import kotlinx.coroutines.launch

class MainViewModel(private val getCategoriesUseCase: GetCategoriesUseCase) : ViewModel() {

    private val _list = MutableLiveData<List<Categories>>()
    val list: LiveData<List<Categories>> = _list

    init {
        initList()
    }

    private fun initList() {
        viewModelScope.launch() {
            _list.value = getCategoriesUseCase.execute().сategories
        }
    }
}