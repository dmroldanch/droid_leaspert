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
        uiState.data =  mutableListOf(
            ItemList(
                title = "Prueba 1",
                description = "Descripcion 2"
            ),
            ItemList(
                title = "Prueba 1",
                description = "Descripcion 2"
            ),
            ItemList(
                title = "Prueba 1",
                description = "Descripcion 2"
            )
        )
    }

}