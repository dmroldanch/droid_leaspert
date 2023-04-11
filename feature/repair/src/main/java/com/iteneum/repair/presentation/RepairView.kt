package com.iteneum.repair.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.iteneum.designsystem.components.LpFileButton
import com.iteneum.designsystem.components.LpOutlinedTextFieldMail
import com.iteneum.designsystem.components.LpOutlinedTextFieldNumber
import com.iteneum.designsystem.components.LpRadioGroup
import com.iteneum.designsystem.theme.LPTypography
import com.iteneum.designsystem.theme.LeasePertTheme

@Preview
@Composable
fun RepairView() {
    val startMargin = 24.dp
    val topMargin = 0.dp
    val endMargin = 24.dp
    val bottomMargin = 10.dp
    val valuePaddingText = 5.dp
    val radioValueList = listOf("Yes", "No")
    LeasePertTheme {
        Column {
            Row {
                Image(
                    imageVector = Icons.Outlined.ArrowBack,
                    contentDescription = "Arrow Icon",
                    modifier = Modifier.padding(start = 20.dp, top = 25.dp)
                )
                Text(
                    text = "Repair Request",
                    modifier = Modifier.padding(all = 20.dp),
                    style = LPTypography.headlineSmall
                )
            }
            LpOutlinedTextFieldMail(
                modifier = Modifier
                    .padding(
                        start = startMargin,
                        top = topMargin,
                        end = endMargin,
                        bottom = bottomMargin
                    )
                    .fillMaxWidth(),
                label = "Unit",
                hint = "Alphanumeric",
                isValid = false,
                supportTextError = "Field already filled",
                onValueChange = {}
            )
            LpOutlinedTextFieldNumber(
                modifier = Modifier
                    .padding(
                        start = startMargin,
                        top = topMargin,
                        end = endMargin,
                        bottom = bottomMargin
                    )
                    .fillMaxWidth(),
                label = "Contact Phone",
                hint = "Number",
                onValueChange = {}
            )
            LpOutlinedTextFieldNumber(
                modifier = Modifier
                    .padding(
                        start = startMargin,
                        top = topMargin,
                        end = endMargin,
                        bottom = bottomMargin
                    )
                    .fillMaxWidth(),
                label = "Pet in Unit",
                hint = "Category",
                onValueChange = {}
            )
            Text(
                text = "I would like to request a service for...",
                modifier = Modifier.padding(
                    start = startMargin,
                    top = valuePaddingText,
                    bottom = valuePaddingText
                ),
                style = LPTypography.bodyLarge
            )
            LpOutlinedTextFieldNumber(
                modifier = Modifier
                    .padding(
                        start = startMargin,
                        top = topMargin,
                        end = endMargin,
                        bottom = bottomMargin
                    )
                    .fillMaxWidth(),
                label = "Select Category...",
                hint = "Category",
                onValueChange = {}
            )
            var isValidDescription by remember {
                mutableStateOf(false)
            }
            LpOutlinedTextFieldMail(
                modifier = Modifier
                    .padding(
                        start = startMargin,
                        top = topMargin,
                        end = endMargin,
                        bottom = bottomMargin
                    )
                    .height(height = 100.dp)
                    .fillMaxWidth(),
                label = "Describe your problem...",
                hint = "Text",
                isValid = isValidDescription,
                supportTextError = "Field required. Not empty and with letters.",
                onValueChange = {
                    isValidDescription = it.isEmpty() || it.matches(Regex(".*[a-zA-Z]+.*")).not()
                }
            )
            Text(
                text = "Upload video",
                modifier = Modifier.padding(
                    start = startMargin,
                    top = valuePaddingText,
                    bottom = valuePaddingText
                ),
                style = LPTypography.bodyLarge
            )
            LpFileButton(
                modifier = Modifier
                    .padding(
                        start = startMargin,
                        top = topMargin,
                        end = endMargin,
                        bottom = bottomMargin
                    )
                    .fillMaxWidth(),
                mimeTypes = arrayOf("Option A", "Option B"),
                onFileSelected = {}
            )
            Text(
                text = "Permission to enter",
                modifier = Modifier.padding(
                    start = startMargin,
                    top = valuePaddingText,
                    bottom = valuePaddingText
                ),
                style = LPTypography.bodyLarge
            )
            Column(
                modifier = Modifier.padding(
                    start = 38.dp,
                    top = valuePaddingText,
                    bottom = valuePaddingText
                )
            ) {
                var selectedOption by remember {
                    mutableStateOf(radioValueList[0])
                }
                LpRadioGroup(
                    options = radioValueList,
                    selectedOption = selectedOption,
                    onOptionSelected = {
                        selectedOption = it
                    }
                )
            }
        }
    }
}
