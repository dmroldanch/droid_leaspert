package com.iteneum.office.presentation.ui
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iteneum.OfficeInfoItemModel
import com.iteneum.network.DataState
import com.itenum.domain.ContactTelephone
import com.itenum.domain.Email
import com.itenum.domain.IintentActions
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class OfficeViewModel @Inject constructor(val intentActions: IintentActions) : ViewModel() {

    private val _state: MutableStateFlow<OfficeStateList> =
        MutableStateFlow(OfficeStateList.Loading)
    val state: StateFlow<OfficeStateList> = _state

    private val _dataOfficeInfo: MutableList<OfficeInfoItemModel> = mutableStateListOf()
    val dataOfficeInfo: MutableList<OfficeInfoItemModel>
        get() = _dataOfficeInfo

    init {
        loadOfficeInformationData()
    }


    internal fun loadOfficeInformationData() = viewModelScope.launch {
        when (officeInfoResponse) {
            is DataState.Success -> {
                _dataOfficeInfo.clear()
                _dataOfficeInfo.addAll(officeInfoResponse.data)
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


    fun makeCall(phoneNumber: String) {
        val contactTelephone = ContactTelephone(phoneNumber)
        intentActions.makeCall(contactTelephone)
    }
    fun sendEmail(to: String, subject: String, body: String) {
        val email = Email(to, subject, body)
        intentActions.sendEmail(email)
    }
}

val officeInfoResponse: DataState<List<OfficeInfoItemModel>> = DataState.Success(
    listOf(
        OfficeInfoItemModel("","","","" )
    )
)


sealed class OfficeStateList {
    object Loading : OfficeStateList()
    object Error : OfficeStateList()
    object Success : OfficeStateList()
}