package com.iteneum.designsystem.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Error
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
    enabled: Boolean = true,
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
        enabled = enabled,
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
 * @param isEnabled Establish the button is enabled and ready to use
 * @param onPhoneChange Returns value typed
 *
 * @author Yaritza Moreno
 * @author Jose Miguel Garcia Reyes (fixes)
 */
@ExperimentalMaterial3Api
@Composable
fun LPPhoneNumberText(
    modifier: Modifier = Modifier,
    value: String,
    imeAction: ImeAction = ImeAction.Next,
    isEnabled: Boolean = true,
    isValid: Boolean,
    supportTextError: String,
    onPhoneChange: (String) -> Unit
) {
    var phoneNumberText by remember { mutableStateOf("") }
    val transform = PhoneNumberTransformation()
    val numbersOnlyExpression = Regex("^[0-9]*\$")
    val maxCharacters = 10
    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        label = { Text(text = stringResource(id = R.string.LPContactPhone)) },
        value = value,
        onValueChange = {
            Log.d("TEXT_FIELD","IT LENGTH --> ${it.length}")
            Log.d("TEXT_FIELD"," Phone LENGTH --> ${phoneNumberText.length}")
            if ( it.length > maxCharacters ) {
                Log.d("MAX_CHAR","phoneNumberText A --> $phoneNumberText")
                phoneNumberText = it.substring(0, it.length.coerceAtMost(10))
                Log.d("MAX_CHAR","phoneNumberText B --> $phoneNumberText")
            }
            else if ( !(it.matches(numbersOnlyExpression)) ) {
                Log.d("NUMBERS_ONLY","phoneNumberText A --> $phoneNumberText")

                phoneNumberText = it.filter { it in '0'..'9' }
                Log.d("NUMBERS_ONLY","phoneNumberText B --> $phoneNumberText")
            }
            else {
                Log.d("OK","phoneNumberText A --> $phoneNumberText")
                phoneNumberText = it
                Log.d("OK","phoneNumberText B --> $phoneNumberText")
            }
            onPhoneChange(it)
        },
        isError = isValid,
        supportingText = {
            if (isValid)
                Text(text = supportTextError)
                         },
        textStyle = TextStyle(fontSize = 18.sp),
        keyboardOptions = KeyboardOptions(
            imeAction = imeAction,
            keyboardType = KeyboardType.Number,
        ),
        visualTransformation = { transform.filter(AnnotatedString(phoneNumberText)) },
        enabled = isEnabled,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Color.Black,
            focusedBorderColor = MaterialTheme.colorScheme.onPrimary,
            focusedLabelColor = MaterialTheme.colorScheme.onPrimary,
            cursorColor = MaterialTheme.colorScheme.onPrimary
        )
    )
}
