package com.example.my_application

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.*
import com.example.my_application.ui.theme.My_ApplicationTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {

            My_ApplicationTheme {

                val cartState = remember { CartState() }

                var screen by remember { mutableStateOf("welcome") }
                

                val products = listOf(

                    Product(1, "Nike Shoes", 120.0, R.drawable.nike_shoes, 20),
                    Product(2, "Backpack", 80.0, R.drawable.backpack, 10),
                    Product(3, "T-Shirt", 40.0, R.drawable.shirt, 0),
                    Product(4, "Watch", 150.0, R.drawable.watch, 15)
                )

                when (screen) {

                    "welcome" -> WelcomeScreen {
                        screen = "products"
                    }

                    "products" -> ProductScreen(
                        products = products,
                        onAdd = { cartState.add(it) },
                        onGoCart = { screen = "cart" },
                        cartSize = cartState.items.size
                    )

                    "cart" -> CartScreen(
                        cart = cartState,
                        onBack = { screen = "products" }
                    )
                }
            }
        }
    }
}