package com.iteneum.repair.data

import android.net.Uri
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
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
    private val _dataInfo : MutableState<RepairModel?> = mutableStateOf(null) /* TODO - RepairViewModel - Verify if it will stay null */
    val dataInfo: MutableState<RepairModel?>
        get() = _dataInfo
    var repairModel : RepairModel by mutableStateOf(RepairModel())
        private set

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

    fun getUnitDepartmentFromView(unitDepartment:String) {
        repairModel = repairModel.copy(unitDepartment = unitDepartment)
    }
    fun getContactPhoneFromView(contactPhone:String) {
        repairModel = repairModel.copy(contactPhone = contactPhone)
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
        unitDepartment = "A123",
        contactPhone = "1234567891",
        petInUnit = "Dog",
        category = "Bedroom",
        problemDescription = "I have a stain on my floor",
        imageOrVideoFile = Uri.parse("http://www.google.com"),
        permissionToEnter = "Yes",
    )
)