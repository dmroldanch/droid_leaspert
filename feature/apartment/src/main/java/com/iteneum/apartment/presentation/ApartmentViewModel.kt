package com.iteneum.apartment.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iteneum.apartment.domain.PaymentDetails
import com.iteneum.apartment.domain.UserDetail
import com.iteneum.network.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class ApartmentViewModel : ViewModel() {

    private val _state: MutableStateFlow<ApartmentState> =
        MutableStateFlow(ApartmentState.Loading)

    val state: StateFlow<ApartmentState> = _state

    var userData: UserDetail = UserDetail(
        paymentDetails = PaymentDetails(
            currentMonth = "No Data",
            rentDebt = 0.0f,
            deadline = "No Data"
        ),
        openRepairs = 0,
        inProgress = 0,
        closedRepairs = 0
    )
    private set

    internal fun checkHistory(){
        /*TODO request the historical of payments*/
    }

    internal fun payNow(){
        /*TODO high order function to pay rent*/
    }

    internal fun getInformation() = viewModelScope.launch {
        when(response){
            is DataState.Error -> _state.emit(ApartmentState.Error)
            is DataState.Loading -> _state.emit(ApartmentState.Loading)
            is DataState.Success -> {
                userData = response.data
                _state.emit(ApartmentState.Success)
            }
        }
    }
}

sealed class ApartmentState{
    object Loading : ApartmentState()
    object Error : ApartmentState()
    object Success : ApartmentState()
}

/*RESPONSE EXAMPLE*/
val response: DataState<UserDetail> = DataState.Success(
    UserDetail(
        paymentDetails = PaymentDetails(
            currentMonth = "May",
            rentDebt = 990.0f,
            deadline = "May 25 2023"
        ),
        openRepairs = 1,
        inProgress = 2,
        closedRepairs = 0
    )
)