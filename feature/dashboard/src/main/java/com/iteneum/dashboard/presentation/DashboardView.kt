package com.iteneum.dashboard.presentation


import android.util.Log
import androidx.compose.foundation.background
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
import androidx.compose.ui.unit.dp
import com.iteneum.dashboard.R
import com.iteneum.designsystem.components.LPGenericElevatedCard
import com.iteneum.designsystem.components.LpBadgeButton
import com.iteneum.designsystem.components.LpGenericCard
import com.iteneum.designsystem.theme.Drab
import com.iteneum.designsystem.theme.LPTypography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardView() {
    val username = "Martin"
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .weight(1f),
                text = stringResource(R.string.welcome, username),
                style = LPTypography.titleSmall
            )
            LpBadgeButton(
                Modifier,
                badgeNumber = "10",
                showBadge = true,
                Icons.Filled.Notifications
            ) {
                Log.e("tag", "notification")
            }
            LpBadgeButton(
                Modifier,
                badgeNumber = "25",
                showBadge = true,
                Icons.Filled.Person
            ) {
                Log.e("tag", "person")
            }
        }

        Spacer(modifier = Modifier.height(20.dp))
        LpGenericCard(
            title = "Current balance",
            details ="Go to payments",
            accountNumber ="0.00",
            currency = true
        ) {
            Log.e("tag","Go to payments")
        }
        LpGenericCard(
            title = "Service requests in progress",
            details ="View detail",
            accountNumber ="0",
        ) {
            Log.e("tag","V1")
        }
        LpGenericCard(
            title = "Amenity reservations",
            details ="View details",
            accountNumber ="1"
        ) {
            Log.e("tag","V2")
        }
        Spacer(modifier = Modifier.height(25.dp))

        Text(
            text = "Happening Today",
            style = LPTypography.labelLarge,
            color = MaterialTheme.colorScheme.tertiary
        )

        val items = listOf("Coffee + Donuts", "Pool party", "Discounts")
        LazyRow(
            verticalAlignment = Alignment.CenterVertically
        ) {
            items(items) { item ->
                LPGenericElevatedCard(
                    title = item,
                    description = "This is mock data",
                    buttonText = "Go to Screen",
                ) {
                    Log.e("tag", "This is a mock click")
                }
            }
        }
    }
}