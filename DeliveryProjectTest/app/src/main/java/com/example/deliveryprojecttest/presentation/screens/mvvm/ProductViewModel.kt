package com.example.deliveryprojecttest.presentation.screens.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.deliveryprojecttest.domain.model.Dishes
import com.example.deliveryprojecttest.domain.usecase.BasketServiceUseCase
import com.example.deliveryprojecttest.domain.usecase.GetDishesUseCase
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class ProductViewModel(
    private val basketServiceUseCase: BasketServiceUseCase,
    private val getDishesUseCase: GetDishesUseCase
) : ViewModel() {

    private val _resultId = MutableLiveData<Int>()
    val resultId: LiveData<Int> = _resultId

    private val _dishes = MutableLiveData<Dishes>()
    val dishes: LiveData<Dishes> = _dishes

    init {
        getById()
    }

    fun resultId(id: Int){
        _resultId.value = id
    }

    private fun getById(){
        viewModelScope.launch {
            val result = getDishesUseCase.execute().dishes.firstOrNull {
                it.id == _resultId.value
            } ?: return@launch
            _dishes.value = result
        }
    }

    fun addDishesInBasket(){
        _dishes.value?.let { basketServiceUseCase.add(dishes = it) }
    }

}
