package com.iteneum.designsystem.components

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iteneum.designsystem.utils.getFileName

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
    var fileName by remember { mutableStateOf<String>(textHint) }
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
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.onPrimary),
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