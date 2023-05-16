package com.iteneum.office.presentation.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iteneum.office.data.OfficeModel
import com.iteneum.network.DataState
import com.iteneum.office.presentation.ui.officeInfoResponse
import com.itenum.domain.ContactTelephone
import com.itenum.domain.Email
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/**
 *class OfficeViewModel will handle the UI Logic and
 * expose data to the composable views.
 * TODO implement @param intentActions needs to be injected in order to decouple logic *
 *
 * /*viewModel: OfficeViewModel = hiltViewModel()*/
 *@author  Yaritza Moreno
 *
 *@author Andres Ivan Medina
 */

class OfficeViewModel() : ViewModel() {

    private val _state: MutableStateFlow<OfficeStateResponse> =
        MutableStateFlow(OfficeStateResponse.Loading)
    val state: StateFlow<OfficeStateResponse> = _state

    private val _officeInfo: MutableState<OfficeModel?> = mutableStateOf(null)
    val officeInfo: OfficeModel?
        get() = _officeInfo.value

    init {
        getOfficeInformation()
    }

    internal fun getOfficeInformation() = viewModelScope.launch {
        when (officeInfoResponse) {
            is DataState.Success -> {
                _officeInfo.value = officeInfoResponse.data
            }

            is DataState.Error -> {
                _state.emit(OfficeStateResponse.Error)
            }

            is DataState.Loading -> {
                _state.emit(OfficeStateResponse.Loading)
            }

            else -> Unit
        }
    }

    fun makeCall() {
        val contactTelephone =
            _officeInfo.value?.phone?.let { ContactTelephone(it.number) }/*TODO: Implement call intent once permission logic is stablished*/
    }

    fun sendEmail() {
        val email = Email(
            _officeInfo.value?.email?.to ?: "",
            _officeInfo.value?.email?.subject ?: "",
            _officeInfo.value?.email?.body ?: ""
        )/*TODO: Implement Email intent once permission logic is stablished*/

    }
}


/**
 * This variable represents the data Mock brought by the API call.
 * @param officeInfoResponse this is the mock data exposed as list*
 *
 * @author Andres Ivan Medina
 */
val officeInfoResponse: DataState<OfficeModel> = DataState.Success(
    OfficeModel(
        "4950 Gaidrew, Alpharetta, GA, 30022 ",
        "9AM-6PM",
        phone = ContactTelephone("+1 452 123 4567"),
        email = Email("contact@leaspert.com", "mail test", "this is a mail send test")
    )
)

/**
 * class:OfficeStateList  represents the states of the data
 * exposed through the list.
 *
 * @author Andres Ivan Medina
 */
sealed class OfficeStateResponse {
    object Loading : OfficeStateResponse()
    object Error : OfficeStateResponse()
    object Success : OfficeStateResponse()
}