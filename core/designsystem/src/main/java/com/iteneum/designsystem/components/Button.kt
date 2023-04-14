package com.iteneum.designsystem.components

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
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
 * @param onClick High order function for assign functionality to the button.
 *
 * @author Usiel Filiberto Garcia Jimenez
 */
@Composable
fun LpOutlinedButton(
    modifier: Modifier,
    textButton: String,
    icon: ImageVector? = null,
    onClick: () -> Unit
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(size = 12.dp),
        border = BorderStroke(width = 1.dp, color = MaterialTheme.colorScheme.onPrimary),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimary
        )
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            icon?.let {
                Icon(
                    imageVector = icon,
                    contentDescription = textButton,
                    modifier = Modifier.size(ButtonDefaults.IconSize)
                )
                Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
            }
            Text(text = textButton)
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
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary
        )
    ) {
        Text(text = textButton)
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
    color: Color = MaterialTheme.colorScheme.primary,
    colors: Color = contentColorFor(backgroundColor = MaterialTheme.colorScheme.onPrimary),
    onClick: () -> Unit,
) {
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

/**
 * Function that creates [LpBadgeButton] compose for user's notifications
 *
 * @param modifier to modify box properties that contains: Button & Badge
 * @param badgeNumber to modify the string number of notifications shown
 * @param showBadge to enable the number of notifications to be displayed
 * @param imageVector to modify the icon to be displayed
 * @param onClick high order function, to define button action
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
    onClick: () -> Unit = {}
) {
    val dp02 = LeasePertTheme.sizes.middleSize
    val dp16 = LeasePertTheme.sizes.smallSize
    val dp08 = LeasePertTheme.sizes.smallerSize
    Box(modifier = modifier) {
        FilledIconButton(
            onClick = onClick,
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
    textButton: String = "Choose File",
    textHint: String = "No selected file...",
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
                border = BorderStroke(width = 1.dp, MaterialTheme.colorScheme.onPrimary),
                shape = RoundedCornerShape(4.dp)
            )
            .padding(8.dp)
    ) {
        Button(
            modifier = Modifier.padding(start = 8.dp),
            onClick = { launcher.launch(mimeTypes) }
        ) {
            Text(
                text = textButton,
                fontSize = 18.sp
            )
        }
        Text(
            modifier = Modifier.padding(start = 16.dp),
            text = fileName.ifEmpty { "Unable to get file name" },
            fontSize = 18.sp,
            color = Color.Gray
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
            ) {
                RadioButton(
                    selected = (option == selectedOption),
                    onClick = null,
                    colors = RadioButtonDefaults.colors(
                        selectedColor = MaterialTheme.colorScheme.onPrimary
                    )
                )
                Text(text = option, Modifier.padding(start = 10.dp))
            }
            Spacer(modifier = Modifier.size(40.dp))
        }
    }
}
