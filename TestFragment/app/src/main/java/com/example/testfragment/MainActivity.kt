package com.example.testfragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.testfragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if(savedInstanceState == null){
            addFragmentActivity(fragment = ContainerFragment.newInstance())
        }
    }

    private fun addFragmentActivity(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.container_activity, fragment)
            .setReorderingAllowed(true)
            .commit()
    }


}