package com.example.my_application

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList

class CartState {

    private val _items: SnapshotStateList<Product> = mutableStateListOf()

    val items: List<Product> get() = _items

    fun add(product: Product) {
        _items.add(product)
    }

    fun remove(product: Product) {
        _items.remove(product)
    }

    fun total(): Double {
        return _items.sumOf { it.price }
    }
}