package com.iteneum.example

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.iteneum.designsystem.components.LpGenericCard

@Composable
fun ExampleView(){
    LpGenericCard(
        modifier = Modifier,
        title = "Current balance",
        details = "Go to payments",
        accountNumber = "0.00",
        currency = true,
        onTextClick = {}
    )
}