package org.subrapid.project.ui.screens.nav

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import org.subrapid.project.model.users
import org.subrapid.project.ui.screens.detail.DetailScreem
import org.subrapid.project.ui.screens.home.HomeScreem

@Composable
fun Navigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            HomeScreem(
                onUserClick = { user ->
                    navController.navigate("detail/${user.id}")
                }
            )
        }
        composable(
            route = "detail/{userId}",
            arguments = listOf(navArgument("userId") { type = NavType.LongType })
        ) { backStackEntry ->
            val userId = backStackEntry.arguments?.getLong("userId")
            val user = users.firstOrNull { it.id == userId }
            if (user != null) {
                DetailScreem(
                    user = user,
                    onBack = {
                        navController.popBackStack()
                    }
                )
            } else {
                // Manejo de error: redirigir o mostrar mensaje
                navController.popBackStack("home", false)
            }
        }
    }
}
