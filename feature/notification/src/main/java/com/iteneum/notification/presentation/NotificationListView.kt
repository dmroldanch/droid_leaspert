package com.iteneum.notification.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.iteneum.designsystem.theme.LeasePertTheme
import com.iteneum.notification.R
import com.iteneum.notification.domain.models.NotificationDomain

@Composable
fun NotificationListView() {
    NotificationListContent()
}

/**
 * [NotificationListContent] is a Content that show the list of notifications
 *
 * @author Daniel Roldan
 */

@Composable
fun NotificationListContent() {

    val todayNotificationList = listOf<NotificationDomain>(
        NotificationDomain(
            "Now",
            "Apartment payment received thank you!"
        ), NotificationDomain("6 hrs ago", "Don't forget your event Tomorrow!")
    )
    val thisWeekNotificationList = listOf<NotificationDomain>(
        NotificationDomain(
            "3 days ago",
            "Service request complete enjoy your space."
        ), NotificationDomain("5 days ago", "January payment available please make your payment.")
    )

    val dp16 = LeasePertTheme.sizes.smallSize
    val dp8 = LeasePertTheme.sizes.smallerSize

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(dp16)
    ) {

        Text(
            text = stringResource(id = R.string.notification_header),
            style = MaterialTheme.typography.titleLarge,
        )

        LazyColumn() {
            item {
                Text(
                    text = stringResource(id = R.string.notification_today),
                    modifier = Modifier.padding(top = dp16, bottom = dp16),
                    color = MaterialTheme.colorScheme.tertiary,
                    fontWeight = FontWeight.Medium,
                    fontSize = MaterialTheme.typography.titleMedium.fontSize
                )
            }
            items(todayNotificationList) { notification ->
                Column {
                    Text(
                        text = notification.date,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        fontSize = MaterialTheme.typography.titleSmall.fontSize
                    )
                    Text(
                        text = notification.body,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        fontWeight = FontWeight.Bold,
                        fontSize = MaterialTheme.typography.bodyLarge.fontSize
                    )
                    Divider(
                        Modifier
                            .fillMaxSize()
                            .padding(all = dp8)
                    )
                }
            }
            item {
                Text(
                    text = stringResource(id = R.string.notification_this_week),
                    modifier = Modifier.padding(top = dp16, bottom = dp16),
                    color = MaterialTheme.colorScheme.tertiary,
                    fontWeight = FontWeight.Medium,
                    fontSize = MaterialTheme.typography.titleMedium.fontSize
                )
            }
            items(thisWeekNotificationList) { notification ->
                Column(
                ) {
                    Text(
                        text = notification.date,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        fontSize = MaterialTheme.typography.titleSmall.fontSize
                    )
                    Text(
                        text = notification.body,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        fontWeight = FontWeight.Bold,
                        fontSize = MaterialTheme.typography.bodyLarge.fontSize
                    )
                    Divider(
                        Modifier
                            .fillMaxSize()
                            .padding(all = dp8)
                    )
                }
            }
        }
    }
}