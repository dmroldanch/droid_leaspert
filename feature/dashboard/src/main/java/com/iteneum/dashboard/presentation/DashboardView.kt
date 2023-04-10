package com.iteneum.dashboard.presentation


import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.iteneum.designsystem.components.BadgeButton
import com.iteneum.designsystem.components.LPGenericElevatedCard
import com.iteneum.designsystem.theme.AtomicTangerine
import com.iteneum.designsystem.theme.Drab
import com.iteneum.designsystem.theme.JuneBud
import com.iteneum.designsystem.theme.LPTypography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardView() {
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
                text = "Welcome back, Jose!",
                style = LPTypography.titleSmall
            )
            BadgeButton(
                Modifier,
                {},
                100
            )
            BadgeButton(
                Modifier,
                {},
                100
            )

        }

        Spacer(modifier = Modifier.height(20.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .background(MaterialTheme.colorScheme.primary)
        ) { }
        Spacer(modifier = Modifier.height(25.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .background(MaterialTheme.colorScheme.primary)
        ) { }
        Spacer(modifier = Modifier.height(25.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .background(MaterialTheme.colorScheme.primary)
        ) { }
        Spacer(modifier = Modifier.height(25.dp))

        Text(
            text = "Happening Today",
            style = LPTypography.labelLarge,
            color = MaterialTheme.colorScheme.tertiary
        )

        val items = listOf("Coffe + Donuts", "Pool party", "Discounts")
        LazyRow(
            verticalAlignment = Alignment.CenterVertically
        ) {
            items(items) { item ->
                LPGenericElevatedCard(
                    title = item,
                    description = "This is mock data",
                    buttonText = "Go to Screen",
                    //color = Drab
                ) {
                    Log.e("tag", "This is a mock click")
                }
            }
        }
    }
}