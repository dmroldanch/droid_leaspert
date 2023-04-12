package com.iteneum.repair.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.iteneum.designsystem.components.LpFileButton
import com.iteneum.designsystem.components.LpOutlinedTextFieldMail
import com.iteneum.designsystem.components.LpOutlinedTextFieldNumber
import com.iteneum.designsystem.components.LpRadioGroup
import com.iteneum.designsystem.theme.LPTypography
import com.iteneum.designsystem.theme.LeasePertTheme
import com.iteneum.repair.R

@Preview
@Composable
fun RepairView() {
    val dp24 = LeasePertTheme.sizes.regularSize
    val dp20 = LeasePertTheme.sizes.minorRegularSize
    val eSdp06 = LeasePertTheme.sizes.extraSize6
    val eSdp10 = LeasePertTheme.sizes.extraSize10
    val eSdp104 = LeasePertTheme.sizes.extraSize104
    val arrayRadioButtons = stringArrayResource(id = R.array.list_RadioButton)
    var isValidDescription by remember {
        mutableStateOf(false)
    }
    var selectedOptionRadioButtons by remember {
        mutableStateOf(arrayRadioButtons[0])
    }
    LeasePertTheme {
        Column(
            modifier = Modifier.padding(
                start = dp24,
                top = dp20,
                end = dp24
            )
        ) {
            Row {
                /* TODO - Add "arrow" navigation component when available */
                Text(
                    text = stringResource(R.string.text_title),
                    modifier = Modifier.padding(
                        all = eSdp06
                    ),
                    style = LPTypography.headlineSmall
                )
            }
            LpOutlinedTextFieldMail(
                modifier = Modifier.padding(
                    top = dp20
                ),
                label = stringResource(id = R.string.label_Unit),
                hint = stringResource(id = R.string.hint_Unit),
                isValid = false,
                supportTextError = stringResource(id = R.string.supportError_Unit),
                onValueChange = {}
            )/* TODO - Change the component when available (Disable/Generic) */
            LpOutlinedTextFieldNumber(
                modifier = Modifier.padding(
                    top = eSdp10
                ),
                label = stringResource(id = R.string.label_ContactPhone),
                hint = stringResource(id = R.string.hint_ContactPhone),
                onValueChange = {}
            )/* TODO - Change for "Telephone Number" component when available */
            LpOutlinedTextFieldNumber(
                modifier = Modifier.padding(
                    top = eSdp10
                ),
                label = stringResource(id = R.string.label_PetInUnit),
                hint = stringResource(id = R.string.hint_PetInUnit),
                onValueChange = {}
            )/* TODO - Change for "Category" component when available A */
            Text(
                text = stringResource(id = R.string.text_Service),
                modifier = Modifier.padding(
                    top = eSdp10
                ),
                style = LPTypography.bodyLarge
            )
            LpOutlinedTextFieldNumber(
                modifier = Modifier.padding(
                    top = eSdp06
                ),
                label = stringResource(id = R.string.label_Category),
                hint = stringResource(id = R.string.hint_Category),
                onValueChange = {}
            )/* TODO - Change for "Category" component when available B */
            LpOutlinedTextFieldMail(
                modifier = Modifier
                    .padding(
                        top = eSdp10
                    )
                    .height(height = eSdp104),
                label = stringResource(id = R.string.label_Description),
                hint = stringResource(id = R.string.hint_Description),
                isValid = isValidDescription,
                supportTextError = stringResource(id = R.string.supportError_Description),
                onValueChange = {
                    isValidDescription = it.isEmpty() || it.matches(Regex(".*[a-zA-Z]+.*")).not()
                }
            )
            Text(
                text = stringResource(id = R.string.text_Video),
                modifier = Modifier.padding(
                    top = eSdp10
                ),
                style = LPTypography.bodyLarge
            )
            LpFileButton(
                modifier = Modifier
                    .padding(
                        top = eSdp06
                    )
                    .fillMaxWidth(),
                mimeTypes = arrayOf("Option A", "Option B"),
                onFileSelected = {}
            )
            Text(
                text = stringResource(id = R.string.text_Permission),
                modifier = Modifier.padding(
                    top = eSdp10
                ),
                style = LPTypography.bodyLarge
            )
            Column(
                modifier = Modifier.padding(
                    start = eSdp10,
                    top = eSdp10
                )
            ) {
                LpRadioGroup(
                    options = arrayRadioButtons.toList(),
                    selectedOption = selectedOptionRadioButtons,
                    onOptionSelected = {
                        selectedOptionRadioButtons = it
                    }
                )
            }
        }
    }
}
