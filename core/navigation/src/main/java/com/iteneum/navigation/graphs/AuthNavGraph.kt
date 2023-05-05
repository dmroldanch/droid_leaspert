package com.iteneum.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.iteneum.example.ScreenContent
import com.iteneum.login.presentation.LoginView


fun NavGraphBuilder.authNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.AUTHENTICATION,
        startDestination = AuthScreen.Login.route
    ) {
        composable(route = AuthScreen.Login.route) {
            LoginView(
                navigationToDashboard = {
                    navController.popBackStack()
                    navController.navigate(Graph.HOME)
                }
            )
        }
        composable(route = AuthScreen.SignUp.route) {
            ScreenContent(
                name = AuthScreen.SignUp.route,
                onClick = {
                    navController.navigate(Graph.AUTHENTICATION)
                }
            )
        }
        composable(route = AuthScreen.Forgot.route) {
            ScreenContent(
                name = AuthScreen.Forgot.route,
                onClick = {
                    navController.navigate(Graph.AUTHENTICATION)
                }
            )
        }
    }
}

sealed class AuthScreen(val route: String) {
    object Login : AuthScreen(route = "LOGIN")
    object SignUp : AuthScreen(route = "SIGN_UP")
    object Forgot : AuthScreen(route = "FORGOT")
}