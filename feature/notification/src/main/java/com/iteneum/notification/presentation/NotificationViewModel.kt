package com.iteneum.notification.presentation

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iteneum.network.DataState
import com.iteneum.notification.domain.models.Notification
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class NotificationViewModel : ViewModel() {

    private val _state : MutableStateFlow<NotificationViewState> = MutableStateFlow(NotificationViewState.Idle)
    val state : StateFlow<NotificationViewState> = _state

    var todayNotificationList : MutableList<Notification> = mutableStateListOf()
    var weekNotificationList : MutableList<Notification> = mutableStateListOf()

    internal fun getNotification() = viewModelScope.launch {

        when(response){
            is DataState.Error -> {
                _state.emit(NotificationViewState.Error)
            }
            is DataState.Loading -> {
                _state.emit(NotificationViewState.Loading)
            }
            is DataState.Success -> {
                response.data.forEach{ notification ->
                    if (notification.type == 1) {
                        todayNotificationList.add(notification)
                    } else {
                        weekNotificationList.add(notification)
                    }
                }
            }
        }
    }

}

sealed class NotificationViewState{
    object Idle : NotificationViewState()
    object Loading : NotificationViewState()
    object Error : NotificationViewState()
}

val response : DataState<List<Notification>> = DataState.Success(
    listOf(
        Notification(
            1,
            "Now",
            "Event today"
        ),
        Notification(
            1,
            "Now",
            "Event today"
        ),
        Notification(
            1,
            "Now",
            "Event today"
        ),
        Notification(
            2,
            "Thu",
            "Event Over"
        ),
        Notification(
            2,
            "Thu",
            "Event Over"
        ),
        Notification(
            2,
            "Thu",
            "Event Over"
        ),
    )
)