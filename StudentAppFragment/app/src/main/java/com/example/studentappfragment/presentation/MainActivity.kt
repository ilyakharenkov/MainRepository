package com.example.studentappfragment.presentation

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.studentappfragment.R
import com.example.studentappfragment.databinding.ActivityMainBinding
import com.example.studentappfragment.presentation.fragments.StudentDetailsFragment
import com.example.studentappfragment.presentation.fragments.StudentEditFragment
import com.example.studentappfragment.presentation.fragments.StudentListFragment

private const val MODE_PORTRAIT = R.id.container_fragment
private const val MODE_LANDSCAPE = R.id.container_fragment_land

class MainActivity : AppCompatActivity(), Navigation {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        addFragment(savedInstanceState = savedInstanceState)
    }

    private fun addFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(MODE_PORTRAIT, StudentListFragment.newInstance())
                .commit()
        }
        else {
            supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }
    }

    private fun replaceFragmentPortrait(container: Int, fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .setReorderingAllowed(true)
            .addToBackStack("tag")
            .replace(container, fragment)
            .commit()
    }

    private fun checkOrientation(): Int {
        return when (resources.configuration.orientation) {
            Configuration.ORIENTATION_PORTRAIT -> MODE_PORTRAIT
            Configuration.ORIENTATION_LANDSCAPE -> MODE_LANDSCAPE
            else -> throw IllegalArgumentException("Error orientation")
        }
    }

    //Переход на StudentDetailsFragment
    override fun navigationToDetailsStudent(id: Int) {
        supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        replaceFragmentPortrait(
            container = checkOrientation(),
            fragment = StudentDetailsFragment.newInstance(id = id)
        )
    }

    //Переход с StudentDetailsFragment на StudentEditFragment
    override fun navigationToUpdateStudent(id: Int) {
        replaceFragmentPortrait(
            container = checkOrientation(),
            fragment = StudentEditFragment.startFragmentRefactor(id = id)
        )
    }

    //Переход с StudentListFragment на StudentEditFragment
    override fun navigationToCreateStudent() {
        replaceFragmentPortrait(
            container = checkOrientation(),
            fragment = StudentEditFragment.startFragmentCreate()
        )
    }

    override fun back() {
        onBackPressedDispatcher.onBackPressed()
    }
}