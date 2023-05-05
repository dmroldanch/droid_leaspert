package com.iteneum.profile.data

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iteneum.ProfileModel
import com.iteneum.network.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * File that contains [ProfileViewModel] that works as ViewModel for the Profile View.
 * It will handle the data work & process when loading & be done with the view.
 *
 * @author Jose Miguel Garcia Reyes
 */


@HiltViewModel
class ProfileViewModel @Inject constructor(): ViewModel() {
    private val _dataInfo : MutableState<ProfileModel?> = mutableStateOf(null) /* TODO - ProfileViewModel - Verify if it will stay null */
    val dataInfo: MutableState<ProfileModel?>
        get() = _dataInfo
    var profileModel : ProfileModel by mutableStateOf(ProfileModel())
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

    fun getProfileImageFromView(profileImage:String) {
        profileModel = profileModel.copy(profileImage = profileImage)
    }
    fun getProfileNameFromView(profileName:String) {
        profileModel = profileModel.copy(profileName = profileName)
    }
    fun getProfileApartmentFromView(profileApartment:String) {
        profileModel = profileModel.copy(profileApartment = profileApartment)
    }
    fun getProfilePhoneNumberFromView(profilePhoneNumber:String) {
        profileModel = profileModel.copy(profilePhoneNumber = profilePhoneNumber)
    }
    fun getProfileEmailFromView(profileEmail:String) {
        profileModel = profileModel.copy(profileEmail = profileEmail)
    }
    fun getProfileAddressFromView(profileAddress:String) {
        profileModel = profileModel.copy(profileAddress = profileAddress)
    }
    fun onClickEditProfileButton() {
        /* TODO - ProfileViewModel onClickEditProfileButton - When user clicks on Profile Edit icon button */
    }
    fun onClickPaymentMethodsButton() {
        /* TODO - ProfileViewModel onClickPaymentMethodsButton - When user clicks on Payment button */
    }
    fun onClickEmergencyContactsButton() {
        /* TODO - ProfileViewModel onClickEmergencyContactsButton - When user clicks on Send button */
    }
    fun onClickLogOutButton() {
        /* TODO - ProfileViewModel onClickLogOutButton - When user clicks on Log Out button */
    }
}

val response: DataState<ProfileModel> = DataState.Success(
    ProfileModel (
        profileImage = "A123",
        profileName = "Juan",
        profileApartment = "101",
        profilePhoneNumber = "4049792400",
        profileEmail = "juan.islas@gmail.com",
        profileAddress = "4950 Gaidrew, Alpharetta, GA, 30022",
    )
)