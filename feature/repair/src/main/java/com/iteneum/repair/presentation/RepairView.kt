package com.iteneum.repair.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.iteneum.repair.RepairRequest
import com.iteneum.repair.UIEventRepair
import com.iteneum.designsystem.components.*
import com.iteneum.designsystem.theme.LPTypography
import com.iteneum.designsystem.theme.LeasePertTheme
import com.iteneum.repair.R
import com.iteneum.repair.data.RepairViewModel

/**
 * Function that creates [RepairView] compose, for user's service request.
 * User will require to fill all the correspondent fields on the screen.
 * @param navigateToApartment - to get the function to navigate ApartmentView when clicking the button
 * @param repairViewModel - to get the Repair View Model access
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
        formularyValues = repairViewModel.repairRequest,
        formularyData = {
            repairViewModel.setValues(it)
        },
        mimeTypes = repairViewModel.mimeTypes,
        validatePhone = { repairViewModel.validatePhone(phone = it) },
        onClickButton = { repairViewModel.onClickSendButton() },
        navigateToApartment = navigateToApartment
    )
}

/**
 * Function [RepairContainer] contains the actual view of RepairView.
 * It will generate the composable elements to create the form for the user repair petitions.
 * @param formularyValues - to pass the content of the RepairRequest
 * @param formularyData - to handle the UI events of data when text is modified
 * @param validatePhone - to validate phone value contains at least 10 digits and only numbers
 * @param onClickButton - to handle the action when "Send" button is clicked
 * @param navigateToApartment - passed from RepairView to handle navigation
 *
 * @author Jose Miguel Garcia Reyes
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RepairContainer(
    formularyValues: RepairRequest,
    formularyData: (UIEventRepair) -> Unit,
    mimeTypes: Array<String>,
    validatePhone: (it: String) -> Boolean,
    onClickButton: () -> Unit,
    navigateToApartment: () -> Unit
) {
    val sizes = LeasePertTheme.sizes
    val optionsPermissionRadioButtons = stringArrayResource(id = R.array.options_radio_button)
    val optionsPetInUnit = stringArrayResource(id = R.array.options_pet_in_unit)
    val optionsCategory = stringArrayResource(id = R.array.options_category)
    var isNotValidPhone by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .padding(
                start = sizes.regularSize,
                top = sizes.minorRegularSize,
                end = sizes.regularSize
            )
            .verticalScroll(state = rememberScrollState())
    ) {
        Row {
            /* TODO - Arrow Back Navigation - Add "arrow" navigation component here when available */
            Text(
                text = stringResource(R.string.text_repair_view_title),
                modifier = Modifier
                    .padding(
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
            value = formularyValues.unitDepartment,
            onValueChanged = {
                formularyData(UIEventRepair.UnitDepartment(unitDepartment = it))
            }
        )
        LPPhoneNumberText(
            modifier = Modifier
                .padding(
                    top = sizes.extraSize14
                ),
            value = formularyValues.contactPhone,
            onPhoneChanged = {
                isNotValidPhone = validatePhone(it)
                formularyData(UIEventRepair.ContactPhone(contactPhone = it))
            },
            isNotValid = isNotValidPhone,
            supportTextError = stringResource(id = R.string.support_error_phone)
        )
        DropdownTextField(
            modifier = Modifier
                .padding(
                    top = sizes.extraSize14
                ),
            title = stringResource(id = R.string.label_pet_in_unit),
            items = optionsPetInUnit.toList(),
            value = formularyValues.petInUnit,
            selected = {
                formularyData(UIEventRepair.PetInUnit(petInUnit = it))
            }
        )
        Text(
            text = stringResource(id = R.string.text_service),
            modifier = Modifier
                .padding(
                    top = sizes.extraSize14
                ),
            style = LPTypography.bodyLarge
        )
        DropdownTextField(
            modifier = Modifier
                .padding(
                    top = sizes.extraSize6
                ),
            title = stringResource(id = R.string.label_category),
            items = optionsCategory.toList(),
            value = formularyValues.category,
            selected = {
                formularyData(UIEventRepair.Category(category = it))
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
            value = formularyValues.problemDescription,
            onValueChanged = {
                formularyData(UIEventRepair.ProblemDescription(problemDescription = it))
            }
        )
        Text(
            text = stringResource(id = R.string.text_video_button),
            modifier = Modifier
                .padding(
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
            mimeTypes = mimeTypes, /* TODO - Verify how will this work */
            onFileSelected = {
                formularyData(UIEventRepair.ImageOrVideoFile(imageOrVideoFile = it.toString()))
            }
        )
        Text(
            text = stringResource(id = R.string.text_permission),
            modifier = Modifier
                .padding(
                    top = sizes.smallSize
                ),
            style = LPTypography.bodyLarge
        )
        LpRadioGroup(
            modifier = Modifier
                .padding(
                    start = sizes.extraSize6,
                    top = sizes.extraSize10
                ),
            options = optionsPermissionRadioButtons.toList(),
            selectedOption = formularyValues.permissionToEnter,
            onOptionSelected = {
                formularyData(UIEventRepair.PermissionToEnter(permissionToEnter = it))
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
                onClickButton()
                navigateToApartment()
            }
        )
    }
}