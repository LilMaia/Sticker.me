package com.stickerme.login.presentation

import android.content.Intent
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.result.ActivityResult
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.gms.auth.api.signin.GoogleSignInAccount

class LoginContentViewModel : ViewModel() {
    private val _googleSignInResult = MutableLiveData<GoogleSignInAccount?>()
    val googleSignInResult: LiveData<GoogleSignInAccount?> = _googleSignInResult

    // Função para iniciar o processo de login com o Google
    fun launchGoogleSignIn(launcher: ManagedActivityResultLauncher<Intent, ActivityResult>) {
        // Aqui você deve criar a configuração do GoogleSignInOptions e iniciar a atividade de login
        // e fornecer o resultado ao launcher passado como parâmetro
        // Exemplo:
        // val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
        //     .requestEmail()
        //     .build()
        // val signInClient = GoogleSignIn.getClient(activity, gso)
        // val signInIntent = signInClient.signInIntent
        // launcher(ActivityResult(0, Activity.RESULT_OK, signInIntent))
    }

    // Função para processar o resultado do login com o Google
    fun handleSignInResult(result: ActivityResult) {
        if (result.resultCode == android.app.Activity.RESULT_OK) {
            // O login foi bem-sucedido, você pode obter a conta do usuário assim:
            // val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
            // val account = task.getResult(ApiException::class.java)
            // _googleSignInResult.value = account
        } else {
            // O login falhou, você pode tratar isso de acordo com as necessidades do seu aplicativo
            // Por exemplo, mostrar uma mensagem de erro para o usuário
            // _googleSignInResult.value = null
        }
    }

}