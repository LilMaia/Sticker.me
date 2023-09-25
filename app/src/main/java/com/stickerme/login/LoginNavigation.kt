package com.stickerme.login

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.stickerme.login.presentation.LoginContent
import com.stickerme.login.presentation.SplashContent

@Composable
fun LoginNavigation(navController: NavHostController) {
    NavHost(navController, startDestination = "splash") {
        composable("splash") {
            SplashContent(navController)
        }
        composable("login") {
            LoginContent()
        }
    }
}