package com.iteneum.repair.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.core.text.isDigitsOnly
import com.iteneum.designsystem.components.*
import com.iteneum.designsystem.theme.LPTypography
import com.iteneum.designsystem.theme.LeasePertTheme
import com.iteneum.repair.R

/**
 * Function that creates [RepairView] compose. for user's service request.
 * User will require to fill all the correspondent fields on the screen.
 *
 * @author Jose Miguel Garcia Reyes
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RepairView() {
    val sizes = LeasePertTheme.sizes
    val optionsPermissionRadioButtons = stringArrayResource(id = R.array.options_radio_button)
    val optionsPetInUnit = stringArrayResource(id = R.array.options_pet_in_unit)
    val optionsCategory = stringArrayResource(id = R.array.options_category)
    var isNotValidPhone by remember {
        mutableStateOf(false)
    }
    var optionSelectedRadioButtons by remember {
        mutableStateOf(optionsPermissionRadioButtons[0])
    }
    var contactPhoneNumberValue by remember {
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
                /* TODO - Arrow Back Navigation - Add "arrow" navigation component here when available */
                Text(
                    text = stringResource(R.string.text_repair_view_title),
                    modifier = Modifier.padding(
                        all = sizes.extraSize6
                    ),
                    style = LPTypography.headlineSmall
                )
            }
            LpOutlinedTextFieldInput(
                modifier = Modifier
                    .padding(
                        top = sizes.minorRegularSize
                    )
                    .fillMaxWidth(),
                enabled = false,
                label = stringResource(id = R.string.label_unit),
                hint = stringResource(id = R.string.hint_unit),
                onValueChanged = {/* TODO - Unit Text field - To verify if extra functionality required */ }
            )
            LPPhoneNumberText(
                modifier = Modifier.padding(
                    top = sizes.extraSize14
                ),
                value = contactPhoneNumberValue,
                onPhoneChanged = {
                    isNotValidPhone = it.isEmpty() || it.length < 10
                    if (it.isDigitsOnly() && it.length <= 10)
                        contactPhoneNumberValue = it
                },
                isNotValid = isNotValidPhone,
                supportTextError = stringResource(id = R.string.support_error_phone)
            )
            DropdownTextField(
                modifier = Modifier.padding(
                    top = sizes.extraSize14
                ),
                title = stringResource(id = R.string.label_pet_in_unit),
                items = optionsPetInUnit.toList(),
                selected = {/* TODO - PetInUnit field - To verify if extra functionality required */ }
            )
            Text(
                text = stringResource(id = R.string.text_service),
                modifier = Modifier.padding(
                    top = sizes.extraSize14
                ),
                style = LPTypography.bodyLarge
            )
            DropdownTextField(
                modifier = Modifier.padding(
                    top = sizes.extraSize6
                ),
                title = stringResource(id = R.string.label_category),
                items = optionsCategory.toList(),
                selected = {/* TODO - Category field - To verify if extra functionality required */ }
            )
            LpOutlinedTextFieldInput(
                modifier = Modifier
                    .padding(
                        top = sizes.extraSize14
                    )
                    .height(height = sizes.extraSize104)
                    .fillMaxWidth(),
                label = stringResource(id = R.string.label_description),
                hint = stringResource(id = R.string.hint_description),
                onValueChanged = {/* TODO - Description field - To verify if extra functionality required */ }
            )
            Text(
                text = stringResource(id = R.string.text_video_button),
                modifier = Modifier.padding(
                    top = sizes.extraSize14
                ),
                style = LPTypography.bodyLarge
            )
            LpFileButton(
                modifier = Modifier
                    .padding(
                        top = sizes.extraSize10
                    )
                    .fillMaxWidth(),
                mimeTypes = arrayOf("video/*", "image/*"),
                onFileSelected = {/* TODO - File Button - Add functionality to save files */ }
            )
            Text(
                text = stringResource(id = R.string.text_permission),
                modifier = Modifier.padding(
                    top = sizes.smallSize
                ),
                style = LPTypography.bodyLarge
            )
            LpRadioGroup(
                modifier = Modifier.padding(
                    start = sizes.extraSize6,
                    top = sizes.extraSize10
                ),
                options = optionsPermissionRadioButtons.toList(),
                selectedOption = optionSelectedRadioButtons,
                onOptionSelected = {
                    optionSelectedRadioButtons = it
                }
            )
            LpFilledTonalButton(
                modifier = Modifier
                    .padding(
                        top = sizes.middleSize,
                        bottom = sizes.middleSize
                    )
                    .fillMaxWidth(),
                textButton = stringResource(id = R.string.text_repair_send_button),
                onClicked = {/* TODO - Send Repair Button - Add functionality to save repair request info */ }
            )
        }
    }
}
