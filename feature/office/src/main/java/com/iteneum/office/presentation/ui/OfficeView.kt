package com.iteneum.office.presentation.ui

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.outlined.Mail
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.unit.sp
import com.iteneum.IntentActionsImpl
import com.iteneum.OfficeInfoItemModel
import com.iteneum.PermissionsProviderImpl
import com.iteneum.designsystem.components.LpOutlinedButton
import com.iteneum.designsystem.theme.LeasePertTheme
import com.iteneum.office.R

/**
 * This class will handle the network states responses, i modification with the structure.
 * @param onClickItem click back when you do it on an item
 * @param onSuccess our event that send us to the next view
 * TODO implement @param viewModel the view model we are using inside our view compose has to be injected
 * /*viewModel: OfficeViewModel = hiltViewModel()*/
 * @author Andres Ivan Medina
 */
@Composable
fun OfficeView() {
    val viewModel = OfficeViewModel(
        IntentActionsImpl(
            LocalContext.current, PermissionsProviderImpl(
                LocalContext.current
            )
        )
    )
    LaunchedEffect(true) {
        viewModel.loadOfficeInformationData()
    }
    val officeDataList = remember {
        viewModel.dataOfficeInfo
    }
    OfficeUI(
        officeDataList,
        onCallButtonClicked = { viewModel.makeCall() },
        onEmailButtonClicked = { viewModel.sendEmail() }
    )
}

/**
 * This function creates the Office screen UI
 * @param onCallButtonClicked launches the call intent
 * @param onEmailButtonClicked launches the Email intent
 * @author Yaritza Moreno
 * Modified by:
 * @author Andres Ivan Medina
 */
@Composable
fun OfficeUI(
    list: List<OfficeInfoItemModel>,
    onCallButtonClicked: () -> Unit,
    onEmailButtonClicked: () -> Unit,
) {
    val schedule = list[0].schedule
    val address = list[0].address
    val email = list[0].email
    val phone = list[0].phone

    Log.d("DATA_COMPOSE", "${schedule},${address},${email},${phone}")
    //Get sizes from LeasePertTheme archive
    val sizes = LeasePertTheme.sizes
    Column(Modifier.fillMaxSize()) {
        Text(
            text = stringResource(R.string.LPInfo),
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
            text = address, style = TextStyle(
                textAlign = TextAlign.Justify,
                lineHeight = 20.sp,
                textIndent = TextIndent(firstLine = 14.sp, restLine = 3.sp)
            ), modifier = Modifier.padding(top = sizes.extraSize10)
        )

        Text(
            text = stringResource(id = R.string.LPHours) + schedule,
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
                onCallButtonClicked()
            })
        LpOutlinedButton(modifier = Modifier,
            icon = Icons.Outlined.Mail,
            textButton = stringResource(id = R.string.LPMailButton),
            onClicked = {
                onEmailButtonClicked()
            })
    }
}
