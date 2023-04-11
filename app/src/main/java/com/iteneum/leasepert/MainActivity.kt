package com.iteneum.leasepert

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.iteneum.designsystem.theme.LeasePertTheme
import dagger.hilt.android.AndroidEntryPoint
import com.iteneum.office.presentation.OfficeUI

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LeasePertTheme {

            }
        }
    }
}

