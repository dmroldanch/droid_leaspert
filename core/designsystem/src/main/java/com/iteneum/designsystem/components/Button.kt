package com.iteneum.designsystem.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.ui.graphics.Color

@Composable
fun LpOutlinedButton(
    modifierButton: Modifier = Modifier,
    textButtonDescription: String,
    icon: ImageVector? = null,
    onClick: () -> Unit,
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifierButton
            .padding(10.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.secondary),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.onSurface,
            contentColor = MaterialTheme.colorScheme.secondary
        )
    ) {
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterStart) {
            Row {
                icon?.let {
                    Icon(
                        icon,
                        contentDescription = textButtonDescription,
                        modifier = Modifier.size(ButtonDefaults.IconSize)
                    )
                    Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                }
                Text(textButtonDescription)
            }
        }
    }
}
/**
 * [LpFilledTonalButton] is a button for show in the login UI, is a button for the logic login
 *
 * @param modifier Modifier is for specify style and params of the button, like for example the width of the component.
 * @param textButton TextButton is for set a text what the button show in to the UI
 * @param onClick High order function for assign functionality to the button.
 *
 * @author Usiel Filiberto Garcia Jimenez
 */
@Composable
fun LpFilledTonalButton(modifier: Modifier, textButton: String, onClick: () -> Unit) {
    FilledTonalButton(
        onClick = onClick,
        modifier.padding(10.dp),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary
        )
    ) {
        Text(textButton)
    }
}

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