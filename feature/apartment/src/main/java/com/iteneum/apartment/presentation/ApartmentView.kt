package com.iteneum.apartment.presentation

import androidx.compose.foundation.*
import com.iteneum.designsystem.theme.LeasePertTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.iteneum.apartment.R
import com.iteneum.designsystem.components.LPTitleLarge
import com.iteneum.designsystem.components.LpGenericChip
import com.iteneum.designsystem.components.LpOutlinedButton
import com.iteneum.designsystem.components.LpPaymentsRentCard
import java.sql.Timestamp

/**
 * [ApartmentView] The apartment view is the screen where the user watches your payments, repairs, information
 * [ApartmentContainer] This section is where all the sections are, because all the sections are divided each one
 * [TitleApartmentScreen] This section is where only to be the tittle of the screen, in this case: "Apartment"
 * [PaymentsSection] All the params for this sections is for show the current status, date, month and their account,
 * in this section the user can their account
 * [RepairsSection] and [RepairStatusRow], work together for show and open a new repairs application with the button,
 * the user can watch the Open, In Progress and closed repairs status
 * [InformationSection] is where the user have a their disposable some buttons for leasing documents, apartment photos and current status
 *
 * @author Usiel Filiberto Garcia Jimenez
 */
@Composable
@Preview
fun ApartmentView() {
    ApartmentContainer()
}

@Composable
fun ApartmentContainer() {
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
            PaymentsSection(Modifier, "Junary", 990.00, Timestamp(23435))
            RepairsSection()
            InformationSection()
        }
    }
}

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
                id = R.string.apartment
            ),
            color = MaterialTheme.colorScheme.onPrimaryContainer
        )
    }
}

@Composable
fun PaymentsSection(modifier: Modifier, month: String, quantityToPay: Double, date: Timestamp) {
    Column() {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = LeasePertTheme.sizes.regularSize),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(id = R.string.payments),
                color = MaterialTheme.colorScheme.tertiary,
                fontSize = MaterialTheme.typography.titleSmall.lineHeight
            )
            LpGenericChip(label = stringResource(id = R.string.history)) {
                /*TODO with this button could pay their rent payment*/
            }
        }
        LpPaymentsRentCard(
            modifier = Modifier.fillMaxWidth(),
            month = month,
            quantity = quantityToPay,
            date = date
        )
    }
}

@Composable
fun RepairsSection() {
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
                text = stringResource(id = R.string.repairs),
                color = MaterialTheme.colorScheme.tertiary,
                fontSize = MaterialTheme.typography.titleSmall.lineHeight
            )
            LpGenericChip(label = "+${stringResource(id = R.string.newA)}") {
                /*TODO with this button the user could make a repair request for him department*/
            }
        }
        RepairStatusRow(
            modifier = Modifier.fillMaxWidth(),
            titleStatusRepairs = stringResource(id = R.string.open)
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
            titleStatusRepairs = stringResource(id = R.string.in_progress)
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
            titleStatusRepairs = stringResource(id = R.string.closed)
        )
    }
}

@Composable
fun RepairStatusRow(
    modifier: Modifier = Modifier,
    titleStatusRepairs: String,
    quantityStatusRepairs: Int = 0,
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
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
    }
}

@Composable
fun InformationSection() {
    Column(modifier = Modifier.padding(top = LeasePertTheme.sizes.midSmallSize)) {
        Text(
            text = stringResource(id = R.string.information),
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