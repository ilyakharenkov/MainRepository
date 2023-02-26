package com.github.testparser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.github.testparser.databinding.ActivityMainBinding
import com.github.testparser.fragments.TestFragmentParser

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        addFragment(fragment = TestFragmentParser.newInstance())
    }

    private fun addFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragmentContainer, fragment)
            .commit()
    }
}