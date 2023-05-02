package com.iteneum.office.presentation.viewmodel

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.nfc.Tag
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


/**
 * This class is the viewModel corresponding to the Office screen
 * @author Yaritza Moreno
 */
@HiltViewModel
class OfficeViewModel @Inject constructor() :  ViewModel() {


    fun isCallPermissionGranted(appContext: Context): Boolean {
        return ContextCompat.checkSelfPermission(
            appContext,
            Manifest.permission.CALL_PHONE
        ) == PackageManager.PERMISSION_GRANTED
    }


    fun makeCall(phoneNumber: String, appContext: Context) {
        Log.d("DATA", ContextCompat.checkSelfPermission(
            appContext,
            Manifest.permission.CALL_PHONE
        ).toString() )
        if (isCallPermissionGranted(appContext) != true) {
            val intent = Intent(
                Intent.ACTION_DIAL,
                Uri.parse("tel:" + phoneNumber)
            )
            appContext.startActivity(intent)
        } else {
           /*TODO implement request for permission*/
            /*implement library :  */
        }
    }

    fun sendEmail(to: String, subject: String, body: String, appContext: Context) {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:")
            putExtra(Intent.EXTRA_EMAIL, arrayOf(to))
            putExtra(Intent.EXTRA_SUBJECT, subject)
            putExtra(Intent.EXTRA_TEXT, body)
        }
        appContext.startActivity(intent)
    }
}