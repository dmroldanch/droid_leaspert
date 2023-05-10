package com.iteneum.dashboard.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iteneum.EventDomain
import com.iteneum.NotificationDomain
import com.iteneum.UserDomain
import com.iteneum.network.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/**
 * ViewModel class of dashboard to communicate with the DashboardView
 * @author Melissa Arellano
 **/
@HiltViewModel
class DashboardViewModel : ViewModel() {
    private val _dashboardState: MutableStateFlow<DashboardState> =
        MutableStateFlow(DashboardState.Loading)
    val dashboardState: StateFlow<DashboardState> = _dashboardState

    private val _userDomain: MutableState<UserDomain> = mutableStateOf(UserDomain())
    val userDomain: State<UserDomain> = _userDomain

    init {
        getDashboardData()
    }

    private fun getDashboardData() = viewModelScope.launch {
        when (response) {
            is DataState.Loading -> {
                _dashboardState.emit(DashboardState.Loading)
            }

            is DataState.Success -> {
                _userDomain.value = response.data
            }

            is DataState.Error -> {
                _dashboardState.emit(DashboardState.Error)
            }
        }
    }
}

/**
 * [DashboardState] class to handle the different information's state of the UI.
 * @author Melissa Arellano
 */
sealed class DashboardState {
    object Loading : DashboardState()
    object Error : DashboardState()
    object Success : DashboardState()
}

/**
 * Response example
 * @author Melissa Arellano
 */
val response: DataState<UserDomain> = DataState.Success(
    UserDomain(
        username = "Andrea",
        currentBalance = 400.00,
        serviceRequestInProgress = 2,
        amenityReservetion = 3,
        notification = NotificationDomain(
            notificationCount = 5
        ),
        events = arrayListOf(
            EventDomain(
                title = "Coffee and Donuts",
                description = "Join us for a morning treat! We will be providing free coffee and donuts in the office at 9 am.",
                buttonText = "Event"
            ),
            EventDomain(
                title = "Sportbar",
                description = "Join us in your own booth with a great view of all the action!! Rockstar will start performing at 10pm.",
                buttonText = "Event"
            ),
            EventDomain(
                title = "Take care!",
                description = "A dog without a neck around my house",
                buttonText = "See more"
            )
        )
    )
)