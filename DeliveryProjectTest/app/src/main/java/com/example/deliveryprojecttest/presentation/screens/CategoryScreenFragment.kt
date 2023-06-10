package com.example.deliveryprojecttest.presentation.screens

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.example.deliveryprojecttest.R
import com.example.deliveryprojecttest.databinding.FragmentCategoryScreenBinding

class CategoryScreenFragment : Fragment(R.layout.fragment_category_screen) {

    private lateinit var binding: FragmentCategoryScreenBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCategoryScreenBinding.bind(view)
        initButton()
    }

    private fun initButton() {
        binding.btnOne.setOnClickListener {
            findNavController().navigate(R.id.action_categoryScreenFragment_to_productScreenFragment)
        }
        binding.btnTwo.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}