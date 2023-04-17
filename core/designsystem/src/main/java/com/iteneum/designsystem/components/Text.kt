package com.iteneum.designsystem.components

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.iteneum.designsystem.theme.Boulder
import com.iteneum.designsystem.theme.LPTypography

/**
[LPTitleLarge] is a composable function that displays a large title text with the specified label, color, and optional text alignment. It can also be clickable and trigger an onClick event.
@param modifier Modifier is used to apply custom styles and parameters to the title, such as the width and height of the component.
@param label The text label to be displayed as the title.
@param color The color of the title text.
@param textAlign Optional text alignment parameter, default is TextAlign.Center.
@param onClick Optional high-order function that defines the click behavior when the title is clicked.
@author Irving Ulises Gonzalez Uscanga

[LPTitleMedium] is a composable function that displays a medium-sized title text with the specified label, color, and optional text alignment. It can also be clickable and trigger an onClick event.
@param modifier Modifier is used to apply custom styles and parameters to the title, such as the width and height of the component.
@param label The text label to be displayed as the title.
@param color The color of the title text.
@param textAlign Optional text alignment parameter, default is TextAlign.Center.
@param onClick Optional high-order function that defines the click behavior when the title is clicked.
@author Irving Ulises Gonzalez Uscanga

[LPTitleSmall] is a composable function that displays a small-sized title text with the specified label, color, and optional text alignment. It can also be clickable and trigger an onClick event.
@param modifier Modifier is used to apply custom styles and parameters to the title, such as the width and height of the component.
@param label The text label to be displayed as the title.
@param color The color of the title text.
@param textAlign Optional text alignment parameter, default is TextAlign.Center.
@param onClick Optional high-order function that defines the click behavior when the title is clicked.
@author Irving Ulises Gonzalez Uscanga

[LPBodyLarge] is a composable function that displays a large body text with the specified label, color, and optional onClick event. It can also be clickable and trigger an onClick event.
@param modifier Modifier is used to apply custom styles and parameters to the body text, such as the width and height of the component.
@param label The text label to be displayed as the body text.
@param color The color of the body text.
@param onClick Optional high-order function that defines the click behavior when the body text is clicked.
@author Irving Ulises Gonzalez Uscanga

[LPBodyMedium] is a composable function that displays a medium-sized body text with the specified label, color, and optional onClick event. It can also be clickable and trigger an onClick event.
@param modifier Modifier is used to apply custom styles and parameters to the body text, such as the width and height of the component.
@param label The text label to be displayed as the body text.
@param color The color of the body text.
@param onClick Optional high-order function that defines the click behavior when the body text is clicked.
@author Irving Ulises Gonzalez Uscanga

[LPBodySmall] is a composable component that displays a body text with a small style in the user interface.
@param modifier Modifier to specify the style and parameters of the component, such as the width of the component.
@param label Text to be displayed in the user interface.
@param color Text color.
@param onClick Higher-order function that allows assigning functionality to the component when it is clicked.
@author Irving Ulises Gonzalez Uscanga

[LPSubTitleLarge] is a composable component that displays a subtitle text with a large style in the user interface.
@param modifier Modifier to specify the style and parameters of the component, such as the width of the component.
@param label Text to be displayed in the user interface.
@param color Text color.
@param onClick Higher-order function that allows assigning functionality to the component when it is clicked.
@author Irving Ulises Gonzalez Uscanga

[LPSubTitleMedium] is a composable component that displays a subtitle text with a medium style in the user interface.
@param modifier Modifier to specify the style and parameters of the component, such as the width of the component.
@param label Text to be displayed in the user interface.
@param color Text color.
@param onClick Higher-order function that allows assigning functionality to the component when it is clicked.
@author Irving Ulises Gonzalez Uscanga

[LPSubTitleSmall] is a composable component that displays a subtitle text with a small style in the user interface.
@param modifier Modifier to specify the style and parameters of the component, such as the width of the component.
@param label Text to be displayed in the user interface.
@param color Text color.
@param onClick Higher-order function that allows assigning functionality to the component when it is clicked.
@author Irving Ulises Gonzalez Uscanga

*/

@Composable
fun LPTitleLarge(
    modifier: Modifier = Modifier,
    label: String,
    color: Color,
    textAlign: TextAlign? = TextAlign.Center
) {
    Text(
        text = label,
        color = color,
        style = LPTypography.titleLarge,
        modifier = modifier, textAlign = textAlign)
}

@Composable
fun LPTitleMedium(
    modifier: Modifier = Modifier,
    label: String,
    color: Color,
    textAlign: TextAlign? = TextAlign.Center
) {
    Text(
        text = label,
        color = color,
        style = LPTypography.titleMedium,
        modifier = modifier, textAlign = textAlign)
}

@Composable
fun LPTitleSmall(
    modifier: Modifier = Modifier,
    label: String,
    color: Color,
    textAlign: TextAlign? = TextAlign.Center
){
    Text(
        text = label,
        color = color,
        style = LPTypography.titleSmall,
        modifier = modifier, textAlign = textAlign)
}

@Composable
fun LPBodyLarge(
    modifier: Modifier = Modifier,
    label: String,
    color: Color,
    onClick: (() -> Unit)? = null
) {
    Text(
        text = label,
        color = color,
        style = LPTypography.bodyLarge,
        modifier = modifier.clickable { onClick?.invoke() })
}

@Composable
fun LPBodyMedium(
    modifier: Modifier = Modifier,
    label: String,
    color: Color,
    onClick: (() -> Unit)? = null
) {
    Text(
        text = label,
        color = color,
        style = LPTypography.bodyMedium,
        modifier = modifier.clickable { onClick?.invoke() })
}

@Composable
fun LPBodySmall(
    modifier: Modifier = Modifier,
    label: String,
    color: Color,
    onClick: (() -> Unit)? = null
) {
    Text(
        text = label,
        color = color,
        style = LPTypography.bodySmall,
        modifier = modifier.clickable { onClick?.invoke() })
}

@Composable
fun LPSubTitleLarge(
    modifier: Modifier = Modifier,
    label: String,
    color: Color,
    onClick: (() -> Unit)? = null
){
    Text(
        text = label,
        color = color,
        style = LPTypography.labelLarge,
        modifier = modifier.clickable { onClick?.invoke() })
}

@Composable
fun LPSubTitleMedium(
    modifier: Modifier = Modifier,
    label: String,
    color: Color,
    onClick: (() -> Unit)? = null
){
    Text(
        text = label,
        color = color,
        style = LPTypography.labelMedium,
        modifier = modifier.clickable { onClick?.invoke() })
}

@Composable
fun LPSubTitleSmall(
    modifier: Modifier = Modifier,
    label: String,
    color: Color,
    onClick: (() -> Unit)? = null
){
    Text(
        text = label,
        color = color,
        style = LPTypography.labelSmall,
        modifier = modifier.clickable { onClick?.invoke() })
}