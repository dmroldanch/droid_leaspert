package com.iteneum.office.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.outlined.Mail
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.Paragraph
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.unit.sp
import com.iteneum.designsystem.components.LpOutlinedButton
import com.iteneum.office.R

@Composable
fun OfficeUI() {
    
    Column() {

        Text(text = "Information", modifier = Modifier)

        val textStyle = TextStyle(
            textAlign = TextAlign.Justify,
            lineHeight = 20.sp,
            textIndent = TextIndent(firstLine = 14.sp, restLine = 3.sp)
        )
        Text(
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
                    "incididunt ut labore et dolore magna aliqua.\nUt enim ad minim veniam, quis " +
                    "nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
            style = textStyle
        )

        LpOutlinedButton(modifier = Modifier,
            icon = Icons.Filled.Call,
            textButton = stringResource(id = R.string.LPCallButton),
            onClick = { /*TODO*/ } )

        LpOutlinedButton(modifier = Modifier,
            icon = Icons.Outlined.Mail,
            textButton = stringResource(id = R.string.LPMailButton),
            onClick = { /*TODO*/ } )
    }
}

private fun onClick(){
    TODO()
}