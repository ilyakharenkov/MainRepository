package com.example.deliveryprojecttest.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class InformationDishes(
    val id: Int,
    val name: String,
    val price: Int,
    val weight: Int,
    val description: String,
    val image_url: String
) : Parcelable

