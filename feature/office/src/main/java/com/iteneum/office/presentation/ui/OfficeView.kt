package com.iteneum.office.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.outlined.Mail
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import com.iteneum.designsystem.components.LPBodyMedium
import com.iteneum.designsystem.components.LPTitleLarge
import com.iteneum.designsystem.components.LpOutlinedButton
import com.iteneum.designsystem.theme.LeasePertTheme
import com.iteneum.office.R
import com.iteneum.office.domain.Office

/**
 * function: OfficeView  will handle:
 * Exposing to the UI the Office information,
 * working as container for OfficeUI function.
 * @author Andres Ivan Medina
 */

@Composable
fun OfficeView(viewModel: OfficeViewModel = hiltViewModel()) {

    LaunchedEffect(true) {
        viewModel.getOfficeInformation()
    }

    val uiState = viewModel.state.collectAsState()

    when (uiState.value) {
        is OfficeStateResponse.Error -> {
            ShowStateContent(stringResource(R.string.Error))
        }

        is OfficeStateResponse.Loading -> {
            ShowStateContent(stringResource(R.string.Loading))
        }

        is OfficeStateResponse.Success -> {
            val OfficeData = viewModel.officeInfo

            OfficeData?.let {
                OfficeUI(
                    it,
                    onCallButtonClicked = { viewModel.makeCall() },
                    onEmailButtonClicked = { viewModel.sendEmail() }
                )
            }
        }
    }

}

@Composable
fun ShowStateContent(response: String) {
    LPTitleLarge(
        label = response,
        color = MaterialTheme.colorScheme.tertiary,
        weight = FontWeight.Bold
    )
}

/**
 * function: OfficeUI creates the Office screen UI
 * @param onCallButtonClicked launches the call intent
 * @param onEmailButtonClicked launches the Email intent
 * @author Yaritza Moreno
 * Modified by:
 * @modifiedBy Andres Ivan Medina
 */
@Composable
fun OfficeUI(
    officeData: Office,
    onCallButtonClicked: () -> Unit,
    onEmailButtonClicked: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        val sizes = LeasePertTheme.sizes
        LPTitleLarge(label = stringResource(
            id = R.string.LPInfo
        ),
            color = MaterialTheme.colorScheme.tertiary,
            textAlign = TextAlign.Justify,
            weight = FontWeight.Bold,
            onClick = {})
        LPBodyMedium(modifier = Modifier.padding(top = sizes.extraSize10),
            label = officeData.address,
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            textAlign = TextAlign.Justify,
            weight = FontWeight.Normal,
            onClick = {})
        LPBodyMedium(modifier = Modifier.padding(top = sizes.extraSize10),
            label = stringResource(id = R.string.LPHours) + officeData.schedule,
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            textAlign = TextAlign.Justify,
            weight = FontWeight.Normal,
            onClick = {})
        LpOutlinedButton(Modifier.padding(top = sizes.extraSize10),
            icon = Icons.Filled.Call,
            textButton = stringResource(id = R.string.LPCallButton),
            onClicked = {
                onCallButtonClicked()
            })
        LpOutlinedButton(Modifier.padding(top = sizes.extraSize10),
            icon = Icons.Outlined.Mail,
            textButton = stringResource(id = R.string.LPMailButton),
            onClicked = {
                onEmailButtonClicked()
            }
        )
    }
}


