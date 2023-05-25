package com.iteneum.profile.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iteneum.profile.Profile
import com.iteneum.network.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Class that contains [ProfileViewModel] that works as ViewModel for the Profile View.
 * It will handle the data work & process when loading & be done with the view.
 *
 * @author Jose Miguel Garcia Reyes
 */

@HiltViewModel
class ProfileViewModel @Inject constructor(): ViewModel() {
    var profileModelMutable: Profile by mutableStateOf(Profile())
        private set

    fun getInformation() = viewModelScope.launch {
        when (response) {
            is DataState.Success -> {
                profileModelMutable = response.data
            }
            is DataState.Error -> {
                /* TODO - ProfileViewModel - Error data logic to handle  */
            }
            is DataState.Loading -> {
                /* TODO - ProfileViewModel - Loading data logic to handle  */
            }
            else -> Unit
        }
    }

    fun getProfileImageFromView(profileImage:String) {
        profileModelMutable = profileModelMutable.copy(profileImage = profileImage)
    }
    fun getProfileNameFromView(profileName:String) {
        profileModelMutable = profileModelMutable.copy(profileName = profileName)
    }
    fun getProfileApartmentFromView(profileApartment:String) {
        profileModelMutable = profileModelMutable.copy(profileApartment = profileApartment)
    }
    fun getProfilePhoneNumberFromView(profilePhoneNumber:String) {
        profileModelMutable = profileModelMutable.copy(profilePhoneNumber = profilePhoneNumber)
    }
    fun getProfileEmailFromView(profileEmail:String) {
        profileModelMutable = profileModelMutable.copy(profileEmail = profileEmail)
    }
    fun getProfileAddressFromView(profileAddress:String) {
        profileModelMutable = profileModelMutable.copy(profileAddress = profileAddress)
    }
    fun onClickEditProfileButton() {
        /* TODO - ProfileViewModel onClickEditProfileButton - Logic when user clicks on Profile Edit icon button */
    }
    fun onClickPaymentMethodsButton() {
        /* TODO - ProfileViewModel onClickPaymentMethodsButton - Logic when user clicks on Payment button */
    }
    fun onClickEmergencyContactsButton() {
        /* TODO - ProfileViewModel onClickEmergencyContactsButton - Logic when user clicks on Send button */
    }
    fun onClickLogOutButton() {
        /* TODO - ProfileViewModel onClickLogOutButton - Logic when user clicks on Log Out button */
    }
}

/* TODO - ProfileViewModel - Example of data received, modify or erase when DB is available  */
val response: DataState<Profile> = DataState.Success(
    Profile (
        /*profileImage = "A123",*/ /* TODO - ProfileViewModel - Too see how profileImage will be implemented  */
        profileName = "Juan",
        profileApartment = "A123",
        profilePhoneNumber = "6666666666",
        profileEmail = "juan@gmail.com",
        profileAddress = "4950 Gaidrew, Alpharetta, GA, 30022",
    )
)