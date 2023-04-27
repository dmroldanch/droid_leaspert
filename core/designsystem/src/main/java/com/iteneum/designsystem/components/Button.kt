package com.iteneum.designsystem.components

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.FloatingActionButtonElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.iteneum.designsystem.R
import com.iteneum.designsystem.theme.LeasePertTheme
import com.iteneum.designsystem.utils.getFileName

/**
 * [LpOutlinedButton] is a button for show in the UI and this button can have icon depending of the use
 *
 * @param modifier Modifier is for specify style and params of the button, like for example the width of the component.
 * @param textButton TextButton is for set a text what the button show in to the UI
 * @param icon is for when uses this component can assign some icon depend of their function, but can not contain some icon.
 * @param onClicked High order function for assign functionality to the button.
 *
 * @author Usiel Filiberto Garcia Jimenez
 */
@Composable
fun LpOutlinedButton(
    modifier: Modifier,
    textButton: String,
    icon: ImageVector? = null,
    onClicked: () -> Unit
) {
    OutlinedButton(
        onClick = onClicked,
        modifier = modifier,
        shape = RoundedCornerShape(size = LeasePertTheme.sizes.midSmallSize),
        border = BorderStroke(
            width = LeasePertTheme.sizes.stroke,
            color = MaterialTheme.colorScheme.onPrimary
        ),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimary
        )
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            icon?.let {
                Icon(
                    modifier = Modifier.padding(end = LeasePertTheme.sizes.smallerSize),
                    imageVector = icon,
                    contentDescription = textButton
                )
            }
            Text(
                text = textButton,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

/**
 * [LpFilledTonalButton] is a button for show in the login UI, is a button for the logic login
 *
 * @param modifier Modifier is for specify style and params of the button, like for example the width of the component.
 * @param textButton TextButton is for set a text what the button show in to the UI
 * @param onClicked High order function for assign functionality to the button.
 *
 * @author Usiel Filiberto Garcia Jimenez
 */
@Composable
fun LpFilledTonalButton(
    modifier: Modifier,
    textButton: String,
    onClicked: () -> Unit
) {
    FilledTonalButton(
        onClick = onClicked,
        modifier = modifier,
        shape = RoundedCornerShape(LeasePertTheme.sizes.midSmallSize),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary
        )
    ) {
        Text(text = textButton, style = MaterialTheme.typography.titleSmall)
    }
}

/**
 * Create [LpFloatingActionIconButton] compose for user's posts
 *
 * @param modifier to modify an specific property of the card
 * @param onClicked high order function
 * @param elevation FloatingActionButtonDefaults.elevation(dp's of the component elevation)
 * @param containerColor Container color
 * @param iconColor Content color
 *
 * @author Juan Ramon Islas Huesca
 */
@Composable
fun LpFloatingActionIconButton(
    modifier: Modifier = Modifier,
    containerColor: Color = MaterialTheme.colorScheme.primary,
    iconColor: Color = MaterialTheme.colorScheme.onPrimary,
    elevation: FloatingActionButtonElevation = FloatingActionButtonDefaults.elevation(),
    icon: ImageVector,
    contentDescription: String,
    onClicked: () -> Unit
) {
    FloatingActionButton(
        onClick = onClicked,
        modifier = modifier
            .padding(LeasePertTheme.sizes.smallSize)
            .height(LeasePertTheme.sizes.extraSize48)
            .width(LeasePertTheme.sizes.extraSize48),
        containerColor = containerColor,
        elevation = elevation
    ) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            tint = iconColor
        )
    }
}

/**
 * Function that creates [LpBadgeButton] compose for user's notifications
 *
 * @param modifier to modify box properties that contains: Button & Badge
 * @param badgeNumber to modify the string number of notifications shown
 * @param showBadge to enable the number of notifications to be displayed
 * @param imageVector to modify the icon to be displayed
 * @param onClicked high order function, to define button action
 *
 * @author Jose Miguel Garcia Reyes
 */

