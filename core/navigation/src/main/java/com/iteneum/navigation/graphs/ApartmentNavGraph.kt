package com.iteneum.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.iteneum.repair.presentation.RepairView

fun NavGraphBuilder.apartmentNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.APARTMENT,
        startDestination = ApartmentScreen.Repair.route
    ) {
        composable(route = ApartmentScreen.Repair.route) {
            RepairView()
        }
    }
}

sealed class ApartmentScreen(val route: String) {
    object Repair : DashBoardScreen(route = "Repair")
}
