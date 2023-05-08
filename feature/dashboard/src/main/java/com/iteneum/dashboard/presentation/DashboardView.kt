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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.iteneum.dashboard.R
import com.iteneum.designsystem.components.LPGenericElevatedCard
import com.iteneum.designsystem.components.LpBadgeButton
import com.iteneum.designsystem.components.LpGenericCard
import com.iteneum.designsystem.theme.LPTypography
import com.iteneum.designsystem.theme.LeasePertTheme


/**
 * [DashboardView] Contains a welcome message follow by 2 icons (notifications and profile).
 * Shows the current balance, the total service and amenities reservations requested.
 * Also at the view bottom show a event list happening in the same day or events that coming soon.
 *
 * @author Jose Rivera
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardView(
    navigateToNotification: () -> Unit,
    navigateToProfile: () -> Unit,
    viewModel: DashboardViewModel = hiltViewModel()
) {

    val sizes = LeasePertTheme.sizes
    val userState by remember { viewModel.userDomain }

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
                text = stringResource(R.string.welcome_back, userState.username),
                style = LPTypography.titleMedium,
            )
            LpBadgeButton(
                badgeNumber = userState.notification.notificationCount.toString(),
                showBadge = true,
                imageVector = Icons.Filled.Notifications
            ) {
                navigateToNotification()
            }
            LpBadgeButton(
                imageVector = Icons.Filled.Person
            ) {
                navigateToProfile()
            }
        }
        LpGenericCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = sizes.minorRegularSize),
            title = stringResource(R.string.current_balance),
            details = stringResource(R.string.go_to_payments),
            accountNumber = userState.currentBalance.toString(),
            currency = true
        ) {
            //TODO navigate to payments screen
        }
        LpGenericCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = sizes.minorRegularSize),
            title = stringResource(R.string.service_request),
            details = stringResource(R.string.view_detail),
            accountNumber = userState.serviceRequestInProgress.toString(),
        ) {
            //TODO navigate to service request screen
        }
        LpGenericCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = sizes.regularSize),
            title = stringResource(R.string.amenity_reservations),
            details = stringResource(R.string.view_detail),
            accountNumber = userState.amenityReservetion.toString()
        ) {
            //TODO navigate to amenity reservations screen
        }
        Text(
            modifier = Modifier.padding(bottom = sizes.minorRegularSize),
            text = stringResource(R.string.happening_today),
            style = LPTypography.titleMedium,
            color = MaterialTheme.colorScheme.tertiary
        )
        LazyRow(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(sizes.smallSize)
        ) {
            items(userState.events) { event ->
                LPGenericElevatedCard(
                    modifier = Modifier.fillMaxWidth(),
                    title = event.title,
                    description = event.description,
                    buttonText = event.buttonText,
                    color = event.color
                ) {
                    // TODO add click functionality
                }
            }
        }
    }
}