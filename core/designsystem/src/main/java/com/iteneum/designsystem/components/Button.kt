package com.iteneum.designsystem.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * Create [LpEditFloatingActionButton] compose for user's posts
 *
 * @param modifier to modify an specific property of the card
 * @param onClick high order function
 * @param color Container color
 * @param colors Content color
 *
 * @author Juan Ramon Islas Huesca
 */
@Composable
fun LpEditFloatingActionButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    color: Color = MaterialTheme.colorScheme.primary,
    colors: Color = contentColorFor(backgroundColor = MaterialTheme.colorScheme.secondary)
){
    FloatingActionButton(
        onClick = onClick,
        modifier = modifier
            .padding(15.dp)
            .height(50.dp)
            .width(50.dp),
        containerColor = color,
        contentColor = colors,
    ) {
        Icon(Icons.Outlined.Edit, "edit button", tint = MaterialTheme.colorScheme.onPrimary)
    }
}