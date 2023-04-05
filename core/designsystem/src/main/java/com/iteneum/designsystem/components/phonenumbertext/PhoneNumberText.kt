package com.iteneum.designsystem.components.phonenumbertext

import android.telephony.PhoneNumberFormattingTextWatcher
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.iteneum.designsystem.theme.Drab
import com.iteneum.designsystem.theme.MintJulep

//Giving phone number format
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

@ExperimentalMaterial3Api
@Composable
fun PhoneNumberText() {
    var text by remember { mutableStateOf("") }
    var showError by remember { mutableStateOf(false) }
    val imeAction: ImeAction = ImeAction.Next
    val keyboardType: KeyboardType = KeyboardType.Phone
    val isEnabled = true

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        label = { Text(text = "Contact phone") },
        value = text,
        onValueChange = {
            showError = false
            text = it.replace("\n", "").replace("\t", "")
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

