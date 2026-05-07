package com.example.my_application

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import androidx.compose.material3.ExperimentalMaterial3Api

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductScreen(
    products: List<Product>,
    onAdd: (Product) -> Unit,
    onGoCart: () -> Unit,
    cartSize: Int
) {

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    var search by remember { mutableStateOf("") }

    val filteredProducts = products.filter {
        it.name.contains(search, ignoreCase = true)
    }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },

        topBar = {
            TopAppBar(
                title = { Text("Shop") },
                actions = {
                    Text(
                        text = "🛒 $cartSize",
                        modifier = Modifier.padding(16.dp)
                    )
                }
            )
        }

    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .padding(10.dp)
        ) {

            //SEARCH BAR
            OutlinedTextField(
                value = search,
                onValueChange = { search = it },
                label = { Text("Search products") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(10.dp))


            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.weight(1f),
                contentPadding = PaddingValues(6.dp)
            ) {

                items(filteredProducts) { product ->

                    Card(
                        modifier = Modifier
                            .padding(6.dp)
                            .fillMaxWidth()
                    ) {

                        Column(modifier = Modifier.padding(10.dp)) {

                            Image(
                                painter = painterResource(id = product.imageRes),
                                contentDescription = product.name,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(110.dp)
                            )

                            Spacer(modifier = Modifier.height(6.dp))

                            Text(product.name)

                            Text("$${product.price}")

                            Spacer(modifier = Modifier.height(8.dp))

                            Button(
                                onClick = {
                                    onAdd(product)

                                    scope.launch {
                                        snackbarHostState.showSnackbar(
                                            "✔ Added to cart"
                                        )
                                    }
                                },
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text("Add")
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))


            Button(
                onClick = onGoCart,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Go to Cart")
            }
        }
    }
}