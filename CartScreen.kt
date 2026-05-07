package com.example.my_application

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun CartScreen(
    cart: CartState,
    onBack: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp, top = 40.dp, bottom = 16.dp) // ⬅ pushes content down
    ) {


        Text(
            text = "Shopping Cart",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            textAlign = TextAlign.Center
        )

        if (cart.items.isEmpty()) {

            Text(
                text = "Your cart is empty",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

        } else {

            LazyColumn(
                modifier = Modifier.weight(1f)
            ) {

                items(cart.items) { product ->

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 6.dp)
                    ) {

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {

                            // IMAGE + INFO
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {

                                Image(
                                    painter = painterResource(id = product.imageRes),
                                    contentDescription = product.name,
                                    modifier = Modifier
                                        .size(60.dp)
                                )

                                Spacer(modifier = Modifier.width(10.dp))

                                Column {

                                    Text(product.name)

                                    Text(
                                        text = "$${product.price}",
                                        style = MaterialTheme.typography.bodyMedium
                                    )
                                }
                            }

                            // 🗑️ REMOVE BUTTON
                            Button(
                                onClick = { cart.remove(product) }
                            ) {
                                Text("Remove")
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // TOTAL
            Text(
                text = "Total: $${cart.total()}",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // BACK BUTTON
        Button(
            onClick = onBack,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Back to Products")
        }
    }
}