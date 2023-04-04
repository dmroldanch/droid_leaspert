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
import com.iteneum.designsystem.theme.Drab
import com.iteneum.designsystem.theme.MintJulep

@ExperimentalMaterial3Api
@Composable
fun BadgeButton(modifier: Modifier = Modifier, onClick : () -> Unit = {}, badgeNumber: Int) {

    Box{

        FilledIconButton(
            onClick = onClick,
            colors = IconButtonDefaults.filledIconButtonColors(MintJulep)
        ) {
            Icon(Icons.Filled.Notifications, contentDescription = "Notifications button", tint = Drab)
        }

        if(badgeNumber > 0) {
            BadgedBox(
                modifier = modifier.padding(horizontal = 15.dp, vertical = 7.dp).align(Alignment.BottomEnd),
                badge = {
                    Badge(
                        modifier = Modifier
                            .padding(1.dp)
                            .align(Alignment.TopEnd)
                    ) {
                        Text(text = badgeNumber.toString())
                    }
                }
            ) {

            }
        }
    }
}