package com.iteneum.leasepert.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.iteneum.designsystem.theme.LeasePertTheme
import com.iteneum.navigation.BottomBar
import com.iteneum.navigation.graphs.HomeNavGraph

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BaseScreen( navController: NavHostController = rememberNavController()) {
    val dp8 = LeasePertTheme.sizes.smallerSize
    val dp32 = LeasePertTheme.sizes.mediumSize

    Scaffold(
        content = {
            Box(Modifier.padding(start = dp8, end = dp8, top = dp8, bottom = dp32)) {
                HomeNavGraph(navController = navController)
            }
        },
        bottomBar = {   BottomBarComponent(navController = navController) }
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
                    icon = { Icon(item.icon, contentDescription= stringResource(id = item.title)) },
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

