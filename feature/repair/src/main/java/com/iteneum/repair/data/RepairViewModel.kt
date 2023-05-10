package com.iteneum.repair.data

import android.net.Uri
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.core.text.isDigitsOnly
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
    private val _repairModelMutable : MutableState<RepairModel> = mutableStateOf(RepairModel())
    val repairModelRead: MutableState<RepairModel>
        get() = _repairModelMutable

    var repairModel : RepairModel by mutableStateOf(RepairModel())
        private set

    fun getInformation() = viewModelScope.launch {
        when (response) {
            is DataState.Success -> {
                _repairModelMutable.value = response.data
            }
            is DataState.Error -> {
                _repairModelMutable.value = RepairModel(unitDepartment = "E000")
            }
            is DataState.Loading -> {
                _repairModelMutable.value = RepairModel(unitDepartment = "L000")
            }
            else -> Unit
        }
    }

    fun getUnitDepartmentFromView(unitDepartment:String) {
        repairModel = repairModel.copy(unitDepartment = unitDepartment)
    }
    fun getContactPhoneFromView(contactPhone:String) {
        if (contactPhone.isDigitsOnly() && contactPhone.length <= 10) {
            repairModel = repairModel.copy(contactPhone = contactPhone)
        }
    }
    fun getPetInUnitFromView(petInUnit:String) {
        repairModel = repairModel.copy(petInUnit = petInUnit)
    }
    fun getCategoryFromView(category:String) {
        repairModel = repairModel.copy(category = category)
    }
    fun getProblemDescriptionFromView(problemDescription:String) {
        repairModel = repairModel.copy(problemDescription = problemDescription)
    }
    fun getImageOrVideoFileFromView(imageOrVideoFile: Uri) {
        repairModel = repairModel.copy(imageOrVideoFile = imageOrVideoFile)
    }
    fun getPermissionToEnterFromView(permissionToEnter:String) {
        repairModel = repairModel.copy(permissionToEnter = permissionToEnter)
    }
    fun onClickSendButton() {
        /* TODO - RepairViewModel onClickSendButton - When user clicks on Send button, save data and store it */
    }
}

val response: DataState<RepairModel> = DataState.Success(
    RepairModel (
        unitDepartment = "A123"
    )
)