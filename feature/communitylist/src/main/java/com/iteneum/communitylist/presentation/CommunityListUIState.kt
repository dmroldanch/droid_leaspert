package com.iteneum.communitylist.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.iteneum.ItemList
import com.iteneum.leasepert.utilities.state.UiState

class CommunityListUIState : UiState<MutableList<ItemList>> {
    override var data: MutableList<ItemList>? = mutableListOf()
    override var loading: Boolean by mutableStateOf(false)
}
