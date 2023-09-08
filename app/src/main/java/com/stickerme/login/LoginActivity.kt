package com.stickerme.login

import androidx.compose.ui.tooling.preview.Preview
import com.stickerme.ui.theme.StickerMeTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.stickerme.login.presentation.LoginContent

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StickerMeTheme {
                LoginContent()
            }
        }
    }
}