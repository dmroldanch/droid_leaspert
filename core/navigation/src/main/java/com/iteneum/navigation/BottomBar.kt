package com.iteneum.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Apartment
import androidx.compose.material.icons.outlined.Build
import androidx.compose.material.icons.outlined.Dashboard
import androidx.compose.material.icons.outlined.Group
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBar(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object DASHBOARD : BottomBar(
        route = "DASHBOARD",
        title = "DASHBOARD",
        icon = Icons.Outlined.Dashboard
    )

    object APARTMENT : BottomBar(
        route = "APARTMENT",
        title = "APARTMENT",
        icon = Icons.Outlined.Apartment
    )

    object COMMUNITY : BottomBar(
        route = "COMMUNITY",
        title = "COMMUNITY",
        icon = Icons.Outlined.Group
    )


    object OFFICE : BottomBar(
        route = "OFFICE",
        title = "OFFICE",
        icon = Icons.Outlined.Build
    )
}
