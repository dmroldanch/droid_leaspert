package com.iteneum.apartment.domain

/**
[PaymentDetails] is a data class that represents payments details. It contains three properties:

[currentMonth]: A string of the current month.
[rentDebt]: A float representing the amount of rent to pay.
[deadline]: A string representing the deadline of the payment amount.
This data class is used to store and manipulate information about payment in the context of the application.

@author Juan Islas
 **/

data class PaymentDetails(
    val currentMonth: String?,
    val rentDebt: Float = 0f,
    val deadline: String?
)