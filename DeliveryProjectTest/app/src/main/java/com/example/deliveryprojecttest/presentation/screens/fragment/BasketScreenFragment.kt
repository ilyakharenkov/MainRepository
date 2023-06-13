package com.example.deliveryprojecttest.presentation.screens.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.deliveryprojecttest.Di
import com.example.deliveryprojecttest.R
import com.example.deliveryprojecttest.databinding.FragmentBasketScreenBinding
import com.example.deliveryprojecttest.presentation.screens.mvvm.BasketViewModel
import com.example.deliveryprojecttest.presentation.screens.mvvm.BasketViewModelFactory

class BasketScreenFragment : Fragment(R.layout.fragment_basket_screen) {

    private val viewModel: BasketViewModel by viewModels{
        BasketViewModelFactory(getCategoriesUseCase = Di.getCategoriesUseCase)
    }
    private lateinit var binding: FragmentBasketScreenBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBasketScreenBinding.bind(view)
        initCategory()
    }

    private fun initCategory(){

    }

}