package com.iteneum.communitylist.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import com.iteneum.ItemList
import com.iteneum.designsystem.components.LPGenericElevatedCardImage
import com.iteneum.designsystem.theme.LeasePertTheme
import com.iteneum.designsystem.utils.TextUtils.TWO

@Composable
fun CommunityListView() {
    CommunityListContent()
}

@Composable
fun CommunityListContent() {
    val dp8 = LeasePertTheme.sizes.smallerSize
    LazyVerticalGrid(
        columns = GridCells.Fixed(TWO),
        verticalArrangement = Arrangement.spacedBy(dp8),
        horizontalArrangement = Arrangement.spacedBy(dp8)
    ) {
        items(getInformation()) { item ->
            LPGenericElevatedCardImage(
                imageUrl = item.urlImage,
                title = item.title.toString(),
                description = item.description.toString(),
                onClick = {} //TODO ONCLICK IMPLEMENT
            )
        }
    }
}

private fun getInformation() = listOf(
    ItemList(
        title = "Rooftop Lounge",
        description = "Relaxing atmosphere."
    ),
    ItemList(
        title = "Rooftop Lounge",
        description = "Relaxing atmosphere."
    ),
    ItemList(
        title = "Rooftop Lounge",
        description = "Relaxing atmosphere."
    )
)
