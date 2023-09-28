package com.stickerme.login.presentation

import android.app.Activity
import android.content.Intent
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.stickerme.ui.theme.StickerMeTheme
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun LoginContent(activity: Activity) {
    val viewModel: LoginContentViewModel = viewModel()

    val signInLauncher = rememberLauncherForActivityResult(
        contract = FirebaseAuthUIActivityResultContract()
    ) { result ->
        viewModel.onSignInResult(result)
    }

    val loginResult = viewModel.loginResult.value

    StickerMeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            GoogleLoginButton(viewModel, signInLauncher)

            // Exibir uma mensagem com base no resultado do login
            Text(
                text = if (loginResult!!) "Login Successful" else "Login Failed",
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Composable
fun GoogleLoginButton(viewModel: LoginContentViewModel, signInLauncher: ActivityResultLauncher<Intent>) {
    Button(
        onClick = { viewModel.launchSignInFlow(signInLauncher) },
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "Login with Google")
    }
}

@Preview(showBackground = true)
@Composable
fun GoogleLoginButtonPreview() {
    StickerMeTheme {
    }
}