package com.iteneum.profile

/**
 * Class that contains [Profile] data fields.
 *
 * @author Jose Miguel Garcia Reyes
 */

data class Profile (
    val profileImage : String = "",
    val profileName : String = "",
    val profileApartment : String = "",
    val profilePhoneNumber : String = "",
    val profileEmail : String = "",
    val profileAddress : String = ""
)