package com.iteneum

/**
 * File that contains [UIEventProfile] sealed class
 * It contains definitions of all the possible Events that will be catch on ProfileView.
 *
 * @author Jose Miguel Garcia Reyes
 *
 */
/* TODO - UIEventProfile - Class to implement when editing the Profile */
sealed class UIEventProfile {
    data class ProfileImage(val profileImage: String) : UIEventProfile()
    data class ProfileName(val profileName: String) : UIEventProfile()
    data class ProfileApartment(val profileApartment: String) : UIEventProfile()
    data class ProfilePhoneNumber(val profilePhoneNumber: String) : UIEventProfile()
    data class ProfileEmail(val profileEmail: String) : UIEventProfile()
    data class ProfileAddress(val profileAddress: String) : UIEventProfile()
}