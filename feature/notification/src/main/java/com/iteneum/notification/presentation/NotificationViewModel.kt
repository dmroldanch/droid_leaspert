package com.iteneum.notification.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iteneum.network.DataState
import com.iteneum.notification.domain.models.NotificationModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * [NotificationViewModel] is the view model what work with the NotificationListView, here is all the information will be consumed and passed to the view
 *
 * @author Usiel Filiberto Garcia Jimenez
 */
@HiltViewModel
class NotificationViewModel @Inject constructor() : ViewModel(){

    var dataToday: MutableList<NotificationModel> = mutableListOf()
        private set

    var dataWeek: MutableList<NotificationModel> = mutableListOf()
        private set

    init {
        getInformation()
    }

    /**
     * [getInformation] are a corrutines what are listening what be the status of the response when we call to the API, for example Success, Error, Loading
     *
     * @author Usiel Filiberto Garcia Jimenez
     */
    fun getInformation() = viewModelScope.launch {
        /* HERE WE ARE GOING TO BE LISTENING THE DATA STATE FROM WE SERVICE */
        when (response) {
            is DataState.Success -> {
                response.data.forEach{notification ->
                    if(notification.typeNotification == 1){
                        dataToday.add(notification)
                    }else{
                        dataWeek.add(notification)
                    }
                }
            }

            is DataState.Error -> {
                /**TODO do something when wrong */
            }

            is DataState.Loading -> {
                /**TODO do something when load */
            }

            else -> Unit
        }


    }
}

// Fake data what simulates one response of the API
val response: DataState<List<NotificationModel>> = DataState.Success(
    listOf(
        NotificationModel(1,"Now", "Apartment payment received thank you!"),
        NotificationModel(1,"6 hours ago", "Don't forget you event Tomorrow!"),
        NotificationModel(2,"3 days ago", "Service request complete enjoy your space."),
        NotificationModel(2,"5 days ago", "January payment available please make your payment."),
        NotificationModel(2,"6 days ago", "You have an amenity booked for today.")
    )
)
