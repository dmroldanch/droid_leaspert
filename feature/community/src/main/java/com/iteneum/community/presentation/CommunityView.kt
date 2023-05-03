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
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.iteneum.community.R
import com.iteneum.community.domain.Community
import com.iteneum.community.domain.CommunityCardType
import com.iteneum.designsystem.components.LpIconTextCard
import com.iteneum.designsystem.theme.LeasePertTheme

/**

The CommunityView function is a composable that displays a list of community sections.
It takes in two lambda parameters that are called when corresponding buttons are clicked,
namely navigationToCommunityWall and navigationToAmenities. The function displays a grid
of community cards, each containing an icon and a description, which when clicked calls
the appropriate lambda function to navigate to different parts of the application.
The function uses Jetpack Compose to create a responsive UI.

* @author Irving Gonzalez
 **/
@Composable
fun CommunityView(
    navigationToCommunityWall : () -> Unit,
    navigationToAmenities  : () -> Unit,
) {
    val sizes = LeasePertTheme.sizes

    val cardDescriptions = remember {
        mapOf(
            CommunityCardType.Amenities to R.string.cardButton_ammenities,
            CommunityCardType.Events to R.string.cardButton_events,
            CommunityCardType.CommunityWall to R.string.cardButton_communityWall,
            CommunityCardType.DoItYourself to R.string.cardButton_doItYourself,
            CommunityCardType.Services to R.string.cardButton_services,
        )
    }

    val communityCardButtons = listOf(
        Community(Icons.Outlined.Diamond, CommunityCardType.Amenities),
        Community(Icons.Outlined.Event, CommunityCardType.Events),
        Community(Icons.Outlined.QuestionAnswer, CommunityCardType.CommunityWall),
        Community(Icons.Outlined.LibraryBooks, CommunityCardType.DoItYourself),
        Community(Icons.Outlined.Store, CommunityCardType.Services)
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = sizes.minorRegularSize, start = sizes.midSmallSize, end = sizes.midSmallSize)
    ) {
        Text(
            text = stringResource(R.string.title_community),
            modifier = Modifier.padding(start = sizes.smallSize),
            style = MaterialTheme.typography.titleLarge,
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2), contentPadding = PaddingValues(sizes.smallerSize)
        ) {
            items(communityCardButtons) { itemCard ->
                LpIconTextCard(modifier = Modifier
                    .size(width = sizes.extraSize124, height = sizes.extraSize128)
                    .padding(sizes.smallerSize),
                    icon = itemCard.icon,
                    description = stringResource(
                        id = cardDescriptions[itemCard.cardType] ?: R.string.default_card_description
                    ),
                    onCardClicked = {
                        when(itemCard.cardType){
                            CommunityCardType.Amenities -> {navigationToAmenities()}
                            CommunityCardType.CommunityWall -> {navigationToCommunityWall()}
                            CommunityCardType.DoItYourself -> { TODO() }
                            CommunityCardType.Events -> { TODO() }
                            CommunityCardType.Services -> { TODO() }
                        }
                    })
            }
        }
    }
}