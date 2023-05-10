package com.iteneum

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.itenum.domain.ContactTelephone
import com.itenum.domain.Email
import com.itenum.domain.IPermissionsProvider
import com.itenum.domain.IintentActions
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

/**
 * This class is the implementation of the interface IPermissionProvider
 * @param context this param provides the local context
 * @param permissionProvider this param is an interface contract that provides permissions
 *
 * @author Andres Ivan Medina
 */
class IntentActionsImpl @Inject constructor(
    @ApplicationContext val context: Context,
    val permissionProvider: IPermissionsProvider
) : IintentActions {

    override fun makeCall(phoneNumber: ContactTelephone) {
        if (permissionProvider.isCallPermissionGranted().not()) {
            val intent = Intent(
                Intent.ACTION_DIAL,
                Uri.parse("tel:" + phoneNumber)
            )
            context.startActivity(intent)
        } else {
            /*TODO implement request for permission*/
            /*implement library : acompanist?? */
        }
    }

    override fun sendEmail(email: Email) {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:")
            putExtra(Intent.EXTRA_EMAIL, email.to)
            putExtra(Intent.EXTRA_SUBJECT, email.subject)
            putExtra(Intent.EXTRA_TEXT, email.body)
        }
        context.startActivity(intent)
    }

}