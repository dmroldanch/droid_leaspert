package com.iteneum.designsystem.components.phonenumbertext

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ViewModelPhone: ViewModel() {
    var mobileCountryCode by mutableStateOf("")
    val countriesList = getCountriesList()
    var mobileCountry by mutableStateOf<Country?>(null)
}