package com.stickerme.home

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navArgument
import com.stickerme.R
import org.koin.androidx.compose.getViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun HomeBottomNav(navController: NavHostController, homeActivity: HomeActivity) {
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

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination  = BottomNavItem.Home.route) {
        composable(route = BottomNavItem.Home.route) {
            MoviesHomeContent(
                navigateToMovieDetails = {
                    navController.navigate(AppRoutes.MovieDetails.name + "/$it")
                }
            )
        }
        composable(route = BottomNavItem.MoviesGenre.route) {
            MoviesGenresContent()
        }
        composable(
            route = AppRoutes.MovieDetails.name + "/{movieId}",
            arguments = listOf(navArgument("movieId") {
                type = NavType.StringType
                nullable = false
            })
        ) {
            getViewModel<MovieDetailsViewModel>(parameters = {
                parametersOf(it.arguments?.getString("movieId")!!)
            })
            MovieDetailsContent(it.arguments?.getString("movieId")!!)
        }
    }
}

enum class AppRoutes {
    MovieDetails
}

sealed class HomeBottomNavItem(
    val route: String,
    val icon: Int
) {
    object Home: HomeBottomNavItem("Home", R.mipmap.ic_home)
    object Pacotes : HomeBottomNavItem("Pacotes", R.mipmap.ic_pacotes)
    object Ultimos: HomeBottomNavItem("Ultimos visualizados", R.mipmap.ic_ultimos)
}