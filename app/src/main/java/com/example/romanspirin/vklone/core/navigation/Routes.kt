package com.example.romanspirin.vklone.core.navigation

sealed class Routes(val route: String) {
    object Splash : Routes("splash")
    object Auth : Routes("auth")
    object Feed : Routes("feed")
}