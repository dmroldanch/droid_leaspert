package com.itenum.domain

/**
 * This interface represents the contract to implement an intent to make a call or send an email
 * which implementations left delegated to whoever wants or needs to create this type of behaviour
 * inside the app
 *
 * @author Andres Ivan Medina
 */
interface IintentActions {
    fun makeCall(phoneNumber: ContactTelephone)
    fun sendEmail(email: Email)
}