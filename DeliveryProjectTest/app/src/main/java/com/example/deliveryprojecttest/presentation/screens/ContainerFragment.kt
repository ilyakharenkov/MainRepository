package com.example.deliveryprojecttest.presentation.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.deliveryprojecttest.R
import com.example.deliveryprojecttest.databinding.FragmentContainerBinding

class ContainerFragment : Fragment(R.layout.fragment_container) {

    private lateinit var binding: FragmentContainerBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentContainerBinding.bind(view)
        initBottomNavigationView()
    }

    private fun initBottomNavigationView(){
        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.btnHome -> {

                }
                R.id.btnSearch -> {

                }
                R.id.btnBasket -> {

                }
                R.id.btnAccount -> {

                }
            }
            true
        }
    }

}