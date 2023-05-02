package com.iteneum.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.sp
import com.iteneum.designsystem.R
import com.iteneum.designsystem.components.phonenumbertext.PhoneNumberTransformation

/**
 * This function creates a password OutlinedTextField
 * @param modifier Set component modifier
 * @param value Current password value
 * @param isValid Validate if text is valid
 * @param supportTextError This parameter determines whether the error is displayed or not
 * @param onPasswordChanged Returns value typed
 *
 * @author Jose G. Rivera
 * @modifiedBy Jesus Lopez
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LpOutlinedTextFieldPassword(
    modifier: Modifier,
    value: String,
    isValid: Boolean,
    supportTextError: String,
    onPasswordChanged: (String) -> Unit
) {
    var passwordFieldValue by remember { mutableStateOf(TextFieldValue("")) }

    OutlinedTextField(
        value = passwordFieldValue,
        onValueChange = {
            passwordFieldValue = it
            onPasswordChanged(passwordFieldValue.text)
        },
        modifier = modifier,
        label = {
            Text(
                text = value,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.tertiary
            )
        },
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
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Password
        ),
        visualTransformation = PasswordVisualTransformation()
    )
}


/**
 * This function creates a generic OutlinedTextField
 * @param modifier Set component modifier
 * @param label Text label
 * @param hint Hint message
 * @param isValid Validate if text is valid
 * @param supportTextError Error message
 * @param onValueChanged This parameter return the field value
 *
 * @author Jesus Lopez
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LpOutlinedTextField(
    modifier: Modifier,
    label: String,
    hint: String,
    isValid: Boolean,
    supportTextError: String,
    onValueChanged: (String) -> Unit
) {
    var textFieldValue by remember { mutableStateOf(TextFieldValue("")) }

    OutlinedTextField(
        value = textFieldValue,
        onValueChange = {
            textFieldValue = it
            onValueChanged(textFieldValue.text)
        },
        modifier = modifier,
        label = {
            Text(
                text = label,
                color = MaterialTheme.colorScheme.tertiary
            )
        },
        placeholder = {
            Text(
                text = hint,
                color = MaterialTheme.colorScheme.tertiary
            )
        },
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

/**
 * This function creates an Email OutlinedTextField
 * @param modifier Set component modifier
 * @param label Text label
 * @param isValid Validate if text is valid
 * @param supportTextError Error message
 * @param onValueChanged This parameter return the field value
 *
 * @author Andrés Ivan Medina Herrera
 * @modifiedBy Jesus Lopez
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LpOutlinedTextFieldMail(
    modifier: Modifier,
    label: String,
    isValid: Boolean,
    supportTextError: String,
    onValueChanged: (String) -> Unit
) {
    var emailFieldValue by remember { mutableStateOf(TextFieldValue("")) }

    OutlinedTextField(
        value = emailFieldValue,
        onValueChange = {
            emailFieldValue = it
            onValueChanged(emailFieldValue.text)
        },
        modifier = modifier,
        label = {
            Text(
                text = label,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.tertiary
            )
        },
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
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Email
        )
    )
}

/**
 * This function creates a password OutlinedTextField
 * @param modifier Set component modifier
 * @param label Text label
 * @param hint Hint message
 * @param onValueChanged This parameter return the field value
 *
 * @author Andrés Ivan Medina Herrera
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LpOutlinedTextFieldInput(
    modifier: Modifier,
    enabled: Boolean = true,
    label: String,
    hint: String,
    onValueChanged: (String) -> Unit,
) {
    var textFieldValue by remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(
        value = textFieldValue,
        onValueChange = {
            textFieldValue = it
            onValueChanged(textFieldValue.text)
        },
        modifier = modifier,
        enabled = enabled,
        label = {
            Text(
                text = label,
                color = MaterialTheme.colorScheme.tertiary
            )
        },
        placeholder = {
            Text(
                text = hint,
                color = MaterialTheme.colorScheme.tertiary
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedLabelColor = MaterialTheme.colorScheme.onPrimary,
            focusedBorderColor = MaterialTheme.colorScheme.onPrimary,
            unfocusedBorderColor = MaterialTheme.colorScheme.onPrimary,
            errorBorderColor = MaterialTheme.colorScheme.error,
            errorLabelColor = MaterialTheme.colorScheme.error,
            errorSupportingTextColor = MaterialTheme.colorScheme.error
        ),
        singleLine = true,
        maxLines = 1,
        shape = MaterialTheme.shapes.small,
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text)
    )
}

/**
 * [DropdownTextField] it's a text-field to show a list of items inside a box
 *
 * @param modifier to set component modifier
 * @param title refers to the label that the text-field will have
 * @param items refers to the elements of the DropDownList (list of elements)
 * @param selected refers to a high order function that returns the selected option of the DropDownList
 *
 * @author Jesus Lopez Gonzalez
 * @modifiedBy Jose Miguel Garcia Reyes
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropdownTextField(
    modifier: Modifier = Modifier,
    title: String,
    items: List<String>,
    selected: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf("") }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        },
        modifier = modifier
    ) {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .menuAnchor(),
            value = selectedOptionText,
            onValueChange = { },
            readOnly = true,
            label = { Text(text = title, color = MaterialTheme.colorScheme.tertiary) },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = expanded
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = MaterialTheme.colorScheme.onPrimary,
                focusedLabelColor = MaterialTheme.colorScheme.onPrimary,
                unfocusedBorderColor = MaterialTheme.colorScheme.onPrimary,
                cursorColor = MaterialTheme.colorScheme.onPrimary,
                placeholderColor = MaterialTheme.colorScheme.onPrimary
            )
        )
        DropdownMenu(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .exposedDropdownSize(),
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            }
        ) {
            items.forEach { selectedOption ->
                DropdownMenuItem(
                    text = { Text(selectedOption) },
                    onClick = {
                        selectedOptionText = selectedOption
                        selected(selectedOptionText)
                        expanded = false
                    },
                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                )
            }
        }
    }
}

/**
 * This function creates a phone number OutlinedTextField
 * @param modifier Set component modifier
 * @param value Current contact phone text value
 * @param isEnabled Establish the button is enabled and ready to use
 * @param isNotValid Indicates if the value introduced is not valid
 * @param supportTextError Indicates the error message when is not valid
 * @param onPhoneChanged Returns value typed, using high order functions
 *
 * @author Yaritza Moreno
 * @modifiedBy Jose Miguel Garcia Reyes
 */
