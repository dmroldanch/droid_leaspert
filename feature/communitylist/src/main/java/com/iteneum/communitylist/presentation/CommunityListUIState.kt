package com.iteneum.communitylist.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.iteneum.ItemList
import com.iteneum.leasepert.utilities.state.UiState

class CommunityListUIState : UiState<List<ItemList>> {
    override var data: List<ItemList>? by mutableStateOf(null)
    override var loading: Boolean by mutableStateOf(false)
}
