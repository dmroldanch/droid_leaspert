package com.iteneum.leasepert.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.iteneum.designsystem.components.snackbar.SnackBarDemoAppState
import com.iteneum.designsystem.components.snackbar.rememberSnackBarDemoAppState
import com.iteneum.designsystem.theme.LeasePertTheme
import com.iteneum.leasepert.R
import com.iteneum.designsystem.components.UIActions
import com.iteneum.navigation.BottomBar
import com.iteneum.navigation.graphs.HomeNavGraph

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BaseScreen(
    navController: NavHostController = rememberNavController()
) {
    val dp8 = LeasePertTheme.sizes.smallerSize
    val dp32 = LeasePertTheme.sizes.mediumSize

    val mySnackBar: SnackBarDemoAppState = rememberSnackBarDemoAppState()
    Scaffold(
        content = {
            Box(Modifier.padding(start = dp8, end = dp8, top = 40.dp, bottom = dp32)) {
                HomeNavGraph(
                    uiAction = { action ->
                        when (action) {
                            is UIActions.ShowSnackBar -> {
                                mySnackBar.showSnackBar(
                                    message = action.description,
                                    duration = action.duration
                                )
                            }
                            is UIActions.ShowAlertDialog -> {

                            }
                            else -> {

                            }
                        }
                    },
                    navController = navController
                )
            }
        },
        snackbarHost = {
            SnackbarHost(mySnackBar.snackBarState)
        },
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.app_name)) },
                navigationIcon = {

                    IconButton(onClick = { /* Handle back button press */ }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = null)
                    }
                }
            )
        },
        bottomBar = { BottomBarComponent(navController = navController) }
    )
}


@Composable
fun BottomBarComponent(navController: NavHostController) {
    val screens = listOf(
        BottomBar.DASHBOARD,
        BottomBar.APARTMENT,
        BottomBar.COMMUNITY,
        BottomBar.OFFICE,
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val bottomBarDestination = screens.any { it.route == currentDestination?.route }

    if (bottomBarDestination) {
        NavigationBar(containerColor = MaterialTheme.colorScheme.primary) {
            screens.forEachIndexed { index, item ->
                NavigationBarItem(
                    icon = {
                        Icon(
                            item.icon,
                            contentDescription = stringResource(id = item.title)
                        )
                    },
                    label = { Text(stringResource(id = item.title)) },
                    selected = currentDestination?.hierarchy?.any {
                        it.route == screens[index].route
                    } == true,
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = MaterialTheme.colorScheme.secondary
                    ),
                    onClick = {
                        navController.popBackStack()
                        navController.navigate(item.route)
                    }
                )
            }
        }
    }
}

