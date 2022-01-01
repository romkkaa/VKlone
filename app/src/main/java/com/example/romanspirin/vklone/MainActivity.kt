package com.example.romanspirin.vklone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.romanspirin.vklone.authentication.ui.AuthScreen
import com.example.romanspirin.vklone.core.navigation.Routes
import com.example.romanspirin.vklone.core.ui.theme.VKloneTheme
import com.example.romanspirin.vklone.feed.ui.FeedScreen
import com.example.romanspirin.vklone.startup.ui.SplashScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VKloneTheme {
                ScreenMain()
            }
        }
    }
}

@Composable
fun ScreenMain() {
    
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.Splash.route) {

        composable(Routes.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(Routes.Auth.route) {
            AuthScreen(navController = navController)
        }
        composable(Routes.Feed.route) {
            FeedScreen(navController = navController)
        }

    }

}