@ExperimentalMaterial3Api
@Composable
fun LPPhoneNumberText(
    modifier: Modifier = Modifier,
    value: String,
    isEnabled: Boolean = true,
    isNotValid: Boolean,
    supportTextError: String,
    onPhoneChanged: (String) -> Unit
) {
    var phoneNumberText by remember { mutableStateOf("") }
    val numbersOnlyExpression = remember { Regex("^\\d*\$") }
    val phoneNumberTransformation = PhoneNumberTransformation()
    val maxCharactersAllowed = 10
    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        label = {
            Text(
                text = stringResource(id = R.string.LPContactPhone),
                color = MaterialTheme.colorScheme.tertiary
            )
        },
        placeholder = {
            Text(
                text = stringResource(id = R.string.LPContactPhone_mask),
                color = MaterialTheme.colorScheme.tertiary
            )
        },
        value = value,
        onValueChange = {
            if (it.matches(numbersOnlyExpression) && it.length <= maxCharactersAllowed)
                phoneNumberText = it
            onPhoneChanged(phoneNumberText)
        },
        isError = isNotValid,
        supportingText = {
            if (isNotValid)
                Text(text = supportTextError)
        },
        textStyle = TextStyle(fontSize = 18.sp),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Next
        ),
        visualTransformation = {
            phoneNumberTransformation.filter(AnnotatedString(phoneNumberText))
        },
        enabled = isEnabled,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = MaterialTheme.colorScheme.onPrimary,
            focusedLabelColor = MaterialTheme.colorScheme.onPrimary,
            unfocusedBorderColor = MaterialTheme.colorScheme.onPrimary,
            cursorColor = MaterialTheme.colorScheme.onPrimary,
            placeholderColor = MaterialTheme.colorScheme.onPrimary
        )
    )
}
