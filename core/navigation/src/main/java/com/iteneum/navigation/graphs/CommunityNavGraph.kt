package com.iteneum.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.iteneum.communitylist.presentation.CommunityListView
import com.iteneum.communitywall.presentation.CommunityWallView

fun NavGraphBuilder.communityNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.COMMUNITY,
        startDestination = CommunityScreen.Amenities.route
    ) {
        composable(route = CommunityScreen.Amenities.route) {
            CommunityListView()
        }
        composable(route = CommunityScreen.Wall.route) {
            CommunityWallView()
        }
    }
}

sealed class CommunityScreen(val route: String) {
    object Amenities : DashBoardScreen(route = "AMENITIES")
    object Wall : DashBoardScreen(route = "WALL")
}
