package com.iteneum.office.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * This class is the viewModel corresponding to the Office screen
 * @author Yaritza Moreno
 */
@HiltViewModel
class OfficeViewModel @Inject constructor(): ViewModel() {

    private fun onClick(){
        viewModelScope.launch(Dispatchers.IO) {
            /*TODO*/
        }
    }

}