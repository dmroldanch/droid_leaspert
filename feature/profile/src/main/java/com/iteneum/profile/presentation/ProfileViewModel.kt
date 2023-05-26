package com.iteneum.profile.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iteneum.profile.domain.Profile
import com.iteneum.network.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Class that contains [ProfileViewModel] that works as ViewModel for the Profile View.
 * It will handle the data work and process when loading and be done with the view.
 *
 * @author Jose Miguel Garcia Reyes
 */

@HiltViewModel
class ProfileViewModel @Inject constructor(): ViewModel() {

    private val _state: MutableStateFlow<ProfileState> =
        MutableStateFlow(ProfileState.Loading)
    val state: StateFlow<ProfileState> = _state

    var profileModelMutable: Profile by mutableStateOf(Profile())
        private set

    fun getInformation() = viewModelScope.launch {
        when (response) {
            is DataState.Success -> {
                profileModelMutable = response.data
                _state.emit(ProfileState.Success)
            }
            is DataState.Error -> {
                /* TODO - ProfileViewModel - Error data logic to handle  */
                _state.emit(ProfileState.Error)
            }
            is DataState.Loading -> {
                /* TODO - ProfileViewModel - Loading data logic to handle  */
                _state.emit(ProfileState.Loading)
            }
            else -> Unit
        }
    }

    fun getProfileImageFromView(profileImage:String) {
        profileModelMutable = profileModelMutable.copy(image = profileImage)
    }
    fun getProfileNameFromView(profileName:String) {
        profileModelMutable = profileModelMutable.copy(name = profileName)
    }
    fun getProfileApartmentFromView(profileApartment:String) {
        profileModelMutable = profileModelMutable.copy(apartment = profileApartment)
    }
    fun getProfilePhoneNumberFromView(profilePhoneNumber:String) {
        profileModelMutable = profileModelMutable.copy(phoneNumber = profilePhoneNumber)
    }
    fun getProfileEmailFromView(profileEmail:String) {
        profileModelMutable = profileModelMutable.copy(email = profileEmail)
    }
    fun getProfileAddressFromView(profileAddress:String) {
        profileModelMutable = profileModelMutable.copy(address = profileAddress)
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

sealed class ProfileState {
    object Loading: ProfileState()
    object Error: ProfileState()
    object Success: ProfileState()
}

/* TODO - ProfileViewModel - Example of data received, modify or erase when DB is available  */
val response: DataState<Profile> = DataState.Success(
    Profile (
        image = "https://picsum.photos/200",
        name = "Juan",
        apartment = "A123",
        phoneNumber = "1234567891",
        email = "juan@gmail.com",
        address = "4950 Gaidrew, Alpharetta, GA, 30022",
    )
)