package com.dima.thestarwars.screens

sealed class NavScreen(
    val route: String,
    val title: String = ""
) {
    object  Home : NavScreen("home", "Star Wars Characters")
    object  Details : NavScreen("details"){
        fun withId(id: Long): String = "$route/$id"
    }
}