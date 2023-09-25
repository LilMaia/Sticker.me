package com.stickerme.login.presentation

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.stickerme.ui.theme.StickerMeTheme

@Composable
fun LoginContent(viewModel: LoginContentViewModel = LoginContentViewModel()) {
    StickerMeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            GoogleLoginButton(viewModel)
        }
    }
}

@Composable
fun GoogleLoginButton(viewModel: LoginContentViewModel) {
    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        // Handle the result of Google Sign-In here using the ViewModel
        viewModel.handleSignInResult(result)
    }

    Button(
        onClick = {
            // Launch Google Sign-In using the ViewModel
            viewModel.launchGoogleSignIn(launcher)
        },
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Login with Google")
    }
}

@Preview(showBackground = true)
@Composable
fun GoogleLoginButtonPreview() {
    StickerMeTheme {
        GoogleLoginButton(LoginContentViewModel())
    }
}