package com.iteneum.profile.domain

/**
 * Class that contains [Profile] data fields.
 *
 * @author Jose Miguel Garcia Reyes
 */

data class Profile (
    val image : String = "",
    val name : String = "",
    val apartment : String = "",
    val phoneNumber : String = "",
    val email : String = "",
    val address : String = ""
)