package com.iteneum

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat
import com.itenum.domain.IPermissionsProvider
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class PermissionsProviderImpl @Inject constructor(@ApplicationContext val context: Context): IPermissionsProvider {

    override fun isCallPermissionGranted(): Boolean {
        return ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.CALL_PHONE
        ) == PackageManager.PERMISSION_GRANTED
    }

}