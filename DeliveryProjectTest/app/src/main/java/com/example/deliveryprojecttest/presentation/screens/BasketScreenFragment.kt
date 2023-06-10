package com.example.deliveryprojecttest.presentation.screens

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.deliveryprojecttest.R
import com.example.deliveryprojecttest.data.Di
import com.example.deliveryprojecttest.data.repository.model.Categories
import com.example.deliveryprojecttest.databinding.FragmentBasketScreenBinding
import com.example.deliveryprojecttest.presentation.screens.mvvm.BasketViewModel
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext

class BasketScreenFragment : Fragment(R.layout.fragment_basket_screen) {

    private val viewModel: BasketViewModel by viewModels()

    private lateinit var binding: FragmentBasketScreenBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBasketScreenBinding.bind(view)
        initCategory()
    }

    private fun initCategory(){
        viewModel.categories.observe(viewLifecycleOwner) {
            binding.textView.text = it.toString()
        }
    }

}