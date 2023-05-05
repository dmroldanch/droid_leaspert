package com.iteneum

import android.net.Uri

/**
 * File that contains [RepairModel] definition data class.
 * It contains all the text field values to be stored from the RepairView.
 *
 * @author Jose Miguel Garcia Reyes
 */

data class RepairModel (
    var unitDepartment: String = "",
    var contactPhone: String = "",
    var petInUnit: String = "",
    var category: String = "",
    var problemDescription: String = "",
    var imageOrVideoFile: Uri = Uri.parse(""),
    var permissionToEnter: String = "",
)
