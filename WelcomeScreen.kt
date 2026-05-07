package com.example.my_application

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WelcomeScreen(onStart: () -> Unit) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF1E1E1E),
                        Color(0xFF3A3A3A)
                    )
                )
            ),
        contentAlignment = Alignment.Center
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(24.dp)
        ) {


            Text(
                text = "🛍️",
                fontSize = 80.sp
            )

            Spacer(modifier = Modifier.height(20.dp))


            Text(
                text = "Mobile Shop",
                fontSize = 38.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(12.dp))


            Text(
                text = "Discover Your Perfect Style",
                fontSize = 18.sp,
                color = Color.LightGray
            )

            Spacer(modifier = Modifier.height(40.dp))

            // START BUTTON
            Button(
                onClick = onStart,
                shape = RoundedCornerShape(14.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF6200EE)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
            ) {

                Text(
                    text = "Start Shopping",
                    fontSize = 18.sp,
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.height(20.dp))


            Text(
                text = "Modern Shopping Experience",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray
            )
        }
    }
}