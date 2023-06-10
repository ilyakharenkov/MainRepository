package com.example.deliveryprojecttest.presentation.screens.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.deliveryprojecttest.data.Di
import com.example.deliveryprojecttest.data.repository.model.Categories
import com.example.deliveryprojecttest.data.repository.model.ResponseCategories
import kotlinx.coroutines.launch

class BasketViewModel : ViewModel() {

    private val _categories = MutableLiveData<ResponseCategories>()
    val categories: LiveData<ResponseCategories> = _categories

    init {
        getCategories()
    }


    private fun getCategories() {
        viewModelScope.launch {
            _categories.value = Di.repository.getCategory()
        }
    }


}