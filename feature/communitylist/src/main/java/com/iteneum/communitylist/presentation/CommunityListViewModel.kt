package com.iteneum.communitylist.presentation

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iteneum.ItemModel
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
        MutableStateFlow(CommunityListState.Loading)
    val state: StateFlow<CommunityListState> = _state

    private val _dataInfo: MutableList<ItemModel> = mutableStateListOf()
    val dataInfo: MutableList<ItemModel>
        get() = _dataInfo


    /* WHEN YOU GET INITIAL INFORMATION YOU PUT THE METHOD HERE */
    init {
        getInformation()
    }
    /* GETTING INFORMATION FROM SERVICE EXAMPLE */
    internal fun getInformation() = viewModelScope.launch {
        /* HERE WE ARE GOING TO BE LISTENING THE DATA STATE FROM WE SERVICE */
        when (response) {
            is DataState.Success -> {
                _dataInfo.clear()
                _dataInfo.addAll(response.data)
            }
            is DataState.Error -> {
                _state.emit(CommunityListState.Error)
            }
            is  DataState.Loading -> {
                _state.emit(CommunityListState.Loading)
            }
            else -> Unit
        }
    }
    /** EMMIT STATE SUCCESS IF YOU ARE WAITING THE ANSWER SERVICE.
     *THIS IS FOR EXAMPLE WE HAVE A BUTTON AND WE NEED TO CALL A SERVICE AFTER THAT
     **/
}
/** You can create a sealed class and to map your objects for
 * each case you need to implement
 **/
sealed class CommunityListState {
    object Loading : CommunityListState()
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

/*    private val _loading = mutableStateOf(false)
    val loading: State<Boolean>
        get() = _loading*/
