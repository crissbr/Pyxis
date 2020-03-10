package com.example.pyxis

import androidx.annotation.DrawableRes

data class  Content(
    val title: String,
    val subtitle: String,
    @DrawableRes val img: Int
)