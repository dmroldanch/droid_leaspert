package com.iteneum.communitylist.presentation

import androidx.lifecycle.ViewModel
import com.iteneum.ItemList
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class CommunityListViewModel : ViewModel() {

    val uiState = CommunityListUIState()

    init {
        getInformation()
    }

    private fun getInformation(){
        uiState.data =  listOf(
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
    }

}