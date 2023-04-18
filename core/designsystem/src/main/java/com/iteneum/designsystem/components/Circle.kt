package com.iteneum.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.iteneum.designsystem.theme.LeasePertTheme

/**
 * [LpCircleText] is circle element what show one number inside it, it seem like an notification element
 *
 * @param quantityToShow is the element what the element show inside it, this element have to be an Integer
 * @param modifier Modifier is for specify style and params of the button, like for example the diameter of the component.
 *
 * @author Usiel Filiberto Garcia Jimenez
 */
@Composable
fun LpCircleText(quantityToShow: Int = 0, modifier: Modifier){
    Box(
        modifier = modifier
            .size(size = LeasePertTheme.sizes.largeSize)
            .clip(shape = MaterialTheme.shapes.extraLarge)
            .background(color = MaterialTheme.colorScheme.secondaryContainer),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = quantityToShow.toString(),
            color = MaterialTheme.colorScheme.onTertiary,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}