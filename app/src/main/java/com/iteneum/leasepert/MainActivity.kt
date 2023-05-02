package com.iteneum.leasepert

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.iteneum.designsystem.theme.LeasePertTheme
import com.iteneum.office.presentation.ui.OfficeUI
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LeasePertTheme {
                OfficeUI()
            }
        }
    }
}

