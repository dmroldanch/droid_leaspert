package com.iteneum.office.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@HiltViewModel
class OfficeViewModel: ViewModel() {

    private val _event = mutableStateOf(true)
    val event: State<Boolean>
    get() = _event

    private fun onClick(){
        viewModelScope.launch(Dispatchers.IO) {

        }
    }

}