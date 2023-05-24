package com.iteneum.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.iteneum.notification.presentation.NotificationListView
import com.iteneum.profile.presentation.ProfileView

fun NavGraphBuilder.dashboardNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.DASHBOARD,
        startDestination = DashBoardScreen.Profile.route
    ) {
        composable(route = DashBoardScreen.Profile.route) {
            ProfileView(backToDashBoard = { /*TODO - DashBoardNavGraph -  to pass the high order function that will enable navigation for the buttons */ })
        }
        composable(route = DashBoardScreen.Notification.route) {
            NotificationListView()
        }
    }
}

sealed class DashBoardScreen(val route: String) {
    object Profile : DashBoardScreen(route = "PROFILE")
    object Notification : DashBoardScreen(route = "NOTIFICATION")
}
