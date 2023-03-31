package com.iteneum.designsystem.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LpFilledTonalButton(modifier: Modifier, textButtonDescription: String, onClick: () -> Unit) {
    FilledTonalButton(
        onClick = onClick,
        modifier
            .padding(10.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.secondary
        )
    ) {
        Text(textButtonDescription)
    }
}