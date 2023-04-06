package com.iteneum.designsystem.components.phonenumbertext

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.unit.sp
import com.iteneum.designsystem.R

/*This block of code give format
* for number phone in USA format
* */
const val mask = "xxx xxx xxxx"
fun mobileNumberFilter(text: AnnotatedString): TransformedText {
    // change the length
    val trimmed =
        if (text.text.length >= 10) text.text.substring(0..9) else text.text

    val annotatedString = AnnotatedString.Builder().run {
        for (i in trimmed.indices) {
            append(trimmed[i])
            if (i == 2 || i == 5) {
                append(" ")
            }
        }
        pushStyle(SpanStyle(color = Color.LightGray))
        append(mask.takeLast(mask.length - length))
        toAnnotatedString()
    }

    val phoneNumberOffsetTranslator = object : OffsetMapping {
        override fun originalToTransformed(offset: Int): Int {
            if (offset <= 2) return offset
            if (offset <= 5) return offset + 1
            return 11
        }

        override fun transformedToOriginal(offset: Int): Int {
            if (offset <= 2) return offset
            if (offset <= 5) return offset - 1
            return 9
        }
    }
    return TransformedText(annotatedString, phoneNumberOffsetTranslator)
}

/**
 * This function creates a password OutlinedTextField
 * @param modifier Set component modifier
 * @param value Current password value
 * @param errorMessage Set the error message to be displayed when an error occurs
 * @param showError This parameter determines whether the error is displayed or not
 * @param onPhoneChange Returns value typed
 *
 * @author Yaritza Moreno
 */
@ExperimentalMaterial3Api
@Composable
fun PhoneNumberText(
    modifier: Modifier = Modifier,
    imeAction: ImeAction = ImeAction.Next,
    keyboardType: KeyboardType = KeyboardType.Phone,
    isEnabled: Boolean = true,
    showError: Boolean = false,
    onPhoneChange: (String) -> Unit
) {
    var text by remember { mutableStateOf("") }
    val maxChar = 10
    val focusManager = LocalFocusManager.current

    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        label = { Text(text = "Contact phone") },
        value = text,
        onValueChange = {
            text = it.take(maxChar)
            if (it.length > maxChar){
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
            textColor = Black,
            focusedBorderColor = MaterialTheme.colorScheme.onPrimary,
            focusedLabelColor = MaterialTheme.colorScheme.onPrimary,
            cursorColor = MaterialTheme.colorScheme.onPrimary
        )
    )
}

