package com.stickerme.home.presentation

import android.app.Activity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.stickerme.ui.theme.StickerMeTheme


@Composable
fun PackageContent(activity: Activity, navController: NavController) {
    val viewModel: PackageListViewModel = viewModel()

    StickerMeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.Yellow
        ) {

        }
    }
}

@Preview(showBackground = true)
@Composable
fun PackagesListPreview() {
}