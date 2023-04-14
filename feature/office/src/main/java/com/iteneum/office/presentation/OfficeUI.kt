package com.iteneum.office.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iteneum.designsystem.components.LpOutlinedButton
import com.iteneum.designsystem.theme.LeasePertTheme
import com.iteneum.office.R

/**
 * This function creates the Office screen UI
 *With the Outlined buttons and the company information
 * @author Yaritza Moreno
 */
@Composable
fun OfficeUI() {
    
    Column() {

        //Get sizes from LeasePertTheme archive
        val sizes = LeasePertTheme.sizes

        Text(text = stringResource(id = R.string.LPInfo),
            modifier = Modifier
                .width(sizes.extraSize124)
                .height(sizes.regularSize),
            style = TextStyle(textAlign = TextAlign.Justify, color = Color.Gray,
                fontFamily = FontFamily.SansSerif,
                fontSize = 20.sp,
                lineHeight = 20.sp,
                textIndent = TextIndent(firstLine = 14.sp)))

        Text(text = stringResource(id = R.string.LPAddress),
            style = TextStyle(textAlign = TextAlign.Justify,
                lineHeight = 20.sp,
                textIndent = TextIndent(firstLine = 14.sp, restLine = 3.sp)),
            modifier = Modifier.padding(top = sizes.extraSize10))

        Text(text = stringResource(id = R.string.LPHours),
            modifier = Modifier.padding(top = 10.dp),
            style = TextStyle(textAlign = TextAlign.Justify,
                lineHeight = 20.sp,
                textIndent = TextIndent(firstLine = 14.sp, restLine = 3.sp)))

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
