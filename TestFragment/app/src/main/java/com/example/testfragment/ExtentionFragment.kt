package com.example.testfragment

import androidx.fragment.app.Fragment

fun Fragment.navigation() : Navigator {
    return requireActivity() as Navigator
}