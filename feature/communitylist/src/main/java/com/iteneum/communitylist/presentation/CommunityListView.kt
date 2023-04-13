package com.iteneum.communitylist.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.iteneum.designsystem.components.LPGenericElevatedCardImage
import com.iteneum.designsystem.theme.LeasePertTheme
import com.iteneum.designsystem.utils.TextUtils.TWO

@Composable
fun CommunityListView(
    viewModel: CommunityListViewModel = hiltViewModel()
) {
    CommunityListContent(
        state = viewModel.uiState
    )
}

@Composable
fun CommunityListContent(
    state: CommunityListUIState
) {
    val dp8 = LeasePertTheme.sizes.smallerSize
    LazyVerticalGrid(
        columns = GridCells.Fixed(TWO),
        verticalArrangement = Arrangement.spacedBy(dp8),
        horizontalArrangement = Arrangement.spacedBy(dp8)
    ) {
        items(state.data ?: listOf()) { item ->
            LPGenericElevatedCardImage(
                imageUrl = item.urlImage,
                title = item.title.toString(),
                description = item.description.toString(),
                onClick = {} //TODO ONCLICK IMPLEMENT
            )
        }
    }
}
