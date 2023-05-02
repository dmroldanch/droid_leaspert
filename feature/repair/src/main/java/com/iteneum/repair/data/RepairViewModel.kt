package com.iteneum.repair.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class RepairUiState (
    val unitFieldValue: Int? = null,
    val contactPhoneValue: String? = null,
    val petInUnitValue: String? = null,
    val categoryValue: String? = null,
    val problemDescriptionValue: String? = null,
    val videoFileValue: Any? = null,
    val permissionToEnterValue: String? = null,
)

class RepairViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(RepairUiState())
    val uiState: StateFlow<RepairUiState> = _uiState.asStateFlow()

    /*add to fun composable view as parameter --> repairViewModel: RepairViewModel = viewModel()
      add to fun content                 --> val repairUiState by repairViewModel.uiState.collectAsState()

      isValidDescription = it.isEmpty() || it.matches(Regex(".*[a-zA-Z]+.*")).not()
    */

    /*
    private val _state2: MutableStateFlow< > = MutableStateFlow(RepairUiState.Default)
    val state2 = RepairUiState: UiState <MutableList<ItemModel>> {

    }


    init {
        getInformation()
    }

    parameter on composable function content --> state: RepairUiState
    */
    /*internal fun getInformation() = viewModelScope.launch {
        = response is Database.Loading
        when (response) {
            is DataState.Success -> {
                uiState.<data>.clear()
                uiState.<data>.addAll(response.data)
            }
            is DataState.Error -> {
                uiState.snackbarVisibleState = true
            }
            else -> Unit

        }
    }*/
    fun receiveRepairDataFromUI() {
        _uiState.update { currentState ->
            currentState.copy(
                unitFieldValue = 1,
                contactPhoneValue = "text",
                petInUnitValue = "text",
                categoryValue = "text",
                problemDescriptionValue = "text",
                videoFileValue = "text",
                permissionToEnterValue = "text",
            )
        }
    }

    fun sendRepairDataToDB() {

    }

}
