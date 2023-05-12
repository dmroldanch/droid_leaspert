package com.iteneum.apartment.presentation

import androidx.compose.foundation.*
import com.iteneum.designsystem.theme.LeasePertTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.iteneum.apartment.R
import com.iteneum.designsystem.components.LPTitleLarge
import com.iteneum.designsystem.components.LpGenericChip
import com.iteneum.designsystem.components.LpOutlinedButton
import com.iteneum.designsystem.components.LpPaymentsRentCard
import java.sql.Timestamp

/**
 * [ApartmentView] The apartment view is the main function, container and screen where all the sections of the view it be contained like:
 * payments, repairs, information, in resume this be the main container for the apartment view
 */
@Composable
fun ApartmentView(navigateToRepair : () -> Unit) {
    ApartmentContainer { navigateToRepair() }
}

/**
 * [ApartmentContainer] This section is where all the sections are, because all the sections are divided each one
 * in this container it's defined the paddings, the vertical scroll and the configurations of how is the view shown to the user
 * */
@Composable
fun ApartmentContainer(navigateToRepair : () -> Unit) {
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
            PaymentsSection(Modifier, "Junary", "990.00", "Jan 23 2022")
            RepairsSection { navigateToRepair.invoke() }
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
            color = MaterialTheme.colorScheme.onPrimaryContainer
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
    Column() {
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
 * */
@Composable
fun RepairsSection(navigateToRepair : () -> Unit) {
    Column() {
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
                label = "${stringResource(id = R.string.text_button_new)}",
                onClicked = { navigateToRepair.invoke() }

            )
        }
        RepairStatusRow(
            modifier = Modifier.fillMaxWidth(),
            titleStatusRepairs = stringResource(id = R.string.text_status_open)
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
            titleStatusRepairs = stringResource(id = R.string.text_status_in_progress)
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
            titleStatusRepairs = stringResource(id = R.string.text_status_closed)
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
 * the first button is for the user can watch wich documents do he needs for rent some apartment
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