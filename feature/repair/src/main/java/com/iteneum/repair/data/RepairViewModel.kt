package com.iteneum.repair.data

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iteneum.RepairModel
import com.iteneum.network.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * File that contains [RepairViewModel] that works as ViewModel for the Repair View.
 * It will handle the data work & process when loading & be done with the view.
 *
 * @author Jose Miguel Garcia Reyes
 */


@HiltViewModel
class RepairViewModel @Inject constructor(): ViewModel() {
    private val _dataInfo : MutableState<RepairModel?> = mutableStateOf(null)
    val dataInfo: MutableState<RepairModel?>
        get() = _dataInfo

    fun getInformation() = viewModelScope.launch {
        when (response) {
            is DataState.Success -> {
                _dataInfo.value = response.data
            }
            is DataState.Error -> {
                /* TODO - RepairViewModel DataState.Error - when data has an error */
            }
            is DataState.Loading -> {
                /* TODO - RepairViewModel DataState.Loading - when data loads */
            }
            else -> Unit
        }
    }

    fun onClickSendButton() {
        /* TODO - RepairViewModel onClickSendButton - When user clicks on Send button, save data and store it */
    }
}
