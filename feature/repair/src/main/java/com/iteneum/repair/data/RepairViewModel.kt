package com.iteneum.repair.data

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

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
      add to fun composable                 --> val repairUiState by repairViewModel.uiState.collectAsState()

      isValidDescription = it.isEmpty() || it.matches(Regex(".*[a-zA-Z]+.*")).not()
    */

    /*
    private val _state2: MutableStateFlow< > = MutableStateFlow(RepairUiState.Default)
    val state2 = RepairUiState: UiState <MutableList<ItemModel>> {

    }
    parameter on composable function content --> state: RepairUiState
    */
    init {
        receiveRepairData()
    }
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
    private fun receiveRepairData() {
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
