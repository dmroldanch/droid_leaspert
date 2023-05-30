package com.iteneum.apartment.domain

/**
[UserDetail] is a data class that represents payments and repair requests details. It contains four properties:

[paymentDetails]: A data class that represents payment user details.
[openRepairs]: An int representing the number of opened repair requests
[inProgress]: An int representing the number of "in progress" repair requests.
[closedRepairs]: An int representing the number of closed repair requests.
This data class is used to store and manipulate information about payment and repair request in the context of the application.

@author Juan Islas
 **/

data class UserDetail(
    val paymentDetails: PaymentDetails?,
    val openRepairs: Int = 0,
    val inProgress: Int = 0,
    val closedRepairs: Int = 0,
)