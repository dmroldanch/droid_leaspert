package com.iteneum.designsystem.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import com.iteneum.designsystem.R

/**
 * This function creates a password OutlinedTextField
 * @param modifier Set component modifier
 * @param value Current password value
 * @param errorMessage Set the error message to be displayed when an error occurs
 * @param showError This parameter determines whether the error is displayed or not
 * @param onPasswordChange Returns value typed
 *
 * @author Jose G. Rivera
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LpOutlinedTextFieldPassword(
    modifier: Modifier = Modifier,
    value: String = "",
    errorMessage: String = "",
    showError: Boolean = false,
    onPasswordChange: (String) -> Unit
) {
    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = {
            onPasswordChange(it)
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
                Text(text = errorMessage)
            }
        },
        isError = showError,
        singleLine = true,
        maxLines = 1
    )
}