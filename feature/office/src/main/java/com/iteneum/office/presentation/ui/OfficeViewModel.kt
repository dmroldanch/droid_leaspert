package com.iteneum.office.presentation.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iteneum.network.DataState
import com.iteneum.office.data.OfficeModel
import com.itenum.domain.ContactTelephone
import com.itenum.domain.Email
import com.itenum.domain.IintentActions
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
/**
 * This class will handle the UI Logic and expose data to the composable views.
 * @param intentActions needs to be injected in order to decouple logic *
 * TODO implement @param viewModel the view model we are using inside our view compose has to be injected
 * /*viewModel: OfficeViewModel = hiltViewModel()*/
 * @author Andres Ivan Medina
 */
@HiltViewModel
class OfficeViewModel () : ViewModel() {

    private val _state: MutableStateFlow<OfficeStateList> =
        MutableStateFlow(OfficeStateList.Loading)
    val state: StateFlow<OfficeStateList> = _state

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
                _state.emit(OfficeStateList.Error)
            }

            is DataState.Loading -> {
                _state.emit(OfficeStateList.Loading)
            }

            else -> Unit
        }
    }


    fun makeCall() {
       // val contactTelephone = ContactTelephone(_dataOfficeInfo.first().phone.number)
       // intentActions.makeCall(contactTelephone)
    }

    fun sendEmail() {
       // val email = Email(_dataOfficeInfo.first().email.to,_dataOfficeInfo.first().email.subject,_dataOfficeInfo.first().email.body)
       // intentActions.sendEmail(email)
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
sealed class OfficeStateList {
    object Loading : OfficeStateList()
    object Error : OfficeStateList()
    object Success : OfficeStateList()
}