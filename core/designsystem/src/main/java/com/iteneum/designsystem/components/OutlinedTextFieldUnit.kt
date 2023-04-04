package com.iteneum.designsystem.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LpOutlinedTextFieldNumber(
    label: String,
    hint: String,
    onTextChanged: (String) -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        var textFieldValue by remember { mutableStateOf(TextFieldValue("")) }
        val pattern = remember { Regex("^\\d+\$") }
        var isInputError = false
        OutlinedTextField(
            value = textFieldValue,
            onValueChange = {
                if (it.text.isEmpty() || it.text.matches(pattern)) {
                    textFieldValue = it
                }
            },
            modifier = Modifier.fillMaxWidth(),
            label = { Text(label) },
            placeholder = { Text(hint) },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = MaterialTheme.colorScheme.onPrimary,
                unfocusedBorderColor = MaterialTheme.colorScheme.onPrimary,
                textColor = MaterialTheme.colorScheme.onPrimary,
                errorBorderColor = MaterialTheme.colorScheme.error,
                disabledBorderColor = if (isInputError) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.secondary
            ),
            textStyle = MaterialTheme.typography.labelMedium.copy(
                color = MaterialTheme.colorScheme.onPrimary
            ),
            isError = isInputError,
            singleLine = true,
            maxLines = 1,
            shape = MaterialTheme.shapes.small,
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)// Especifica el teclado para el campo de texto como el de correo electrónico
        )
    }
}





