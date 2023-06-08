package com.example.deliveryprojecttest.presentation.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.deliveryprojecttest.R
import com.example.deliveryprojecttest.databinding.FragmentMainScreenBinding

class MainScreenFragment : Fragment(R.layout.fragment_main_screen) {

    private lateinit var binding: FragmentMainScreenBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainScreenBinding.bind(view)
        initButton()
    }

    private fun initButton(){
        binding.btnOne.setOnClickListener {

        }
        binding.btnTwo.setOnClickListener {

        }
    }

}