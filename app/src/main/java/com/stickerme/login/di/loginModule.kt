package com.stickerme.login.di

import org.koin.androidx.compose.get
import org.koin.dsl.module
import com.stickerme.login.presentation.LoginContentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel

val loginModule = module {
    viewModel {
        LoginContentViewModel()
    }
}