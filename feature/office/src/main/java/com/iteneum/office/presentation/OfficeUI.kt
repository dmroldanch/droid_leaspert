package com.iteneum.office.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.outlined.Mail
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iteneum.designsystem.components.LpOutlinedButton
import com.iteneum.office.R

/**
 * This function creates the Office screen UI
 *With the Outlined buttons and the company information
 * @author Yaritza Moreno
 */
@Composable
fun OfficeUI() {
    
    Column() {

        val textStyleInfo = TextStyle(
            textAlign = TextAlign.Justify,
            color = Color.Gray,
            fontFamily = FontFamily.SansSerif,
            fontSize = 20.sp,
            lineHeight = 20.sp,
            textIndent = TextIndent(firstLine = 14.sp)
        )

        Text(text = "Information",
            modifier = Modifier
                .width(118.dp)
                .height(25.dp),
            style = textStyleInfo)

        val textStyle = TextStyle(
            textAlign = TextAlign.Justify,
            lineHeight = 20.sp,
            textIndent = TextIndent(firstLine = 14.sp, restLine = 3.sp)
        )

        Spacer(Modifier.size(10.dp))

        Text(text = stringResource(id = R.string.LPAddress),
            style = textStyle)

        Text(text = stringResource(id = R.string.LPHours),
            style = textStyle)

        Spacer(Modifier.size(10.dp))

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
    /*TODO*/
}