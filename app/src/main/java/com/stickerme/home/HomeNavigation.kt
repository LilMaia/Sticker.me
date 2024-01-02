package com.stickerme.home

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.stickerme.R

@Composable
fun HomeBottomNav(navController: NavHostController) {
    val navigationItems = listOf(
        HomeBottomNavItem.Home,
        HomeBottomNavItem.Pacotes,
        HomeBottomNavItem.Ultimos
    )

    BottomNavigation(
        backgroundColor = MaterialTheme.colorScheme.primaryContainer,
        contentColor = MaterialTheme.colorScheme.onPrimaryContainer
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        navigationItems.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = null) },
                selectedContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                unselectedContentColor = MaterialTheme.colorScheme.onPrimaryContainer.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {

                        navController.graph.startDestinationRoute?.let { screenRoute ->
                            popUpTo(screenRoute) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

sealed class HomeBottomNavItem(
    val route: String,
    val icon: Int
) {
    object Home: HomeBottomNavItem("Home", R.mipmap.ic_home)
    object Pacotes : HomeBottomNavItem("Pacotes", R.mipmap.ic_pacotes)
    object Ultimos: HomeBottomNavItem("Ultimos visualizados", R.mipmap.ic_ultimos)
}