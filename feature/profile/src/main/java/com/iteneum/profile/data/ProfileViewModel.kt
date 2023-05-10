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
    private val _profileModelMutable : MutableState<ProfileModel> = mutableStateOf(ProfileModel())
    val profileModelRead: MutableState<ProfileModel>
        get() = _profileModelMutable
    var profileModel : ProfileModel by mutableStateOf(ProfileModel())
        private set

    fun getInformation() = viewModelScope.launch {
        when (response) {
            is DataState.Success -> {
                _profileModelMutable.value = response.data
            }
            is DataState.Error -> {
                _profileModelMutable.value = ProfileModel(
                    profileName = "Error",
                    profileApartment = "Error",
                    profilePhoneNumber = "1111111111",
                    profileEmail = "Error",
                    profileAddress = "Error"
                )
            }
            is DataState.Loading -> {
                _profileModelMutable.value = ProfileModel(
                    profileName = "Loading...",
                    profileApartment = "Loading...",
                    profilePhoneNumber = "0000000000",
                    profileEmail = "Loading...",
                    profileAddress = "Loading..."
                )
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

val response: DataState<ProfileModel> = DataState.Success(
    ProfileModel (
        /*profileImage = "A123",*/ /* TODO - ProfileViewModel - Too see how profileImage will be implemented  */
        profileName = "Juan",
        profileApartment = "A123",
        profilePhoneNumber = "6666666666",
        profileEmail = "juan@gmail.com",
        profileAddress = "4950 Gaidrew, Alpharetta, GA, 30022",
    )
)