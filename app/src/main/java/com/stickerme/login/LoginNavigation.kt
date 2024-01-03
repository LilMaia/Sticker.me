package com.stickerme.login

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.stickerme.home.HomeActivity
import com.stickerme.login.presentation.LoginContent
import com.stickerme.login.presentation.SplashContent

@Composable
fun LoginNavigation(navController: NavHostController, activity: Activity) {
    NavHost(navController, startDestination = "splash") {
        composable("splash") {
            SplashContent(navController)
        }
        composable("login") {
            LoginContent(activity, navController)
        }
        composable("home") {
            HomeActivity()
        }
    }
}