package com.iteneum.designsystem.components

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.contentColorFor
import androidx.compose.material3.Text
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Badge
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iteneum.designsystem.theme.Drab
import com.iteneum.designsystem.theme.MintJulep
import com.iteneum.designsystem.utils.getFileName

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
 * Create [BadgeButton] compose for user's notifications
 *
 * @param modifier to modify box properties that contains: Button & Badge
 * @param badgeNumber to modify the number of notifications shown
 * @param onClick high order function, to define button action
 *
 * @author Jose Miguel Garcia Reyes
 */
@ExperimentalMaterial3Api
@Composable
fun BadgeButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    badgeNumber: Int
) {
    Box {
        FilledIconButton(
            onClick = onClick,
            colors = IconButtonDefaults.filledIconButtonColors(MintJulep)
        ) {
            Icon(
                Icons.Filled.Notifications,
                contentDescription = "Notifications button",
                tint = Drab
            )
        }

        if (badgeNumber > 0) {
            BadgedBox(modifier = modifier
                .padding(horizontal = 15.dp, vertical = 7.dp)
                .align(Alignment.BottomEnd), badge = {
                Badge(
                    modifier = Modifier
                        .padding(all = 1.dp)
                        .align(Alignment.TopEnd)
                ) {
                    Text(text = badgeNumber.toString())
                }
            }) {}
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
    options: List<String>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit,
) {
    Row {
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
