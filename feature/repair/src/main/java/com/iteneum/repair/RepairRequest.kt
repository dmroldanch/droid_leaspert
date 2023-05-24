package com.iteneum.repair

import android.net.Uri

/**
 * File that contains [RepairRequest] definition data class.
 * It contains all the text field values to be stored from the RepairView.
 *
 * @author Jose Miguel Garcia Reyes
 */

data class RepairRequest(
    val unitDepartment: String = "",
    val contactPhone: String = "",
    val petInUnit: String = "",
    val category: String = "",
    val problemDescription: String = "",
    val imageOrVideoFile: Uri = Uri.parse(""),
    val permissionToEnter: String = "",
)
