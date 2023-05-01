package com.iteneum.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.iteneum.example.ScreenContent

fun NavGraphBuilder.communityNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.COMMUNITY,
        startDestination = CommunityScreen.Amenities.route
    ) {
        composable(route = CommunityScreen.Amenities.route) {
            ScreenContent(
                name = CommunityScreen.Amenities.route,
                onClick = {
                    navController.popBackStack()
                    navController.navigate(Graph.HOME)
                }
            )
        }
        composable(route = CommunityScreen.Wall.route) {
            ScreenContent(
                name = CommunityScreen.Amenities.route,
                onClick = {
                    navController.popBackStack()
                    navController.navigate(Graph.HOME)
                }
            )
        }
    }
}

sealed class CommunityScreen(val route: String) {
    object Amenities : DashBoardScreen(route = "AMENITIES")
    object Wall : DashBoardScreen(route = "WALL")
}
