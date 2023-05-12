package com.iteneum

/**
 * File that contains [UIEventRepair] sealed class
 * It contains definitions of all the possible Events that will be catch on RepairView.
 *
 * @author Jose Miguel Garcia Reyes
 * @author Carlos Andres Perez Hernandez
 */

sealed class UIEventRepair {
    data class UnitDepartment(val unitDepartment: String) : UIEventRepair()
    data class ContactPhone(val contactPhone: String) : UIEventRepair()
    data class PetInUnit(val petInUnit: String) : UIEventRepair()
    data class Category(val category: String) : UIEventRepair()
    data class ProblemDescription(val problemDescription: String) : UIEventRepair()
    data class ImageOrVideoFile(val imageOrVideoFile: String) : UIEventRepair()
    data class PermissionToEnter(val permissionToEnter: String) : UIEventRepair()
}
