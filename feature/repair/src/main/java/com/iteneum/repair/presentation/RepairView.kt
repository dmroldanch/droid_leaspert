package com.iteneum.repair.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.iteneum.designsystem.components.*
import com.iteneum.designsystem.theme.LPTypography
import com.iteneum.designsystem.theme.LeasePertTheme
import com.iteneum.repair.R

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun RepairView() {
    val dp24 = LeasePertTheme.sizes.regularSize
    val dp20 = LeasePertTheme.sizes.minorRegularSize
    val eSdp06 = LeasePertTheme.sizes.extraSize6
    val eSdp10 = LeasePertTheme.sizes.extraSize10
    val eSdp104 = LeasePertTheme.sizes.extraSize104
    val arrayRadioButtons = stringArrayResource(id = R.array.list_RadioButton)
    val arrayPetInUnit = stringArrayResource(id = R.array.list_PetInUnit)
    val arrayCategory = stringArrayResource(id = R.array.list_Category)
    var isValidDescription by remember {
        mutableStateOf(false)
    }
    var selectedOptionRadioButtons by remember {
        mutableStateOf(arrayRadioButtons[0])
    }
    var numberValue by remember {
        mutableStateOf("")
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
                modifier = Modifier
                    .padding(
                        top = dp20
                    )
                    .fillMaxWidth(),
                label = stringResource(id = R.string.label_Unit),
                hint = stringResource(id = R.string.hint_Unit),
                isValid = false,
                supportTextError = stringResource(id = R.string.supportError_Unit),
                onValueChange = {}
            )/* TODO - Change the component when available (Disable/Generic) */
            LPPhoneNumberText(
                modifier = Modifier.padding(
                    top = eSdp10
                ),
                value = numberValue,
                onPhoneChange = {
                    numberValue = it
                }
            )
            /*LpOutlinedTextFieldNumber(
                modifier = Modifier.padding(
                    top = eSdp10
                ),
                label = stringResource(id = R.string.label_ContactPhone),
                hint = stringResource(id = R.string.hint_ContactPhone),
                onValueChange = {}
            )*/
            DropdownTextField(
                modifier = Modifier.padding(
                    top = eSdp10
                ),
                title = stringResource(id = R.string.label_PetInUnit),
                items = arrayPetInUnit.toList(),
                selected = {}
            )
            Text(
                text = stringResource(id = R.string.text_Service),
                modifier = Modifier.padding(
                    top = eSdp10
                ),
                style = LPTypography.bodyLarge
            )
            DropdownTextField(
                modifier = Modifier.padding(
                    top = eSdp06
                ),
                title = stringResource(id = R.string.label_Category),
                items = arrayCategory.toList(),
                selected = {}
            )
            LpOutlinedTextFieldMail(
                modifier = Modifier
                    .padding(
                        top = eSdp10
                    )
                    .height(height = eSdp104)
                    .fillMaxWidth(),
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
            LpRadioGroup(
                modifier = Modifier.padding(
                    start = eSdp10,
                    top = eSdp10
                ),
                options = arrayRadioButtons.toList(),
                selectedOption = selectedOptionRadioButtons,
                onOptionSelected = {
                    selectedOptionRadioButtons = it
                }
            )
        }
    }
}
