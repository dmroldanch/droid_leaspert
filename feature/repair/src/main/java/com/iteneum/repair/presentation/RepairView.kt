package com.iteneum.repair.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.iteneum.designsystem.components.LpFileButton
import com.iteneum.designsystem.components.LpOutlinedTextFieldNumber
import com.iteneum.designsystem.components.LpRadioGroup
import com.iteneum.designsystem.theme.LPTypography
import com.iteneum.designsystem.theme.LeasePertTheme

@Preview
@Composable
fun RepairView() {
    val startPaddingMargin = 24.dp
    val endPaddingMargin = 24.dp
    val bottomPaddingMargin = 10.dp
    val valuePaddingText = 5.dp
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
            LpOutlinedTextFieldNumber(
                modifier = Modifier
                    .padding(
                        start = startPaddingMargin,
                        end = endPaddingMargin,
                        bottom = bottomPaddingMargin
                    )
                    .fillMaxWidth(),
                label = "Unit",
                hint = "Number",
                onValueChange = {}
            )
            LpOutlinedTextFieldNumber(
                modifier = Modifier
                    .padding(
                        start = startPaddingMargin,
                        end = endPaddingMargin,
                        bottom = bottomPaddingMargin
                    )
                    .fillMaxWidth(),
                label = "Contact Phone",
                hint = "Number",
                onValueChange = {}
            )
            LpOutlinedTextFieldNumber(
                modifier = Modifier
                    .padding(
                        start = startPaddingMargin,
                        end = endPaddingMargin,
                        bottom = bottomPaddingMargin
                    )
                    .fillMaxWidth(),
                label = "Pet in Unit",
                hint = "Category",
                onValueChange = {}
            )
            Text(
                text = "I would like to request a service for...",
                modifier = Modifier.padding(
                    start = startPaddingMargin,
                    top = valuePaddingText,
                    bottom = valuePaddingText
                ),
                style = LPTypography.bodyLarge
            )
            LpOutlinedTextFieldNumber(
                modifier = Modifier
                    .padding(
                        start = startPaddingMargin,
                        end = endPaddingMargin,
                        bottom = bottomPaddingMargin
                    )
                    .fillMaxWidth(),
                label = "Select Category...",
                hint = "Category",
                onValueChange = {}
            )
            LpOutlinedTextFieldNumber(
                modifier = Modifier
                    .padding(
                        start = startPaddingMargin,
                        end = endPaddingMargin,
                        bottom = bottomPaddingMargin
                    )
                    .height(height = 100.dp)
                    .fillMaxWidth(),
                label = "Describe your problem...",
                hint = "Text",
                onValueChange = {}
            )
            Text(
                text = "Upload video",
                modifier = Modifier.padding(
                    start = startPaddingMargin,
                    top = valuePaddingText,
                    bottom = valuePaddingText
                ),
                style = LPTypography.bodyLarge
            )
            LpFileButton(
                modifier = Modifier
                    .padding(
                        start = startPaddingMargin,
                        top = 5.dp,
                        end = endPaddingMargin,
                        bottom = bottomPaddingMargin
                    )
                    .fillMaxWidth(),
                mimeTypes = arrayOf("Option A", "Option B"),
                onFileSelected = {}
            )
            Text(
                text = "Permission to enter",
                modifier = Modifier.padding(
                    start = startPaddingMargin,
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
                LpRadioGroup(
                    options = listOf("Yes", "No"),
                    selectedOption = "Yes",
                    onOptionSelected = {}
                )
            }
        }
    }
}