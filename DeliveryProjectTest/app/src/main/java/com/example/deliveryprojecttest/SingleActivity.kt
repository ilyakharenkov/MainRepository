package com.example.deliveryprojecttest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.deliveryprojecttest.databinding.ActivitySingleBinding
import com.example.deliveryprojecttest.presentation.screens.ContainerFragment

class SingleActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySingleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySingleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        test()
    }

    private fun test(){
        supportFragmentManager.beginTransaction()
            .add(R.id.single_activity_view, ContainerFragment())
            .commit()
    }
}