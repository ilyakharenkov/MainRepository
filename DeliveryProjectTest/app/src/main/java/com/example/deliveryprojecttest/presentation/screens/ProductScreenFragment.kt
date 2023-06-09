package com.example.deliveryprojecttest.presentation.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.deliveryprojecttest.R
import com.example.deliveryprojecttest.databinding.FragmentProductScreenBinding

class ProductScreenFragment : Fragment(R.layout.fragment_product_screen) {

    private lateinit var binding: FragmentProductScreenBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProductScreenBinding.bind(view)
        initButton()
    }

    private fun initButton(){
        binding.btnOne.setOnClickListener {

        }
        binding.btnTwo.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}