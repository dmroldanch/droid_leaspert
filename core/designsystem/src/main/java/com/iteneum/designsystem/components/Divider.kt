package com.iteneum.designsystem.components

import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.iteneum.designsystem.theme.LeasePertTheme

/**
 * [LpDivider] is a button for show in the UI and this button can have icon depending of the use
 *
 * @param modifier Modifier is for specify style and params of the button, like for example the width of the component.
 *
 * @author Usiel Filiberto Garcia Jimenez
 */
@Composable
fun LpDivider(modifier: Modifier) {
    Divider(
        thickness = LeasePertTheme.sizes.stroke,
        color = MaterialTheme.colorScheme.onPrimary,
        modifier = modifier
    )
}
