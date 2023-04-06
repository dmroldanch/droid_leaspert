package com.iteneum.designsystem.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * A component to generate a comment field.
 *
 * @param modifier to modify an specific property of the textfield
 * @param comment: string for user's comment
 * @param hint: Show a hint for the comment.
 * @param onValueChanged: high order function param
 *
 * @author Kevin Velez
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LpGenericComment(
    modifier: Modifier = Modifier,
    comment: String,
    hint: String = "Describe your problem...",
    onValueChanged: (String) -> Unit
) {
    OutlinedTextField(
        modifier = modifier
            .heightIn(min = 150.dp)
            .fillMaxWidth()
            .padding(15.dp),
        value = comment,
        onValueChange = onValueChanged,
        singleLine = false,
        placeholder = {Text(text=hint)},
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = MaterialTheme.colorScheme.onPrimary,
            unfocusedBorderColor = MaterialTheme.colorScheme.onPrimary,
            focusedLabelColor = MaterialTheme.colorScheme.onPrimary,
            errorLabelColor = MaterialTheme.colorScheme.error,
            errorBorderColor = MaterialTheme.colorScheme.error,
            errorSupportingTextColor = MaterialTheme.colorScheme.error
        ),
    )
}
