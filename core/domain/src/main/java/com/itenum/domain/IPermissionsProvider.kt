package com.itenum.domain

/**
 * This class is the interface contract that provides a method to determine if permissions
 * were granted
 *
 * @author Andres Ivan Medina
 */
interface IPermissionsProvider {

    fun isCallPermissionGranted(): Boolean

}