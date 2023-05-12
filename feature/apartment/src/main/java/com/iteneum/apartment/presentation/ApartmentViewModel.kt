package com.iteneum.apartment.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iteneum.ApartmentModel
import com.iteneum.network.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.sql.Timestamp
import javax.inject.Inject

/**
 * [ApartmentViewModel] The apartment view model is where all the logic for the ApartmentView it working in background
 *
 * @author Usiel Filiberto Garcia Jimenez
 */
@HiltViewModel
class ApartmentViewModel @Inject constructor() : ViewModel() {

    private val _dataInfo: MutableState<ApartmentModel?> = mutableStateOf(null)
    val dataInfo: MutableState<ApartmentModel?>
        get() = _dataInfo

    /**
     * [getInformation] are a corrutines what are listening what be the status of the response when we call to the API, for example Success, Error, Loading
     *
     * @author Usiel Filiberto Garcia Jimenez
     */
    fun getInformation() = viewModelScope.launch {
        /* HERE WE ARE GOING TO BE LISTENING THE DATA STATE FROM WE SERVICE */
        when (response) {
            is DataState.Success -> {
                _dataInfo.value = response.data
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


    /**
     * [onHistoryClicked] is a function what going to do something when the user make click in History button in the ApartmentView
     *
     * @author Usiel Filiberto Garcia Jimenez
     */
    fun onHistoryClicked() {
        /**TODO something when the user make click in history button in the view*/
    }

    /**
     * [onClickPayNow] is a function what going to do something when the user make click in Pay Now button in the ApartmentView
     *
     * @author Usiel Filiberto Garcia Jimenez
     */
    fun onClickPayNow() {
        /**TODO something when the user make click in pay now button in the view*/
    }

    /**
     * [onClickPayNow] is a function what going to do something when the user make click in Leasing Documents button in the ApartmentView
     *
     * @author Usiel Filiberto Garcia Jimenez
     */
    fun onClickLeasingDocuments() {
        /**TODO something when the user make click in leasing documents button in the view*/
    }

    /**
     * [onClickPayNow] is a function what going to do something when the user make click in Apartment Photos button in the ApartmentView
     *
     * @author Usiel Filiberto Garcia Jimenez
     */
    fun onClickApartmentPhotos() {
        /**TODO something when the user make click in Apartment photos button in the view*/
    }

    /**
     * [onClickPayNow] is a function what going to do something when the user make click in Current Status button in the ApartmentView
     *
     * @author Usiel Filiberto Garcia Jimenez
     */
    fun onClickCurrentStatus() {
        /**TODO something when the user make click in current status button in the view*/
    }
}

/**
 * RESPONSE EXAMPLE: in the case what the response was god
 *
 * @author Usiel Filiberto Garcia Jimenez
 */
val response: DataState<ApartmentModel> = DataState.Success(
    ApartmentModel(
        month = "January",
        quantity = "990.00",
        limitDateToPay = "Jan 25 2023",
        repairStatusOpen = "0",
        repairStatusInProgres = "2",
        repairStatusClosed = "0"

    )
)


