package com.example.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TestModel(
    val name: String,
    val price: Int,
    val weight: Int,
    val description: String,
    val image_url: String
) : Parcelable

