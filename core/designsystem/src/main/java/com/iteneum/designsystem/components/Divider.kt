package com.iteneum.designsystem.components

import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.iteneum.designsystem.theme.LeasePertTheme

@Composable
fun LpDivider(modifier: Modifier) {
    Divider(
        thickness = LeasePertTheme.sizes.stroke,
        color = MaterialTheme.colorScheme.onPrimary,
        modifier = modifier
    )
}
