package com.iteneum.communitylist.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iteneum.*
import com.iteneum.network.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
/**
 * This class contains an example how can be implemented the view model
 * if you have a better idea feel free to change any code line.
 * @author Carlos Hernandez
 **/
@HiltViewModel
class CommunityListViewModel : ViewModel() {

    private val _state: MutableStateFlow<CommunityListState> =
        MutableStateFlow(CommunityListState.Default)
    val state: StateFlow<CommunityListState> = _state
    val uiState = CommunityListUIState()

    /* WHEN YOU GET INITIAL INFORMATION YOU PUT THE METHOD HERE */
    init {
        getInformation()
    }
    /* GETTING INFORMATION FROM SERVICE EXAMPLE */
    private fun getInformation() = viewModelScope.launch {
        /* HERE WE ARE GOING TO BE LISTENING THE DATA STATE FROM WE SERVICE */
        uiState.loading = response is DataState.Loading
        when (response) {
            is DataState.Success -> {
                uiState.data?.clear()
                uiState.data?.addAll(response.data)
            }
            is DataState.Error -> {
                _state.emit(CommunityListState.Error)
            }
            else -> Unit
        }
    }
    /** EMMIT STATE SUCCESS IF YOU ARE WAITING THE ANSWER SERVICE.
     *THIS IS FOR EXAMPLE WE HAVE A BUTTON AND WE NEED TO CALL A SERVICE AFTER THAT
     **/
    internal fun onClickFinish() = viewModelScope.launch {
        _state.emit(CommunityListState.Success)
    }
}
/** You can create a sealed class and to map your objects for
 * each case you need to implement
 **/
sealed class CommunityListState {
    object Default : CommunityListState()
    object Error : CommunityListState()
    object Success : CommunityListState()
}

/* RESPONSE EXAMPLE */
val response: DataState<List<ItemModel>> = DataState.Success(
    listOf(
        ItemModel(
            id = 1,
            title = "Rooftop Lounge",
            description = "Relaxing atmosphere."
        ),
        ItemModel(
            id = 2,
            title = "Rooftop Lounge",
            description = "Relaxing atmosphere."
        ),
        ItemModel(
            id = 3,
            title = "Rooftop Lounge",
            description = "Relaxing atmosphere."
        )
    )
)
