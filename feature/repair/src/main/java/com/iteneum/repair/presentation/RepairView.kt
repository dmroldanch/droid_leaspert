package com.iteneum.repair.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import com.iteneum.designsystem.components.*
import com.iteneum.designsystem.theme.LPTypography
import com.iteneum.designsystem.theme.LeasePertTheme
import com.iteneum.repair.R

/**
 * Function that creates [RepairView] compose. for user's service request
 * LpOutlinedTextFieldMail A --> Client's department
 * LPPhoneNumberText         --> Client's phone number
 * DropdownTextField A       --> If client has a pet will be indicated here
 * DropdownTextField B       --> Category of the client's problem
 * LpOutlinedTextFieldMail B --> Client's problem description
 * LpFileButton              --> Client's proof of repair problem
 * LpRadioGroup              --> Client's permission approval
 * @author Jose Miguel Garcia Reyes
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RepairView() {
    val sizes = LeasePertTheme.sizes
    val optionsPermissionRadioButtons = stringArrayResource(id = R.array.options_radio_button)
    val optionsPetInUnit = stringArrayResource(id = R.array.options_pet_in_unit)
    val optionsCategory = stringArrayResource(id = R.array.options_category)
    var isValidDescription by remember {
        mutableStateOf(false)
    }
    var optionSelectedRadioButtons by remember {
        mutableStateOf(optionsPermissionRadioButtons[0])
    }
    var numberValue by remember {
        mutableStateOf("")
    }
    LeasePertTheme {
        Column(
            modifier = Modifier.padding(
                start = sizes.regularSize,
                top = sizes.minorRegularSize,
                end = sizes.regularSize
            )
        ) {
            Row {
                /* TODO - Add "arrow" navigation component when available */
                Text(
                    text = stringResource(R.string.text_title),
                    modifier = Modifier.padding(
                        all = sizes.extraSize6
                    ),
                    style = LPTypography.headlineSmall
                )
            }
            LpOutlinedTextFieldMail(
                modifier = Modifier
                    .padding(
                        top = sizes.minorRegularSize
                    )
                    .fillMaxWidth(),
                label = stringResource(id = R.string.label_unit),
                hint = stringResource(id = R.string.hint_unit),
                isValid = false,
                supportTextError = stringResource(id = R.string.support_error_unit),
                onValueChange = {}
            )/* TODO - Unit Text field - Change the component when available (Disable/Generic) */
            LPPhoneNumberText(
                modifier = Modifier.padding(
                    top = sizes.extraSize10
                ),
                value = numberValue,
                onPhoneChange = {
                    numberValue = it
                }
            )
            DropdownTextField(
                modifier = Modifier.padding(
                    top = sizes.extraSize10
                ),
                title = stringResource(id = R.string.label_pet_in_unit),
                items = optionsPetInUnit.toList(),
                selected = {}
            )
            Text(
                text = stringResource(id = R.string.text_service),
                modifier = Modifier.padding(
                    top = sizes.extraSize10
                ),
                style = LPTypography.bodyLarge
            )
            DropdownTextField(
                modifier = Modifier.padding(
                    top = sizes.extraSize6
                ),
                title = stringResource(id = R.string.label_category),
                items = optionsCategory.toList(),
                selected = {}
            )
            LpOutlinedTextFieldMail(
                modifier = Modifier
                    .padding(
                        top = sizes.extraSize10
                    )
                    .height(height = sizes.extraSize104)
                    .fillMaxWidth(),
                label = stringResource(id = R.string.label_description),
                hint = stringResource(id = R.string.hint_description),
                isValid = isValidDescription,
                supportTextError = stringResource(id = R.string.support_error_description),
                onValueChange = {
                    isValidDescription = it.isEmpty() || it.matches(Regex(".*[a-zA-Z]+.*")).not()
                }
            )
            Text(
                text = stringResource(id = R.string.text_video),
                modifier = Modifier.padding(
                    top = sizes.extraSize10
                ),
                style = LPTypography.bodyLarge
            )
            LpFileButton(
                modifier = Modifier
                    .padding(
                        top = sizes.extraSize6
                    )
                    .fillMaxWidth(),
                mimeTypes = arrayOf("video/*", "image/*"),
                onFileSelected = {}
            )/* TODO - File Button - Add functionality on how its going to work */
            Text(
                text = stringResource(id = R.string.text_permission),
                modifier = Modifier.padding(
                    top = sizes.extraSize10
                ),
                style = LPTypography.bodyLarge
            )
            LpRadioGroup(
                modifier = Modifier.padding(
                    start = sizes.extraSize10,
                    top = sizes.extraSize10
                ),
                options = optionsPermissionRadioButtons.toList(),
                selectedOption = optionSelectedRadioButtons,
                onOptionSelected = {
                    optionSelectedRadioButtons = it
                }
            )
        }
    }
}
