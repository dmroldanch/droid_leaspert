package com.iteneum.community.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.iteneum.community.R
import com.iteneum.community.domain.CommunityCardDataModel
import com.iteneum.community.domain.CommunitySectionList
import com.iteneum.designsystem.components.LpIconTextCard
import com.iteneum.designsystem.theme.LeasePertTheme

/**
 * This function creates a  Composable UI  that displays a list of community sections.
 * @param viewModel receives a viewModel to manage the logic of the view
 *this view model is used to handle the loading of the components of the interface
 * including icons, text and button click functionality.
 *
 * @author Andrés Ivan Medina Herrera
 */
@Composable
fun CommunitylistUI() {
    val cardWidth = LeasePertTheme.sizes.extraSize124
    val cardHeight = LeasePertTheme.sizes.extraSize128
    val cardPadding8 = LeasePertTheme.sizes.smallerSize
    val cardPadding15 = LeasePertTheme.sizes.smallSize
    val cardPadding10 = LeasePertTheme.sizes.midSmallSize
    val cardPadding20 = LeasePertTheme.sizes.minorRegularSize
    val communityCardButtons = listOf(
        CommunityCardDataModel(Icons.Outlined.Diamond, CommunitySectionList.AMENITIES),
        CommunityCardDataModel(Icons.Outlined.Event, CommunitySectionList.EVENTS),
        CommunityCardDataModel(Icons.Outlined.QuestionAnswer, CommunitySectionList.COMMUNITY_WALL),
        CommunityCardDataModel(Icons.Outlined.LibraryBooks, CommunitySectionList.DOITYOURSELF),
        CommunityCardDataModel(Icons.Outlined.Store, CommunitySectionList.SERVICES)
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = cardPadding20, start = cardPadding10, end = cardPadding10)
    ) {
        Text(
            text = stringResource(R.string.title_community),
            modifier = Modifier.padding(start = cardPadding15),
            style = MaterialTheme.typography.titleMedium,
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2), contentPadding = PaddingValues(cardPadding8)
        ) {
            items(communityCardButtons) { itemCard ->
                LpIconTextCard(modifier = Modifier.size(width = cardWidth, height = cardHeight),
                    icon = itemCard.icon,
                    description = stringResource(
                        id = when (itemCard.cardName) {
                            CommunitySectionList.AMENITIES -> R.string.communityUi_cardButton_ammenities
                            CommunitySectionList.EVENTS -> R.string.communityUi_cardButton_events
                            CommunitySectionList.COMMUNITY_WALL -> R.string.communityUi_cardButton_communityWall
                            CommunitySectionList.DOITYOURSELF -> R.string.communityUi_cardButton_doItYourself
                            CommunitySectionList.SERVICES -> R.string.communityUi_cardButton_services
                        }
                    ),
                    onCardClick = {
                        //TODO implement functionalities related to on click over card
                    })
            }
        }
    }
}
