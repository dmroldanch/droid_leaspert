package com.iteneum.communitylist.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.iteneum.ItemModel
import com.iteneum.designsystem.components.LPGenericElevatedCardImage
import com.iteneum.designsystem.theme.LeasePertTheme
import com.iteneum.designsystem.utils.TextUtils.TWO

/**
 * This class is for the states network responses, it can has modification with the structure.
 * @param onClickItem click back when you do it on an item
 * @param onSuccess our event that send us to the next view
 * @param viewModel the view model we are using inside our view compose
 * @author Carlos Hernandez
 */
@Composable
fun CommunityListView(
    onClickItem: (Int) -> Unit, /* THIS WORKS WHEN YOU JUST WANT TO SEND A VALUE AND IF YOU ARE NOT USING A STATE YOU WILL CHANGE THE VIEW*/
    onSuccess: () -> Unit, /* THIS WORKS WHEN YOU ARE USING A STATE AND YOU ARE GONNA FINISH THE VIEW */
    viewModel: CommunityListViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState(initial = null)
    when (state) {
        is CommunityListState.Success -> {
            onSuccess()
        }
        is CommunityListState.Error -> {
            CommunityErrorState()
        }
        else -> {}
    }
    CommunityListContent(
        state = viewModel.uiState,
        onClickItem = {
            onClickItem(it.id)
        }
    )
}

@Composable
fun CommunityListContent(
    state: CommunityListUIState,
    onClickItem: (ItemModel) -> Unit
) {
    val dp8 = LeasePertTheme.sizes.smallerSize
    if (state.loading) {
        LoadingBar()
    }
    Column {
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
                    onClick = { onClickItem(item) }
                )
            }
        }
    }
}
/** IT'S AN EXAMPLE IF WE HAD A COMPONENT FOR LOADING **/
@Composable
fun LoadingBar() {
}

/*THIS IS JUST AN EXAMPLE IF WE HAD A VIEW FOR ERROR, WE NEED TO DEFINE AND CHANGE IT*/
@Composable
fun CommunityErrorState() {
    Text(text = "This can be a view for empty state")
}

