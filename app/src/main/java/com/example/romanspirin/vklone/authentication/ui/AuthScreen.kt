package com.example.romanspirin.vklone.authentication.ui

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.romanspirin.vklone.core.navigation.Routes
import kotlinx.coroutines.launch

@Composable
fun AuthScreen(
    navController: NavHostController
) {
    val vm: AuthScreenViewModel = hiltViewModel()
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current

    val wv = remember {
        WebView(context).apply {
            webViewClient = WebViewClient()
        }
    }

    Column {
        Row(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.9f)
        ) {
            AndroidView(
                modifier = Modifier.fillMaxSize(),
                factory = {
                    wv
                }
            ) {
                it.loadUrl(vm.authUrl)
            }
        }

        Row(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    coroutineScope.launch { vm.updateAccessToken(wv.url!!) }
                        .invokeOnCompletion { navController.navigate(Routes.Splash.route) }
                }
            ) {
                Text("I am ready")
            }
        }
    }

}