package com.iteneum.apartment.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import com.iteneum.apartment.R
import com.iteneum.apartment.domain.UserDetail
import com.iteneum.designsystem.components.LPTitleLarge
import com.iteneum.designsystem.components.LpGenericChip
import com.iteneum.designsystem.components.LpOutlinedButton
import com.iteneum.designsystem.components.LpPaymentsRentCard
import com.iteneum.designsystem.theme.LeasePertTheme

/**
 * [ApartmentView] The apartment view is the main function, container and screen where all the sections of the view it be contained like:
 * payments, repairs, information, in resume this be the main container for the apartment view
 *
 * @created Usiel Garcia
 * @modifiedBy Juan Islas
 */
@Composable
fun ApartmentView(
    navigateToRepair : () -> Unit,
    viewModel: ApartmentViewModel = hiltViewModel()
) {
    LaunchedEffect(true){
        viewModel.getInformation()
    }

    ApartmentContainer(
        navigateToRepair = { navigateToRepair() },
        userData = viewModel.userData
    )
}

/**
 * [ApartmentContainer] This section is where all the sections are, because all the sections are divided each one
 * in this container it's defined the paddings, the vertical scroll and the configurations of how is the view shown to the user
 *
 * @created Usiel Garcia
 * @modifiedBy Juan Islas
 * */
@Composable
fun ApartmentContainer(
    navigateToRepair : () -> Unit,
    userData: UserDetail
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                start = LeasePertTheme.sizes.midSmallSize,
                end = LeasePertTheme.sizes.midSmallSize
            )
            .verticalScroll(state = rememberScrollState())
    ) {
        Column {
            TitleApartmentScreen()
            userData.paymentDetails?.currentMonth?.let {monthValue ->
                userData.paymentDetails.deadline?.let { deadlineValue ->
                    PaymentsSection(
                        modifier = Modifier,
                        month = monthValue,
                        quantityToPay = userData.paymentDetails.rentDebt.toString(),
                        limitDateToPay = deadlineValue
                    )
                }
            }
            RepairsSection(
                navigateToRepair ={ navigateToRepair() },
                userData = userData
            )
            InformationSection()
        }
    }
}

/**
 * [TitleApartmentScreen] This section is where only to be the tittle of the screen, in this case: "Apartment"
 * this title it shown in the left-top of the screen
 */
@Composable
fun TitleApartmentScreen() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                bottom = LeasePertTheme.sizes.extraSize18,
                top = LeasePertTheme.sizes.minorRegularSize
            )
    ) {
        LPTitleLarge(
            label = stringResource(
                id = R.string.text_title_apartment
            ),
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            weight = FontWeight.Bold
        )
    }
}

/**
 * [PaymentsSection] All the params for this sections is for show the current status, date, month and their account,
 * in this section the user can their account
 * [modifier] Modifier is for specify style and params of the card, like for example the width of the component.
 * [month] is the current month what the user can watch in this section
 * [quantityToPay] is the quantity of the account what the user must to pay
 * [limitDateToPay] is the limit date what the user have to pay their account
 * */
@Composable
fun PaymentsSection(
    modifier: Modifier,
    month: String,
    quantityToPay: String,
    limitDateToPay: String
) {
    Column {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = LeasePertTheme.sizes.regularSize),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(id = R.string.text_title_section_payments),
                color = MaterialTheme.colorScheme.tertiary,
                fontSize = MaterialTheme.typography.titleSmall.lineHeight,
                fontWeight = FontWeight.Medium
            )
            LpGenericChip(label = stringResource(id = R.string.text_button_history)) {
                /*TODO with this button could pay their rent payment*/
            }
        }
        LpPaymentsRentCard(
            modifier = Modifier.fillMaxWidth(),
            currentMonth  = month,
            quantityToPay = quantityToPay,
            limitDateToPay = limitDateToPay
        ){
            /*TODO add the functionality to this onclick*/
        }
    }
}

/**
 * [RepairsSection] is the section where the status of the repairs it shows to the user like Open, In progress and Closed
 * in this section the user have a button where the user could make a new repairs requests
 *
 * @created Usiel Garcia
 * @modifiedBy Juan Islas
 * */
