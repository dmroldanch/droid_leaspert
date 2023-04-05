package com.iteneum.designsystem.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import com.iteneum.designsystem.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LpOutlinedTextFieldPassword(
) {
    var password by remember { mutableStateOf("") }
    var showError by remember { mutableStateOf(false) }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .onFocusChanged {
                if (!it.isFocused) {
                    showError = password.length < 6 && password.isNotEmpty()
                }
            },
        value = password,
        onValueChange = {
            showError = false
            password = it.replace("\n", "").replace("\t", "")
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = MaterialTheme.colorScheme.onPrimary,
            focusedLabelColor = MaterialTheme.colorScheme.onPrimary,
            unfocusedBorderColor = MaterialTheme.colorScheme.onPrimary,
            cursorColor = MaterialTheme.colorScheme.onPrimary,
            placeholderColor = Color.LightGray
        ),
        label = { Text(text = stringResource(id = R.string.OTFPasswordLabel)) },
        placeholder = { Text(text = stringResource(id = R.string.OTFPasswordLabel)) },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            if (showError) {
                Icon(
                    imageVector = Icons.Filled.Error,
                    contentDescription = stringResource(id = R.string.OTFPasswordContentDescriptionError),
                    tint = MaterialTheme.colorScheme.error
                )
            }
        },
        supportingText = {
            if (showError) {
                Text(text = stringResource(id = R.string.OTFPasswordMessageError))
            }
        },
        isError = showError,
        singleLine = true,
        maxLines = 1
    )
}