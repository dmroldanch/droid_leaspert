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

/**
 * Create [BadgeButton] compose for user's notifications
 *
 * @param modifier to modify box properties that contains: Button & Badge
 * @param badgeNumber to modify the number of notifications shown
 * @param onClick high order function, to define button action
 *
 * @author Jose Miguel Garcia Reyes
 */

@ExperimentalMaterial3Api
@Composable
fun BadgeButton(
    modifier: Modifier = Modifier,
    badgeNumber: Int,
    onClick: () -> Unit = {}
) {
    Box(modifier = modifier) {
        FilledIconButton(
            onClick = onClick,
            colors = IconButtonDefaults.filledIconButtonColors(MaterialTheme.colorScheme.surface)
        ) {
            Icon(
                imageVector = Icons.Filled.Notifications,
                contentDescription = "Notifications button",
                tint = MaterialTheme.colorScheme.secondary
            )
        }
        if (badgeNumber > 0) {
            BadgedBox(
                modifier = Modifier
                    .padding(
                        horizontal = 15.dp,
                        vertical = 7.dp
                    )
                    .align(alignment = Alignment.BottomEnd),
                badge = {
                    Badge(
                        modifier = Modifier
                            .padding(all = 1.dp)
                            .align(alignment = Alignment.TopEnd)
                    ) {
                        Text(
                            text = badgeNumber.toString(),
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            ) {}
        }
    }
}
