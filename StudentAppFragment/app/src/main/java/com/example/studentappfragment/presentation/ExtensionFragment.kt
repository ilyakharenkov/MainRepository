package com.example.studentappfragment.presentation

import androidx.fragment.app.Fragment

fun Fragment.navigator(): Navigation {
    return requireActivity() as Navigation
}
