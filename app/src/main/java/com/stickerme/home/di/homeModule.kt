package com.stickerme.home.di

import com.stickerme.home.presentation.PackageListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {
    viewModel {
        PackageListViewModel()
    }
}