@Composable
fun RepairsSection(
    navigateToRepair : () -> Unit,
    userData: UserDetail
) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = LeasePertTheme.sizes.regularSize,
                    bottom = LeasePertTheme.sizes.minorRegularSize
                ),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(id = R.string.text_title_section_repairs),
                color = MaterialTheme.colorScheme.tertiary,
                fontSize = MaterialTheme.typography.titleSmall.lineHeight
            )
            LpGenericChip(
                icon = Icons.Filled.Add,
                label = stringResource(id = R.string.text_button_new),
                onClicked = { navigateToRepair.invoke() }

            )
        }
        RepairStatusRow(
            modifier = Modifier.fillMaxWidth(),
            titleStatusRepairs = stringResource(id = R.string.text_status_open),
            quantityStatusRepairs = userData.openRepairs
        )
        Divider(
            thickness = LeasePertTheme.sizes.stroke,
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.padding(
                start = LeasePertTheme.sizes.middleSize,
                end = LeasePertTheme.sizes.middleSize
            )
        )
        RepairStatusRow(
            modifier = Modifier.fillMaxWidth(),
            titleStatusRepairs = stringResource(id = R.string.text_status_in_progress),
            quantityStatusRepairs = userData.inProgress
        )
        Divider(
            thickness = LeasePertTheme.sizes.stroke,
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.padding(
                start = LeasePertTheme.sizes.middleSize,
                end = LeasePertTheme.sizes.middleSize
            )
        )
        RepairStatusRow(
            modifier = Modifier.fillMaxWidth(),
            titleStatusRepairs = stringResource(id = R.string.text_status_closed),
            quantityStatusRepairs = userData.closedRepairs
        )
    }
}

/**
 * [RepairStatusRow] is only the design of each row of the status repairs show in [RepairsSection]
 * [modifier] Modifier is for specify style and params of the card, like for example the width of the component.
 * [titleStatusRepairs] is the title what show the row, for example "Closed"
 * [quantityStatusRepairs] is the quantity of the kind of status what the user have it, for example the user can have opened 3 Closed,
 * 4 In progress etc.
 * */
@Composable
fun RepairStatusRow(
    modifier: Modifier = Modifier,
    titleStatusRepairs: String,
    quantityStatusRepairs: Int = 0
) {
    Row(
        modifier = modifier
            .padding(
                start = LeasePertTheme.sizes.minorRegularSize,
                end = LeasePertTheme.sizes.minorRegularSize
            ), horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            modifier = Modifier.padding(
                top = LeasePertTheme.sizes.smallSize,
                bottom = LeasePertTheme.sizes.extraSize18
            ),
            text = titleStatusRepairs,
            style = MaterialTheme.typography.bodyLarge
        )
        Box(
            modifier = Modifier
                .padding(
                    bottom = LeasePertTheme.sizes.smallerSize,
                    top = LeasePertTheme.sizes.extraSize10
                )
                .size(LeasePertTheme.sizes.largeSize)
                .clip(MaterialTheme.shapes.extraLarge)
                .background(color = MaterialTheme.colorScheme.secondaryContainer),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = quantityStatusRepairs.toString(),
                color = MaterialTheme.colorScheme.onTertiary,
                fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                fontWeight = MaterialTheme.typography.titleSmall.fontWeight
            )
        }
    }
}

/**
 * [InformationSection] in this section the user can three buttons for to do different actions
 * the first button is for the user can watch which documents do he needs for rent some apartment
 * the second button is for what the user can watch the photos of the apartment
 * the third is for watch the status of the apartment, for example if the apartment is available for rent
 * */
@Composable
fun InformationSection() {
    Column(modifier = Modifier.padding(top = LeasePertTheme.sizes.midSmallSize)) {
        Text(
            text = stringResource(id = R.string.text_title_information),
            color = MaterialTheme.colorScheme.tertiary,
            fontSize = MaterialTheme.typography.titleSmall.lineHeight
        )
        LpOutlinedButton(
            modifier = Modifier.padding(top = LeasePertTheme.sizes.midMediumSize),
            textButton = stringResource(id = R.string.leasing_documents)
        ) {
            /*TODO with this button the user can watch what documents do need for can rent one apartment*/
        }
        LpOutlinedButton(
            modifier = Modifier.padding(top = LeasePertTheme.sizes.midMediumSize),
            textButton = stringResource(id = R.string.apartment_photos)
        ) {
            /*TODO with this button the user can watch the photos of the apartments*/
        }
        LpOutlinedButton(
            modifier = Modifier.padding(top = LeasePertTheme.sizes.midMediumSize),
            textButton = stringResource(id = R.string.current_status)
        ) {
            /*TODO with this button the user can watch what is the status of the apartment*/
        }
    }
}