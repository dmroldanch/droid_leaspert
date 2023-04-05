package com.iteneum.designsystem.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@ExperimentalMaterial3Api
@Composable
fun BadgeButton(modifier: Modifier = Modifier, badgeNumber: Int, onClick : () -> Unit = {}) {

    Box(modifier = modifier){

        FilledIconButton(
            onClick = onClick,
            colors = IconButtonDefaults.filledIconButtonColors(MaterialTheme.colorScheme.surface)
        ) {
            Icon(Icons.Filled.Notifications, contentDescription = "Notifications button", tint = MaterialTheme.colorScheme.secondary)
        }

        if(badgeNumber > 0) {
            BadgedBox(
                modifier = Modifier.padding(15.dp, 7.dp).align(Alignment.BottomEnd),
                badge = {
                    Badge(
                        modifier = Modifier
                            .padding(1.dp)
                            .align(Alignment.TopEnd)
                    ) {
                        Text(text = badgeNumber.toString(), color = MaterialTheme.colorScheme.primary)
                    }
                }
            ) {}
        }
    }
}