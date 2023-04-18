package com.iteneum.office.presentation.viewmodel

import android.util.Log
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

    //I'm just added the context parameter to test the viewModel
    //It can be removed in the future
    fun onClick(){
        viewModelScope.launch(Dispatchers.IO) {
           Log.e("Test", "Show test")
        }

    }

}