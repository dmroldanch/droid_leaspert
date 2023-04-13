package com.iteneum.login.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.iteneum.designsystem.components.LpFilledTonalButton
import com.iteneum.designsystem.components.LpOutlinedButton
import com.iteneum.designsystem.components.LpOutlinedTextFieldMail
import com.iteneum.designsystem.components.LpOutlinedTextFieldPassword
import com.iteneum.designsystem.R.drawable.leasepertlogo

@Preview
@Composable
fun LoginView() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        val (logo, mail, password, tonalButton, googleButton, twitterButton, facebookButton) = createRefs()

        Image(
            painter = painterResource(id = leasepertlogo),
            contentDescription = "Logo",
            modifier = Modifier
                .size(143.dp, 142.dp)
                .constrainAs(logo) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )

        LpOutlinedTextFieldMail(
            modifier = Modifier
                .constrainAs(mail) {
                    top.linkTo(logo.bottom, margin = 50.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            label = "Email",
            hint = "Enter your email",
            isValid = false,
            supportTextError = "",
            onValueChange = {}
        )

        LpOutlinedTextFieldPassword(
            modifier = Modifier
                .constrainAs(password) {
                    top.linkTo(mail.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            onPasswordChange = {}
        )

        LpFilledTonalButton(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(tonalButton) {
                    top.linkTo(password.bottom, margin = 24.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            textButton = "Login",
            onClick = {},

        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(30.dp),
            modifier = Modifier.constrainAs(googleButton) {
                top.linkTo(tonalButton.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        ) {
            LpOutlinedButton(
                modifier = Modifier.size(36.dp),
                textButton = "",
                icon = Icons.Default.AccountCircle,
                onClick = {}
            )
            LpOutlinedButton(
                modifier = Modifier.size(36.dp),
                textButton = "",
                icon = Icons.Default.AccountCircle,
                onClick = {}
            )
            LpOutlinedButton(
                modifier = Modifier.size(36.dp),
                textButton = "",
                icon = Icons.Default.AccountCircle,
                onClick = {}
            )
        }
    }
}
