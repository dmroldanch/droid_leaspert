package com.iteneum

import java.sql.Timestamp

/**
 * [ApartmentModel] The apartment model is the data model what will contain all the information, this information will be displayed up in
 * ApartmentView and the user can to see
 *
 * @author Usiel Filiberto Garcia Jimenez
 */
data class ApartmentModel(
    val month: String,
    val quantity: String = "0.0",
    val limitDateToPay: String = "",
    val repairStatusOpen: String = "",
    val repairStatusInProgres: String = "",
    val repairStatusClosed: String =""
)

