package com.example.infinitelearningfrontend.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay

@Composable
fun ProfileScreen(
    navController: NavController, // Navigation controller for navigation
) {
    var user by remember { mutableStateOf<User?>(null) } // Placeholder user state
    var isLoading by remember { mutableStateOf(true) } // Loading state

    // Simulate data fetching (replace with actual data fetching logic)
    LaunchedEffect(Unit) {
        delay(2000) // Simulate a 2-second delay
        user = User(
            id = 1,
            name = "Dhia Irsyad",
            email = "dhiairsyaf32@email.com",
            bio = "Tugas Front End Infinite Learning"
        )
        isLoading = false
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (isLoading) {
            CircularProgressIndicator() // Display a loading indicator
        } else {
            if (user != null) {
                // Display user profile information

                Text(
                    text = user!!.name,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 16.dp)
                )

                Text(text = user!!.email, modifier = Modifier.padding(top = 8.dp))

                if (user!!.bio != null) {
                    Text(text = user!!.bio, modifier = Modifier.padding(top = 16.dp))
                }

            }
        }
    }
}

data class User(
    val id: Int,
    val name: String,
    val email: String,
    val bio: String
)