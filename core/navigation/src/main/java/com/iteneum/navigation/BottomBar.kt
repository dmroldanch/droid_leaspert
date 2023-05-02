package com.iteneum.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Apartment
import androidx.compose.material.icons.outlined.Build
import androidx.compose.material.icons.outlined.Dashboard
import androidx.compose.material.icons.outlined.Group
import androidx.compose.ui.graphics.vector.ImageVector
import com.iteneum.navigation.graphs.RoutesButtonBar

sealed class BottomBar(
    val route: String,
    val title: Int,
    val icon: ImageVector
) {
    object DASHBOARD : BottomBar(
        route = RoutesButtonBar.DASHBOARD,
        title = R.string.LPButtonBarDashboard,
        icon = Icons.Outlined.Dashboard
    )

    object APARTMENT : BottomBar(
        route = RoutesButtonBar.APARTMENT,
        title = R.string.LPButtonBarApartment,
        icon = Icons.Outlined.Apartment
    )

    object COMMUNITY : BottomBar(
        route = RoutesButtonBar.COMMUNITY,
        title = R.string.LPButtonBarCommunity,
        icon = Icons.Outlined.Group
    )


    object OFFICE : BottomBar(
        route = RoutesButtonBar.OFFICE,
        title = R.string.LPButtonBarOffice,
        icon = Icons.Outlined.Build
    )
}
