package com.dara.movemate.data

import androidx.annotation.DrawableRes

data class Vehicle(
    val freight: String,
    val category: String,
    @DrawableRes val icon: Int
)
