package com.example.deliveryprojecttest.presentation.screens

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.navOptions
import androidx.navigation.ui.NavigationUI
import com.example.deliveryprojecttest.R
import com.example.deliveryprojecttest.databinding.FragmentContainerBinding

class ContainerFragment : Fragment(R.layout.fragment_container) {

    private lateinit var binding: FragmentContainerBinding
    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentContainerBinding.bind(view)
        navController =
            (childFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHostFragment).navController
        initBottomNavigationView()
    }

    private fun initBottomNavigationView() {
        NavigationUI.setupWithNavController(binding.bottomNavigationView, navController)
    }
}