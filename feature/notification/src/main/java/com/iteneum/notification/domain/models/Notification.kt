package com.iteneum.notification.domain.models

data class Notification(
    val type : Int,
    val date : String,
    val body : String
)