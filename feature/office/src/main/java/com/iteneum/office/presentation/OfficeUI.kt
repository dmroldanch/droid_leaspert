package com.iteneum.office.presentation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.iteneum.designsystem.components.LpOutlinedButton

@Composable
fun OfficeUI() {
    LpOutlinedButton(modifier = Modifier,
        textButton = "Call",
        onClick = { onClick() } )
}

private fun onClick(){
    TODO()
}