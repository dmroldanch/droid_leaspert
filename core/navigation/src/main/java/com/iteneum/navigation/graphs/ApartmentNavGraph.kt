package com.iteneum.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.iteneum.repair.presentation.RepairView

/**
 * File that contains the function [NavGraphBuilder] for the Apartment section View.
 * It also has the [ApartmentScreen] sealed class that contains the string routes for navigation identification.
 *
 * @author Daniel Roldan
 * @ModifiedBy Jose Miguel Garcia Reyes
 */

fun NavGraphBuilder.apartmentNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.APARTMENT,
        startDestination = ApartmentScreen.Repair.route
    ) {
        composable(route = ApartmentScreen.Repair.route) {
            RepairView(
                navigateToApartment = { navController.navigate(ApartmentScreen.Apartment.route)  }
            )
        }
    }
}

sealed class ApartmentScreen(val route: String) {
    object Repair : ApartmentScreen(route = "Repair")
    object Apartment : ApartmentScreen(route = "Apartment")
}