@ExperimentalMaterial3Api
@Composable
fun LpBadgeButton(
    modifier: Modifier = Modifier,
    badgeNumber: String = "0",
    showBadge: Boolean = false,
    imageVector: ImageVector = Icons.Filled.Notifications,
    onClicked: () -> Unit = {}
) {
    val dp02 = LeasePertTheme.sizes.middleSize
    val dp16 = LeasePertTheme.sizes.smallSize
    val dp08 = LeasePertTheme.sizes.smallerSize
    Box(modifier = modifier) {
        FilledIconButton(
            onClick = onClicked,
            colors = IconButtonDefaults.filledIconButtonColors(MaterialTheme.colorScheme.primary)
        ) {
            Icon(
                imageVector = imageVector,
                contentDescription = stringResource(R.string.cd_Icon),
                tint = MaterialTheme.colorScheme.onPrimary
            )
        }
        if (showBadge) {
            BadgedBox(
                modifier = Modifier
                    .padding(
                        horizontal = dp16,
                        vertical = dp08
                    )
                    .align(alignment = Alignment.BottomEnd),
                badge = {
                    Badge(
                        modifier = Modifier
                            .padding(all = dp02)
                            .align(alignment = Alignment.TopEnd)
                    ) {
                        Text(
                            text = badgeNumber,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            ) {}
        }
    }
}

/**
 * This function create a component to select a file and show
 * the file's name on the text
 *
 * @param modifier Modifier to add the specifications to the whole component.
 * @param mimeTypes MimeTypes is a list of string to choose the type of files like image or videos,
 * @param textButton TextButton is the text of the button
 * @param textHint TextHint is the text of the text hint
 * @param onFileSelected onFileSelected is the URI file selected.
 *
 * @author Melissa Arellano
 */
@Composable
fun LpFileButton(
    modifier: Modifier,
    mimeTypes: Array<String>,
    textButton: String = stringResource(R.string.text_choose_file),
    textHint: String = stringResource(R.string.text_no_selected_file),
    onFileSelected: (Uri) -> Unit,
) {
    val contentResolver = LocalContext.current.contentResolver
    var fileName by remember { mutableStateOf(textHint) }
    val launcher =
        rememberLauncherForActivityResult(ActivityResultContracts.OpenDocument()) { uri ->
            uri?.let { uriSelected ->
                onFileSelected(uriSelected)
                fileName = uriSelected.getFileName(contentResolver)
            }
        }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .border(
                border = BorderStroke(
                    width = LeasePertTheme.sizes.stroke,
                    color = MaterialTheme.colorScheme.onPrimary
                ),
                shape = RoundedCornerShape(LeasePertTheme.sizes.minorSmallSize)
            )
            .padding(LeasePertTheme.sizes.smallerSize)
    ) {
        Button(
            modifier = Modifier.padding(start = LeasePertTheme.sizes.smallerSize),
            onClick = { launcher.launch(mimeTypes) }
        ) {
            Text(
                text = textButton,
                fontSize = 18.sp
            )
        }
        Text(
            modifier = Modifier.padding(start = LeasePertTheme.sizes.smallSize),
            text = fileName.ifEmpty { stringResource(R.string.text_unable_to_get_file_name) },
            fontSize = 18.sp,
            color = MaterialTheme.colorScheme.tertiary
        )
    }
}

/**
 * This function create a group of radio buttons
 *
 * @param options Number of RadioButton displayed
 * @param selectedOption This is the actual RadioButton selected
 * @param onOptionSelected Changes the current RadioButton selected
 *
 * @author Jose Guadalupe Rivera
 */
@Composable
fun LpRadioGroup(
    modifier: Modifier = Modifier,
    options: List<String>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit,
) {
    Row(modifier = modifier) {
        options.forEach { option ->
            Row(modifier = Modifier
                .selectable(
                    selected = false,
                    onClick = { onOptionSelected(option) }
                )
                .padding(bottom = LeasePertTheme.sizes.smallerSize)
            ) {
                RadioButton(
                    selected = (option == selectedOption),
                    onClick = null,
                    colors = RadioButtonDefaults.colors(
                        selectedColor = MaterialTheme.colorScheme.onPrimary
                    )
                )
                Text(
                    text = option, Modifier.padding(
                        start = LeasePertTheme.sizes.smallerSize,
                        end = LeasePertTheme.sizes.extraSize10
                    )
                )
            }
        }
    }
}
