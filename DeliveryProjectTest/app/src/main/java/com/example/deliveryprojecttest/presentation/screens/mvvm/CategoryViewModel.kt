package com.example.deliveryprojecttest.presentation.screens.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Dishes
import com.example.domain.model.TestModel
import com.example.domain.usecase.GetDishesUseCase
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus

class CategoryViewModel(private val getDishesUseCase: com.example.domain.usecase.GetDishesUseCase) : ViewModel() {

    private val _listDishes = MutableLiveData<List<com.example.domain.model.Dishes>>()
    val listDishes: LiveData<List<com.example.domain.model.Dishes>> = _listDishes

    private val _listTags = MutableLiveData<List<String>>()
    val listTags: LiveData<List<String>> = _listTags

    init {
        initListDishes()
    }

    private fun initListDishes() {
        viewModelScope.launch {

            _listDishes.value = getDishesUseCase.execute().dishes

            val result = mutableListOf<String>()
            _listDishes.value?.forEach { dishes ->
                dishes.tegs.forEach { tag ->
                    result += tag
                }
            }
            _listTags.value = result.toSet().toList()
        }
    }

}