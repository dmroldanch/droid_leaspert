package com.iteneum.leasepert

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import com.iteneum.designsystem.components.LpOutlinedTextFieldMail
import com.iteneum.designsystem.components.LpOutlinedTextFieldNumber
import com.iteneum.designsystem.components.Preview_SingleRadioButton
import com.iteneum.designsystem.theme.LeasePertTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LeasePertTheme {

            }
        }
    }
}

