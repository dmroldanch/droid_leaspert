package com.iteneum.designsystem.components

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview





@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LpOutlinedTextFieldMail(
    modifier: Modifier,
    label: String,
    hint: String,
    onValueChange: (String) -> Unit,
    isValid: Boolean,
    supportTextError: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var textFieldValue by remember { mutableStateOf(TextFieldValue("")) }

        OutlinedTextField(
            value = textFieldValue,
            onValueChange = {
                textFieldValue = it
                onValueChange(textFieldValue.text)
            },
            modifier = Modifier.fillMaxWidth(),
            label = { Text(label) },
            placeholder = { Text(hint) },
            colors = TextFieldDefaults.outlinedTextFieldColors(

                focusedBorderColor = MaterialTheme.colorScheme.onPrimary,
                unfocusedBorderColor = MaterialTheme.colorScheme.onPrimary,
                focusedLabelColor = MaterialTheme.colorScheme.onPrimary,
                errorLabelColor = MaterialTheme.colorScheme.error,
                errorBorderColor = MaterialTheme.colorScheme.error,
                errorSupportingTextColor = MaterialTheme.colorScheme.error
            ),
            isError = isValid,
            supportingText = {
                if (isValid) {
                    Text(text = supportTextError)
                } else {
                    Text(text = "")
                }
            },
            singleLine = true,
            maxLines = 1,
            shape = MaterialTheme.shapes.small,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Email
            )

        )
    }
}
