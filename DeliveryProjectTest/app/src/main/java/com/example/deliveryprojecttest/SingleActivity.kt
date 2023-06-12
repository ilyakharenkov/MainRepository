package com.example.deliveryprojecttest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.navOptions
import com.example.deliveryprojecttest.databinding.ActivitySingleBinding

class SingleActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySingleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySingleBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}

