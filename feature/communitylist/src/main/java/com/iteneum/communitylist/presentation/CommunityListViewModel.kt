package com.iteneum.communitylist.presentation

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iteneum.ItemModel
import com.iteneum.designsystem.components.UIActions
import com.iteneum.network.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

/**
 * This class contains an example how can be implemented the view model
 * if you have a better idea feel free to change any code line.
 * @author Carlos Hernandez
 **/
@HiltViewModel
class CommunityListViewModel : ViewModel() {

    /* THIS STATE IS GOING TO BE USED WHEN WE NEED TO DO A BIG CHANGE TO THE VIEW  */
    private val _state: MutableSharedFlow<UIActions> =
        MutableSharedFlow()
    val state: SharedFlow<UIActions> = _state

    var myData: MutableList<ItemModel> = mutableStateListOf()
        private set

    /* GETTING INFORMATION FROM SERVICE EXAMPLE */
    internal fun getInformation() = viewModelScope.launch {
        /* HERE WE ARE GOING TO BE LISTENING THE DATA STATE FROM WE SERVICE */
        when (response) {
            is DataState.Success -> {
                myData.clear()
                myData.addAll(response.data)
            }
            is DataState.Error -> {
                _state.emit(UIActions.ShowSnackBar("Mi description", "Reintentar", action = {
                    callGetInformation()
                }))
            }
            is DataState.Loading -> {
                //_state.emit(CommunityListState.Loading)
            }
            else -> Unit
        }
    }
    /** EMMIT STATE SUCCESS IF YOU ARE WAITING THE ANSWER SERVICE.
     *THIS IS FOR EXAMPLE WE HAVE A BUTTON AND WE NEED TO CALL A SERVICE AFTER THAT
     **/
    internal fun showSnack() = viewModelScope.launch {
        _state.emit(UIActions.ShowSnackBar("Mi description", "Reintentar", action = {
            callGetInformation()
        }))
    }
    private fun callGetInformation(){
        getInformation()
    }
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
