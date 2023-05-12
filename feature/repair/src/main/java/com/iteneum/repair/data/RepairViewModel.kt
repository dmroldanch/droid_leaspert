package com.iteneum.repair.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.core.net.toUri
import androidx.core.text.isDigitsOnly
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iteneum.RepairRequest
import com.iteneum.UIEventRepair
import com.iteneum.network.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * File that contains [RepairViewModel] that works as ViewModel for the Repair View.
 * It will handle the data work & process when loading & be done with the view.
 *
 * @author Jose Miguel Garcia Reyes
 * @author Carlos Andres Perez Hernandez
 */

@HiltViewModel
class RepairViewModel @Inject constructor() : ViewModel() {
    var repairRequest: RepairRequest by mutableStateOf(RepairRequest())
        private set

    fun getInformation() = viewModelScope.launch {
        when (response) {
            is DataState.Success -> {
                repairRequest = response.data
            }
            else -> Unit
        }
    }

    fun setValues(event: UIEventRepair) {
        when (event) {
            is UIEventRepair.UnitDepartment -> {
                repairRequest = repairRequest.copy(unitDepartment = event.unitDepartment)
            }
            is UIEventRepair.ContactPhone ->{
                if (event.contactPhone.isDigitsOnly() && event.contactPhone.length <= 10) {
                    repairRequest = repairRequest.copy(contactPhone = event.contactPhone)
                }
            }
            is UIEventRepair.PetInUnit -> {
                repairRequest = repairRequest.copy(petInUnit = event.petInUnit)
            }
            is UIEventRepair.Category -> {
                repairRequest = repairRequest.copy(category = event.category)
            }
            is UIEventRepair.ProblemDescription -> {
                repairRequest = repairRequest.copy(problemDescription = event.problemDescription)
            }
            is UIEventRepair.ImageOrVideoFile -> {
                repairRequest = repairRequest.copy(imageOrVideoFile = event.imageOrVideoFile.toUri())
            }
            is UIEventRepair.PermissionToEnter -> {
                repairRequest = repairRequest.copy(permissionToEnter = event.permissionToEnter)
            }
        }
    }

    fun validatePhone(phone: String): Boolean {
        return phone.isEmpty() || phone.length < 10
    }

    fun onClickSendButton() {
        /* TODO - RepairViewModel onClickSendButton - When user clicks on Send button, save data and store it */
    }
}

val response: DataState<RepairRequest> = DataState.Success(
    RepairRequest(
        unitDepartment = "A123"
    )
)
