package com.stickerme.login.presentation

import android.os.Handler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.stickerme.R
import com.stickerme.ui.theme.StickerMeTheme
import kotlinx.coroutines.delay

@Composable
fun SplashContent(navController: NavController) {
    StickerMeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.Yellow// Define a cor de fundo como laranja
        ) {
            // Coloque aqui o seu logotipo ou imagem de splash screen
            Image(
                painter = painterResource(id = R.drawable.splash_logo), // Substitua com o recurso de imagem adequado
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(Alignment.Center)
                    .scale(1.5f)
            )
            LaunchedEffect(true) {
                delay(2000) // Espera por 2 segundos
                navController.navigate("login")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SplashPreview() {
    SplashContent(navController = rememberNavController())
}