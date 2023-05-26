package com.iteneum.profile.presentation

/**
 * File that contains [UIEventProfile] sealed class
 * It contains definitions of all the possible Events that will be catch on ProfileView.
 *
 * @author Jose Miguel Garcia Reyes
 *
 */
/* TODO - UIEventProfile - Class to implement when editing the Profile */
sealed class UIEventProfile {
    data class Image(val image: String) : UIEventProfile()
    data class Name(val name: String) : UIEventProfile()
    data class Apartment(val apartment: String) : UIEventProfile()
    data class PhoneNumber(val phoneNumber: String) : UIEventProfile()
    data class Email(val email: String) : UIEventProfile()
    data class Address(val address: String) : UIEventProfile()
}