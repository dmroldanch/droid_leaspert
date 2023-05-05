package com.iteneum.repair.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.core.text.isDigitsOnly
import androidx.hilt.navigation.compose.hiltViewModel
import com.iteneum.RepairModel
import com.iteneum.designsystem.components.*
import com.iteneum.designsystem.theme.LPTypography
import com.iteneum.designsystem.theme.LeasePertTheme
import com.iteneum.repair.R
import com.iteneum.repair.data.RepairViewModel

/**
 * Function that creates [RepairView] compose. for user's service request.
 * User will require to fill all the correspondent fields on the screen.
 *
 * Function [RepairView] has
 * @param navigateToApartment - to get the function to navigate ApartmentView when clicking button
 * @param repairViewModel - to get the Repair View Model access
 *
 * Function [RepairContainer] has
 * @param dataInfo - to use if for displaying Unit in the Unit Text Field
 * @param repairViewModel -  to get the Repair View Model access
 * @param navigateToApartment - its passed from RepairView() for same purpose
 *
 * @author Jose Miguel Garcia Reyes
 */

@Composable
fun RepairView(
    navigateToApartment: () -> Unit,
    repairViewModel: RepairViewModel = hiltViewModel()
) {
    LaunchedEffect(true) {
        repairViewModel.getInformation()
    }
    RepairContainer(
        dataInfo = repairViewModel.dataInfo.value,
        navigateToApartment = navigateToApartment
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RepairContainer(
    dataInfo: RepairModel?,
    repairViewModel: RepairViewModel = hiltViewModel(),
    navigateToApartment: () -> Unit,
) {
    val sizes = LeasePertTheme.sizes
    val optionsPermissionRadioButtons = stringArrayResource(id = R.array.options_radio_button)
    val optionsPetInUnit = stringArrayResource(id = R.array.options_pet_in_unit)
    val optionsCategory = stringArrayResource(id = R.array.options_category)
    var isNotValidPhone by remember {
        mutableStateOf(false)
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
                /* TODO - LpOutlinedTextFieldInput (Check component required) - To enable to action  of passing value argument --> value = dataInfo?.unitDepartment ?: "000" */
                modifier = Modifier
                    .padding(
                        top = sizes.minorRegularSize
                    )
                    .fillMaxWidth(),
                enabled = false,
                label = stringResource(id = R.string.label_unit),
                hint = stringResource(id = R.string.hint_unit),
                onValueChanged = {
                    repairViewModel.getUnitDepartmentFromView(it)
                }
            )
            LPPhoneNumberText(
                modifier = Modifier.padding(
                    top = sizes.extraSize14
                ),
                value = repairViewModel.repairModel.contactPhone,
                onPhoneChanged = {
                    isNotValidPhone = it.isEmpty() || it.length < 10
                    if (it.isDigitsOnly() && it.length <= 10)
                        repairViewModel.getContactPhoneFromView(it)
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
                selected = {
                    repairViewModel.getPetInUnitFromView(it)
                }
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
                selected = {
                    repairViewModel.getCategoryFromView(it)
                }
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
                onValueChanged = {
                    repairViewModel.getProblemDescriptionFromView(it)
                }
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
                onFileSelected = {
                    repairViewModel.getImageOrVideoFileFromView(it)
                }
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
                selectedOption = repairViewModel.repairModel.permissionToEnter,
                onOptionSelected = {
                    repairViewModel.getPermissionToEnterFromView(it)
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
                onClicked = {
                    repairViewModel.onClickSendButton()
                    navigateToApartment()
                }
            )
        }
    }
}