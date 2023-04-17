package com.iteneum.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Error
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.sp
import com.iteneum.designsystem.R
import com.iteneum.designsystem.components.phonenumbertext.mobileNumberFilter
import com.iteneum.designsystem.theme.Drab
import com.iteneum.designsystem.theme.MintJulep

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

/**
 * This function creates a password OutlinedTextField
 * @param modifier Set component modifier
 * @param label Text label
 * @param hint Hint message
 * @param isValid Validate if text is valid
 * @param supportTextError Error message
 * @param onValueChange This parameter return the field value
 *
 * @author Andrés Ivan Medina Herrera
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LpOutlinedTextFieldMail(
    modifier: Modifier,
    label: String,
    hint: String,
    isValid: Boolean,
    supportTextError: String,
    onValueChange: (String) -> Unit
) {
    var textFieldValue by remember { mutableStateOf(TextFieldValue("")) }

    OutlinedTextField(
        value = textFieldValue,
        onValueChange = {
            textFieldValue = it
            onValueChange(textFieldValue.text)
        },
        modifier = modifier,
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
/**
 * This function creates a password OutlinedTextField
 * @param modifier Set component modifier
 * @param enabled set enabled/disabled component
 * @param label Text label
 * @param hint Hint message
 * @param onValueChange This parameter return the field value
 *
 * @author Andrés Ivan Medina Herrera
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LpOutlinedTextFieldInput(
    modifier: Modifier,
    enabled:Boolean,
    label: String,
    hint: String,
    onValueChange: (String) -> Unit,
) {
    var textFieldValue by remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(
        value = textFieldValue,
        onValueChange = {
            textFieldValue = it
            onValueChange(textFieldValue.text)
        },
        modifier = modifier.fillMaxWidth(),
        enabled=enabled,
        label = { Text(label) },
        placeholder = { Text(hint) },
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
 * [DropdownTextField] it's a textfield to show a list of items inside a box
 *
 * @param title refers to the label that the textfield will have
 * @param items refers to the list that will be given to expand the textfield
 * @param modifier to set component modifier
 * @param selected its a high order function that returns the selected option of the dropdown as result
 *
 * @author Jesus Lopez Gonzalez
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropdownTextField(
    modifier: Modifier = Modifier,
    title: String,
    items: List<String>,
    selected : (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf("") }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
        modifier = modifier
    ) {
        OutlinedTextField(
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth(),
            value = selectedOptionText,
            onValueChange = {},
            label = { Text(text = title) },
            trailingIcon = {
                IconButton(onClick = { expanded = true }) {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = stringResource(id = R.string.DTFDropdownDescription)
                    )
                }
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = MaterialTheme.colorScheme.onPrimary,
                focusedLabelColor = MaterialTheme.colorScheme.onPrimary,
                unfocusedBorderColor = MaterialTheme.colorScheme.onPrimary,
                cursorColor = MaterialTheme.colorScheme.onPrimary,
                placeholderColor = MaterialTheme.colorScheme.onPrimary
            )
        )
        ExposedDropdownMenu(
            modifier = Modifier.background(MaterialTheme.colorScheme.primary),
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            items.forEach {selectedOption ->
                DropdownMenuItem(
                    text = {Text(selectedOption)},
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
 * @param value Current phone value
 * @param imeAction Signals the keyboard what type of action should be displayed
 * @param keyboardType Displays a phone keyboard
 * @param isEnabled Establish the button is enabled and ready to use
 * @param showError This parameter determines whether the error is displayed or not
 * @param onPhoneChange Returns value typed
 *
 * @author Yaritza Moreno
 */
@ExperimentalMaterial3Api
@Composable
fun LPPhoneNumberText(
    modifier: Modifier = Modifier,
    value: String,
    imeAction: ImeAction = ImeAction.Next,
    keyboardType: KeyboardType = KeyboardType.Phone,
    isEnabled: Boolean = true,
    showError: Boolean = false,
    onPhoneChange: (String) -> Unit
) {

    //Text value for the TextField label
    var text by remember { mutableStateOf("") }
    val maxChar = 10
    val focusManager = LocalFocusManager.current

    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        label = { Text(text = stringResource(id = R.string.LPContactPhone)) },
        value = value,
        onValueChange = {
            text = it.take(maxChar)
            if (it.length > maxChar) {
                focusManager.moveFocus(FocusDirection.Down) // Or receive a lambda function
            }
            onPhoneChange(it)
        },
        textStyle = TextStyle(fontSize = 18.sp),
        keyboardOptions = KeyboardOptions(
            imeAction = imeAction,
            keyboardType = keyboardType
        ),
        visualTransformation = { mobileNumberFilter(it) },
        enabled = isEnabled,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Color.Black,
            focusedBorderColor = MaterialTheme.colorScheme.onPrimary,
            focusedLabelColor = MaterialTheme.colorScheme.onPrimary,
            cursorColor = MaterialTheme.colorScheme.onPrimary
        )
    )
}

