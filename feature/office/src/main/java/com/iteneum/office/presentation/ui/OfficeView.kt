package com.iteneum.office.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.outlined.Mail
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.iteneum.designsystem.components.LpOutlinedButton
import com.iteneum.designsystem.theme.LeasePertTheme
import com.iteneum.office.R

/**
 * This function creates the Office screen UI
 * With the Outlined buttons and the company information
 * @param vm injects the viewModel into the UI
 * @author Yaritza Moreno
 */
@Composable
fun OfficeUI(
    viewModel: OfficeViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    viewModel
    val schedule = stringResource(id = R.string.LPHours)
    val address  = stringResource(R.string.LPAddress)
    var email    = stringResource(R.string.LPcontactEmail)
    val phone    = stringResource(R.string.LPphoneServiceContact)
    val windowTitle = stringResource(R.string.LPInfo)
    //Get sizes from LeasePertTheme archive
    val sizes = LeasePertTheme.sizes
    Column(Modifier.fillMaxSize()) {
        Text(
            text = windowTitle,
            modifier = Modifier
                .width(sizes.extraSize124)
                .height(sizes.regularSize),
            style = TextStyle(
                textAlign = TextAlign.Justify,
                color = MaterialTheme.colorScheme.tertiary,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                lineHeight = 20.sp,
                textIndent = TextIndent(firstLine = 14.sp)
            )
        )
        Text(
            text =  address,
            style = TextStyle(
                textAlign = TextAlign.Justify,
                lineHeight = 20.sp,
                textIndent = TextIndent(firstLine = 14.sp, restLine = 3.sp)
            ),
            modifier = Modifier.padding(top = sizes.extraSize10)
        )

        Text(
            text =  schedule,
            modifier = Modifier.padding(top = sizes.extraSize10),
            style = TextStyle(
                textAlign = TextAlign.Justify,
                lineHeight = 20.sp,
                textIndent = TextIndent(firstLine = 14.sp, restLine = 3.sp)
            )
        )
        LpOutlinedButton(modifier = Modifier,
            icon = Icons.Filled.Call,
            textButton = stringResource(id = R.string.LPCallButton),
            onClicked = {
                viewModel.makeCall(phone)
            })
        LpOutlinedButton(modifier = Modifier,
            icon = Icons.Outlined.Mail,
            textButton = stringResource(id = R.string.LPMailButton),
            onClicked = {
                viewModel.sendEmail(
                    email,
                    "mail test",
                    "this is a mail send test",
                )
            })
    }
}
