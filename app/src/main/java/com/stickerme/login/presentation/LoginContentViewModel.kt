package com.stickerme.login.presentation

import android.app.Activity
import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult

class LoginContentViewModel : ViewModel() {
    private val _loginResult = mutableStateOf<Boolean?>(null)
    val loginResult: State<Boolean?> = _loginResult

    fun launchSignInFlow(activity: ActivityResultLauncher<Intent>) {
        val providers = arrayListOf(
            AuthUI.IdpConfig.GoogleBuilder().build()
        )

        val signInIntent = AuthUI.getInstance()
            .createSignInIntentBuilder()
            .setAvailableProviders(providers)
            .build()

        // Inicie a atividade usando o activity (ActivityResultLauncher)
        activity.launch(signInIntent)
    }

    fun onSignInResult(result: FirebaseAuthUIAuthenticationResult) {
        val response = result.idpResponse
        _loginResult.value = result.resultCode == Activity.RESULT_OK
    }
}
