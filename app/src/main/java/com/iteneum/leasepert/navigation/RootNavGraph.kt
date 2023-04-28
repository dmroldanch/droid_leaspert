package com.iteneum.leasepert.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.iteneum.leasepert.ui.BaseScreen
import com.iteneum.navigation.graphs.Graph
import com.iteneum.navigation.graphs.authNavGraph


@Composable
fun RootNavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.HOME
    ) {
        authNavGraph(navController = navController)
        composable(route = Graph.HOME) {
            BaseScreen()
        }
    }
}

