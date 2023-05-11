package com.iteneum.notification.domain.models

data class NotificationDomain(
    val typeNotification: Int,
    val date : String,
    val body : String
)