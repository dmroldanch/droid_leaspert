package com.iteneum.office.presentation.viewmodel

import android.content.Context
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.ViewModel
import com.itenum.domain.ContactTelephone
import com.itenum.domain.Email
import com.itenum.domain.IintentActions
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


/**
 * This class is the viewModel corresponding to the Office screen
 * @author Yaritza Moreno
 */
@HiltViewModel
class OfficeViewModel @Inject constructor(val intentActions: IintentActions) : ViewModel() {


    fun makeCall(phoneNumber: String) {
        val contactTelephone = ContactTelephone(phoneNumber)
        intentActions.makeCall(contactTelephone)
    }

    fun sendEmail(to: String, subject: String, body: String) {
        val email = Email(to, subject, body)
        intentActions.sendEmail(email)
    }

}