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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import com.iteneum.designsystem.components.LPBodyLarge
import com.iteneum.designsystem.components.LPBodyMedium
import com.iteneum.designsystem.components.LPTitleMedium
import com.iteneum.designsystem.theme.LeasePertTheme
import com.iteneum.notification.R
import com.iteneum.notification.domain.models.Notification

@Composable
fun NotificationListView(
    viewModel: NotificationViewModel = hiltViewModel()
) {
    LaunchedEffect(true){
        viewModel.getNotification()
    }

    NotificationListContent(
        viewModel.todayNotificationList,
        viewModel.weekNotificationList
    )
}

/**
 * [NotificationListContent] is a Content that show the list of notifications
 *
 * @author Daniel Roldan
 */

@Composable
fun NotificationListContent(
    todayNotificationList: List<Notification>,
    thisWeekNotificationList: List<Notification>,
) {
    val sizes = LeasePertTheme.sizes

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(sizes.smallSize)
    ) {

        Text(
            text = stringResource(id = R.string.notification_header),
            style = MaterialTheme.typography.titleLarge,
        )

        LazyColumn() {
            item {
                LPTitleMedium(
                    label = stringResource(id = R.string.notification_this_week),
                    color = MaterialTheme.colorScheme.tertiary,
                    modifier = Modifier.padding(top = sizes.smallSize, bottom = sizes.smallSize),
                    weight = FontWeight.Medium
                )
            }
            items(todayNotificationList) { notification ->
                Column {
                    LPBodyMedium(
                        label = notification.date,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        weight = FontWeight.Medium
                    )
                    LPBodyLarge(
                        label = notification.body,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        weight = FontWeight.Bold
                    )
                    Divider(
                        Modifier
                            .fillMaxSize()
                            .padding(all = sizes.smallerSize)
                    )
                }
            }
            item {
                LPTitleMedium(
                    label = stringResource(id = R.string.notification_this_week),
                    color = MaterialTheme.colorScheme.tertiary,
                    modifier = Modifier.padding(top = sizes.smallSize, bottom = sizes.smallSize),
                    weight = FontWeight.Medium
                )
            }
            items(thisWeekNotificationList) { notification ->
                Column {
                    LPBodyMedium(
                        label = notification.date,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        weight = FontWeight.Medium
                    )
                    LPBodyLarge(
                        label = notification.body,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        weight = FontWeight.Bold
                    )
                    Divider(
                        Modifier
                            .fillMaxSize()
                            .padding(all = sizes.smallerSize)
                    )
                }
            }
        }
    }
}