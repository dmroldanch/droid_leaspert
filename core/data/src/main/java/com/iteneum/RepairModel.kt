package com.iteneum

/**
 * File that contains [RepairModel] definition data class.
 * It contains all the text field values to be stored from the RepairView.
 *
 * @author Jose Miguel Garcia Reyes
 */

data class RepairModel (
    val unitDepartment: Int,
    val contactPhone: String = "",
    val petInUnit: String = "",
    val category: String = "",
    val problemDescription: String = "",
    val videoFile: Any? = null,
    val permissionToEnter: String = "",
)
