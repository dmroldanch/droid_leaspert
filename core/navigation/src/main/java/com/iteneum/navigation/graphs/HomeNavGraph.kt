package com.iteneum.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.iteneum.apartment.presentation.ApartmentView
import com.iteneum.community.presentation.CommunitylistUI
import com.iteneum.dashboard.presentation.DashboardView
import com.iteneum.navigation.BottomBar
import com.iteneum.office.presentation.ui.OfficeUI

@Composable
fun HomeNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.HOME,
        startDestination = BottomBar.DASHBOARD.route
    ) {

        composable(route = BottomBar.DASHBOARD.route) {
                DashboardView(
                    navigateToNotification = {
                        navController.navigate(DashBoardScreen.Notification.route)
                    } ,
                    navigateToProfile = {
                        navController.navigate(DashBoardScreen.Profile.route)
                    }
                )
        }
        composable(route = BottomBar.APARTMENT.route) {
            ApartmentView(
                    navigateToRepair = {
                        navController.navigate(ApartmentScreen.Repair.route)
                    } ,
                )
        }
        composable(route = BottomBar.COMMUNITY.route) {
                CommunitylistUI()
        }

        composable(route = BottomBar.OFFICE.route) {
                OfficeUI()
        }
        dashboardNavGraph(navController = navController)
        apartmentNavGraph(navController = navController)
        communityNavGraph(navController = navController)
    }
}

