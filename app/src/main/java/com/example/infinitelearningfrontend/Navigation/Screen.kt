package com.example.infinitelearningfrontend.Navigation

sealed class Screen (val route: String){
    data object Home : Screen("home")
    data object Gallery: Screen("gallery")
    data object Detail: Screen("detail_mentors")
    data object Profile: Screen("profile")
}