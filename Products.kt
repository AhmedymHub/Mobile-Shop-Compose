package com.example.my_application

data class Product(
    val id: Int,
    val name: String,
    val price: Double,
    val imageRes: Int,
    val discount: Int = 0,
    var isFavorite: Boolean = false
)