package com.example.testfragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.testfragment.databinding.ActivityMainBinding
import com.example.testfragment.fragments.OneFragment

class MainActivity : AppCompatActivity(), Navigator {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null) {
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

    override fun navigationToOne() {
        supportFragmentManager.fragments.find {
            it is ContainerFragment
        }?.run {
            this as ContainerFragment
        }?.run {
            childFragmentManager
                .beginTransaction()
                .replace(R.id.container_fragment_view, OneFragment.newInstance())
                .setReorderingAllowed(true).addToBackStack(null)
                .commit()
        }
    }

    override fun navigationToTwo() {

    }

    override fun navigationToThree() {

    }

    override fun navigationToBack() {

    }


}