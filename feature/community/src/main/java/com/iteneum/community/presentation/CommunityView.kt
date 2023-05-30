package com.iteneum.community.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
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
 * @param navigationToAmenities is the function called when clicking on the "Amenities" button and navigate to AmenitiesView.
 * @param navigationToEvents is the function called when clicking on the "Events" button and navigate to EventsView.
 * @param navigationToCommunityWall is the function called when clicking on the "Community Wall" button and navigate to CommunityWallView.
 * @param navigationToDoItYourSelf is the function called when clicking on the "Do it yourself" button and navigate to DoItYourSelfView.
 * @param navigationToServices is the function called when clicking on the "Services" button and navigate to ServicesView.
 * @param viewModel is used to manage the business logic inside the CommunityView
 * These functions are used to navigate to different parts of the application.
 * @author Irving Gonzalez
 * @modifyBy Jose Rivera
 **/
@Composable
fun CommunityView(
    navigationToAmenities: () -> Unit,
    navigationToEvents: () -> Unit,
    navigationToCommunityWall: () -> Unit,
    navigationToDoItYourSelf: () -> Unit,
    navigationToServices: () -> Unit,
    viewModel: CommunityViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsState()

    when (state.value) {
        State.Error -> {
            ShowStateContent(stringResource(id = R.string.error_message))
        }

        State.Loading -> {
            ShowStateContent(stringResource(id = R.string.loading_message))
        }

        State.Success -> {
            CommunityContent(
                list = viewModel.communitySections,
                cardDescriptions = viewModel.cardDescriptions,
                onClick = {
                    when (it.cardType) {
                        CommunityCardType.Amenities -> {
                            navigationToAmenities()
                        }

                        CommunityCardType.CommunityWall -> {
                            navigationToCommunityWall()
                        }

                        CommunityCardType.DoItYourself -> {
                            navigationToDoItYourSelf()
                        }

                        CommunityCardType.Events -> {
                            navigationToEvents()
                        }

                        CommunityCardType.Services -> {
                            navigationToServices()
                        }
                    }
                }
            )
        }
    }
}

@Composable
fun CommunityContent(
    list: List<Community>,
    cardDescriptions: Map<CommunityCardType, Int>,
    onClick: (Community) -> Unit
) {
    val sizes = LeasePertTheme.sizes

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = sizes.minorRegularSize,
                start = sizes.midSmallSize,
                end = sizes.midSmallSize
            )
    ) {
        Text(
            text = stringResource(R.string.title_community),
            modifier = Modifier.padding(start = sizes.smallSize),
            style = MaterialTheme.typography.titleLarge
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(sizes.smallerSize)
        ) {
            items(list) { itemCard ->
                LpIconTextCard(modifier = Modifier
                    .size(width = sizes.extraSize124, height = sizes.extraSize128)
                    .padding(sizes.smallerSize),
                    icon = itemCard.icon,
                    description = stringResource(
                        id = cardDescriptions[itemCard.cardType]
                            ?: R.string.default_card_description
                    ),
                    onCardClicked = {
                        onClick(itemCard)
                    }
                )
            }
        }
    }
}

@Composable
fun ShowStateContent(message: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = message
        )
    }
}

