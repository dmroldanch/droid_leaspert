package com.iteneum

import com.itenum.domain.ContactTelephone
import com.itenum.domain.Email

data class OfficeInfoItemModel(
    val address: String,
    val schedule: String,
    val phone: ContactTelephone,
    var email: Email,
)
