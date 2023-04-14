package com.iteneum.communitylist.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.iteneum.ItemModel
import com.iteneum.communitylist.UiState
/**
 * This class must have all the mutable values that affect the UI and not whole the view
 * @author Carlos Hernandez
 */
class CommunityListUIState : UiState<MutableList<ItemModel>> {
    override var data: MutableList<ItemModel>? = mutableStateListOf()
    override var loading: Boolean by mutableStateOf(false)
}
