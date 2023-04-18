package com.iteneum.office.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OfficeViewModel @Inject constructor(): ViewModel() {

    private fun onClick(){
        viewModelScope.launch(Dispatchers.IO) {
            /*TODO*/
        }
    }

}