package com.example.deliveryprojecttest.presentation.screens.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.deliveryprojecttest.domain.model.Dishes
import com.example.deliveryprojecttest.domain.model.TestModel
import com.example.deliveryprojecttest.domain.usecase.GetDishesUseCase
import kotlinx.coroutines.launch

class CategoryViewModel(private val getDishesUseCase: GetDishesUseCase) : ViewModel() {

    private val _listDishes = MutableLiveData<List<Dishes>>()
    val listDishes: LiveData<List<Dishes>> = _listDishes

    private val _listTags = MutableLiveData<List<TestModel>>()
    val listTags: LiveData<List<TestModel>> = _listTags

    init {
        initListDishes()
        initListTags()
    }

    private fun initListDishes() {
        viewModelScope.launch {
            _listDishes.value = getDishesUseCase.execute().dishes
        }
    }

    private fun initListTags() {
        viewModelScope.launch {
            getDishesUseCase.execute().dishes.map {
                _listTags.value = it.tegs.map {s ->
                    TestModel(text = s)
                }
            }
        }
    }

}