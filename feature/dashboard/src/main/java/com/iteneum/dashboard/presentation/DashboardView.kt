package com.iteneum.dashboard.presentation


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.iteneum.dashboard.R
import com.iteneum.designsystem.components.LPGenericElevatedCard
import com.iteneum.designsystem.components.LpBadgeButton
import com.iteneum.designsystem.components.LpGenericCard
import com.iteneum.designsystem.components.getRandomColor
import com.iteneum.designsystem.theme.LPTypography
import com.iteneum.designsystem.theme.LeasePertTheme
import kotlin.random.Random


/**
 * [DashboardView] Contains a welcome message follow by 2 icons (notifications and profile).
 * Shows the current balance, the total service and amenities reservations requested.
 * Also at the view bottom show a event list happening in the same day or events that coming soon.
 *
 * @author Jose Rivera
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardView() {
    val sizes = LeasePertTheme.sizes
    // TODO mock data, change for real data
    val username = "Martin"
    val badgeNumberNotification = "10"
    val badgeNumberPerson = "20"
    val showBadgeNotification = true
    val showBadgePerson = false
    val currentBalance = "0.00"
    val currentBalanceCurrency = true
    val serviceRequest = "1"
    val amenityReservations = "1"
    val eventList = listOf("Coffee + Donuts", "Pool party", "Discounts")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = sizes.regularSize)
            .verticalScroll(rememberScrollState())
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .weight(1f),
                text = stringResource(R.string.welcome_back, username),
                style = LPTypography.titleMedium,
            )
            LpBadgeButton(
                badgeNumber = badgeNumberNotification,
                showBadge = showBadgeNotification,
                imageVector = Icons.Filled.Notifications
            ) {
                // TODO add click functionality here
            }
            LpBadgeButton(
                badgeNumber = badgeNumberPerson,
                showBadge = showBadgePerson,
                imageVector = Icons.Filled.Person
            ) {
                // TODO add click functionality here
            }
        }
        LpGenericCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = sizes.minorRegularSize),
            title = stringResource(R.string.current_balance),
            details = stringResource(R.string.go_to_payments),
            accountNumber = currentBalance,
            currency = currentBalanceCurrency
        ) {
            // TODO navigate to payments screen
        }
        LpGenericCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = sizes.minorRegularSize),
            title = stringResource(R.string.service_request),
            details = stringResource(R.string.view_detail),
            accountNumber = serviceRequest,
        ) {
            // TODO navigate to service request screen
        }
        LpGenericCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = sizes.regularSize),
            title = stringResource(R.string.amenity_reservations),
            details = stringResource(R.string.view_detail),
            accountNumber = amenityReservations
        ) {
            // TODO navigate to amenity reservations screen
        }
        Text(
            text = stringResource(R.string.happening_today),
            style = LPTypography.titleMedium,
            color = MaterialTheme.colorScheme.tertiary
        )
        LazyRow(
            verticalAlignment = Alignment.CenterVertically
        ) {
            items(eventList) { event ->
                LPGenericElevatedCard(
                    modifier = Modifier.fillMaxWidth(),
                    title = event,
                    description = "This is mock data",
                    buttonText = "Go to Screen",
                    color = getRandomColor(Random.nextInt(0, 3))
                ) {
                    // TODO add click functionality
                }
            }
        }
    }
}