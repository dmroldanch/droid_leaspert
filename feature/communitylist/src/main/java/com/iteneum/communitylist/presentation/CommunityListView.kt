package com.iteneum.communitylist.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
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
    LaunchedEffect(true){
        viewModel.getInformation()
        /*viewModel.stateAction.collect {
            //uiAction(it)
        }*/
    }
    val list = remember {
        viewModel.dataInfo
    }
    CommunityListContent(
        list = list,
        onClickItem = {
            //onNavigateTo(it.id)
        }
    )
}

@Composable
fun CommunityListContent(
    list: List<ItemModel>,
    onClickItem: (ItemModel) -> Unit
) {

    val dp8 = LeasePertTheme.sizes.smallerSize
    Column {
        LazyVerticalGrid(
            columns = GridCells.Fixed(TWO),
            verticalArrangement = Arrangement.spacedBy(dp8),
            horizontalArrangement = Arrangement.spacedBy(dp8)
        ) {
            items(list) { item ->
                LPGenericElevatedCardImage(
                    modifier = Modifier.fillMaxSize(),
                    imageUrl = item.urlImage,
                    title = item.title.toString(),
                    description = item.description.toString(),
                    onClicked = { onClickItem(item) }
                )
            }
        }
    }
}


