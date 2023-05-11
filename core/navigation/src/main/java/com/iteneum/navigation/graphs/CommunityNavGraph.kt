package com.iteneum.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.iteneum.communitylist.presentation.CommunityListView
import com.iteneum.communitywall.presentation.CommunityWallView
import com.iteneum.designsystem.components.UIActions

fun NavGraphBuilder.communityNavGraph(
    uiAction: (UIActions) -> Unit,
    navController: NavHostController
) {
    navigation(
        route = Graph.COMMUNITY,
        startDestination = CommunityScreen.Amenities.route
    ) {
        composable(route = CommunityScreen.Amenities.route) {
            CommunityListView(
                uiAction = {
                    uiAction(it)
                }
            )
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
