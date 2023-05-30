package com.iteneum.office.domain

/**
 * This class is for the data for each item in the list.
 * @param address the address of the busines
 * @param schedule the work hours of the business
 * @param phone the telephone number of the business
 * @param email electronic email of the business
 * @author Andres Ivan Medina
 */
data class Office(
    val address: String,
    val schedule: String,
    val phone: String,
    var email: String,
)