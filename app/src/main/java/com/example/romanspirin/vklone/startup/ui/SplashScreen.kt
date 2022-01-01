package com.example.romanspirin.vklone.startup.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.romanspirin.vklone.core.navigation.Routes

@Composable
fun SplashScreen(navController: NavHostController) {

    val vm: SplashScreenViewModel = hiltViewModel()

    LaunchedEffect(key1 = Unit) {
        if (vm.isLoggedIn()) navController.navigate(Routes.Feed.route)
        else navController.navigate(Routes.Auth.route)
    }

    Box(
        modifier = Modifier
            .background(Color.DarkGray)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "VKlone"
        )
    }
}