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
import com.iteneum.designsystem.theme.LeasePertTheme
import com.iteneum.notification.R
import com.iteneum.notification.domain.models.NotificationDomain

/**
 * [NotificationListContent] is a Content that show the list of notifications
 * [viewModel] this property is one instance of the NotificationViewModel, here is where al the information or actions it will be executed
 *
 * @author Daniel Roldan && Usiel Filiberto Garcia Jimenez
 */
@Composable
fun NotificationListView(
    viewModel: NotificationViewModel = hiltViewModel(),
) {
    LaunchedEffect(true) {
        //viewModel.getInformation()
    }
    NotificationListContent(
        listToday = viewModel.dataToday,
        listWeek = viewModel.dataWeek
    )
}

/**
 * [NotificationListContent] is a Content that show the list of notifications
 * [listToday] is a list what comes form the backend form API and brings the notifications from today
 * [listWeek] is a list what comes form the backend form API and brings the notifications from this week
 *
 * @author Daniel Roldan && Usiel Filiberto Garcia Jimenez
 */

@Composable
fun NotificationListContent(
    listToday: List<NotificationDomain>,
    listWeek: List<NotificationDomain>
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(LeasePertTheme.sizes.smallSize)
    ) {
        Text(
            text = stringResource(id = R.string.notification_header),
            style = MaterialTheme.typography.titleLarge,
        )

        LazyColumn {
            item {
                Text(
                    text = stringResource(id = R.string.notification_today),
                    modifier = Modifier.padding(top = LeasePertTheme.sizes.smallSize, bottom = LeasePertTheme.sizes.smallSize),
                    color = MaterialTheme.colorScheme.tertiary,
                    fontWeight = FontWeight.Medium,
                    fontSize = MaterialTheme.typography.titleMedium.fontSize
                )
            }
            items(listToday) { today ->
                Column {
                    Text(
                        text = today.date,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        fontSize = MaterialTheme.typography.titleSmall.fontSize
                    )
                    Text(
                        text = today.body,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        fontWeight = FontWeight.Bold,
                        fontSize = MaterialTheme.typography.bodyLarge.fontSize
                    )
                    Divider(
                        Modifier
                            .fillMaxSize()
                            .padding(all = LeasePertTheme.sizes.smallerSize)
                    )
                }
            }
            item {
                Text(
                    text = stringResource(id = R.string.notification_this_week),
                    modifier = Modifier.padding(top = LeasePertTheme.sizes.smallSize, bottom = LeasePertTheme.sizes.smallSize),
                    color = MaterialTheme.colorScheme.tertiary,
                    fontWeight = FontWeight.Medium,
                    fontSize = MaterialTheme.typography.titleMedium.fontSize
                )
            }
            items(listWeek) { week ->
                Column {
                    Text(
                        text = week.date,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        fontSize = MaterialTheme.typography.titleSmall.fontSize
                    )
                    Text(
                        text = week.body,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        fontWeight = FontWeight.Bold,
                        fontSize = MaterialTheme.typography.bodyLarge.fontSize
                    )
                    Divider(
                        Modifier
                            .fillMaxSize()
                            .padding(all = LeasePertTheme.sizes.smallerSize)
                    )
                }
            }
        }
    }
}