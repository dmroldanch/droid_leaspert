package com.iteneum.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.iteneum.apartment.presentation.ApartmentView
import com.iteneum.community.presentation.CommunityView
import com.iteneum.dashboard.presentation.DashboardView
import com.iteneum.navigation.BottomBar
import com.iteneum.office.presentation.ui.OfficeView

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
                },
                navigateToProfile = {
                    navController.navigate(DashBoardScreen.Profile.route)
                }
            )
        }
        composable(route = BottomBar.APARTMENT.route) {
            ApartmentView(
                navigateToRepair = {
                    navController.navigate(ApartmentScreen.Repair.route)
                },
            )
        }
        composable(route = BottomBar.COMMUNITY.route) {
            CommunityView(
                navigationToAmenities = {
                    navController.navigate(CommunityScreen.Amenities.route)
                },
                navigationToEvents = {
                    // TODO: add navigation when screen is ready
                },
                navigationToCommunityWall = {
                    navController.navigate(CommunityScreen.Wall.route)
                },
                navigationToDoItYourSelf = {
                    // TODO: add navigation when screen is ready
                },
                navigationToServices = {
                    // TODO: add navigation when screen is ready
                }
            )
        }

        composable(route = BottomBar.OFFICE.route) {
            OfficeView()
        }
        dashboardNavGraph(navController = navController)
        apartmentNavGraph(navController = navController)
        communityNavGraph(navController = navController)
    }
}

