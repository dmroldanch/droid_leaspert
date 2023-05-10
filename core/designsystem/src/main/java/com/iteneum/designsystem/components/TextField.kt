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
 * @param labelText The text to be used as the input field label
 * @param value Current password value
 * @param isValid Validate if text is valid
 * @param supportTextError This parameter determines whether the error is displayed or not
 * @param onPasswordChanged Returns value typed
 *
 * @author Jose G. Rivera
 * @modifiedBy Jesus Lopez
 * @modifiedBy Irving Gonzalez
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LpOutlinedTextFieldPassword(
    modifier: Modifier = Modifier,
    labelText: String = "",
    value: String = "",
    isValid: Boolean = true,
    supportTextError: String = "",
    onPasswordChanged: (String) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = onPasswordChanged,
        modifier = modifier,
        label = {
            Text(
                text = labelText,
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
 * @param supportTextError The error message to be displayed when validation fails
 * @param value The value of the component
 * @param onValueChanged The callback function to be triggered on value change
 *
 * @author Jesus Lopez
 * @modifiedBy Irving Gonzalez
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LpOutlinedTextField(
    modifier: Modifier,
    label: String,
    hint: String,
    isValid: Boolean,
    supportTextError: String,
    value: String = "",
    onValueChanged: (String) -> Unit
) {

    OutlinedTextField(
        value = value,
        onValueChange = onValueChanged,
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
                Text(text = value)
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
 * @param value The current value of the input field
 * @param onValueChanged This parameter return the field value
 *
 * @author Andrés Ivan Medina Herrera
 * @modifiedBy Jesus Lopez
 * @modifiedBy Irving Gonzalez
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LpOutlinedTextFieldMail(
    modifier: Modifier,
    label: String,
    isValid: Boolean,
    supportTextError: String,
    value: String = "",
    onValueChanged: (String) -> Unit
) {

    OutlinedTextField(
        value = value,
        onValueChange = onValueChanged,
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
                Text(text = value)
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
 * @param value The current value of the field
 * @param onValueChanged This parameter return the field value
 *
 * @author Andrés Ivan Medina Herrera
 * @modifiedBy Irving Gonzalez
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LpOutlinedTextFieldInput(
    modifier: Modifier,
    enabled: Boolean = true,
    label: String,
    hint: String,
    value: String = "",
    onValueChanged: (String) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChanged,
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
 * @param value The current value of the input field
 *
 * @author Jesus Lopez Gonzalez
 * @modifiedBy Jose Miguel Garcia Reyes
 * @modifiedBy Irving Gonzalez
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropdownTextField(
    modifier: Modifier = Modifier,
    title: String,
    items: List<String>,
    value: String = "",
    selected: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

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
            value = value,
            onValueChange = selected,
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
                        selected(selectedOption)
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
 * @modifiedBy Irving Gonzalez
 */
@ExperimentalMaterial3Api
@Composable
fun LPPhoneNumberText(
    modifier: Modifier = Modifier,
    value: String = "",
    isEnabled: Boolean = true,
    isNotValid: Boolean,
    supportTextError: String,
    onPhoneChanged: (String) -> Unit
) {
    val numbersOnlyExpression = Regex("^\\d*\$")
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
            if (it.matches(numbersOnlyExpression) && it.length <= maxCharactersAllowed) onPhoneChanged(it)
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
            phoneNumberTransformation.filter(AnnotatedString(value))
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
