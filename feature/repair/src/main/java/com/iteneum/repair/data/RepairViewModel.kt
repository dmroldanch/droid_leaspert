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

    /*add to fun composable as parameter --> repairViewModel: RepairViewModel = viewModel()
      add to fun content                 --> val repairUiState by repairViewModel.uiState.collectAsState()
    */

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
