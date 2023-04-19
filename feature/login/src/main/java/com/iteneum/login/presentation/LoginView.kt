package com.iteneum.login.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.iteneum.designsystem.components.LpFilledTonalButton
import com.iteneum.designsystem.components.LpOutlinedTextFieldMail
import com.iteneum.designsystem.components.LpOutlinedTextFieldPassword
import com.iteneum.designsystem.R.drawable.*
import com.iteneum.login.R


@Preview
@Composable
fun LoginView() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()

    ) {
        val (logo, mail, password, tonalButton, loginWith, socialNetworkLogins, registerButton) = createRefs()

        Image(
            painter = painterResource(id = leasepertlogo),
            contentDescription = stringResource(R.string.lv_logo),
            modifier = Modifier
                .size(143.dp, 142.dp)
                .constrainAs(logo) {
                    top.linkTo(parent.top, margin = 50.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
        LpOutlinedTextFieldMail(
            modifier = Modifier
                .constrainAs(mail) {
                    top.linkTo(logo.bottom, margin = 30.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            label = stringResource(R.string.lv_email),
            hint = stringResource(R.string.lv_enter_email_hint),
            isValid = false,
            supportTextError = stringResource(R.string.lv_support_text_error),
            onValueChange = {}
        )
        LpOutlinedTextFieldPassword(
            modifier = Modifier
                .constrainAs(password) {
                    top.linkTo(mail.bottom, margin = 2.dp)
                    start.linkTo(mail.start)
                    end.linkTo(mail.end)
                },
            onPasswordChange = {}
        )
        LpFilledTonalButton(
            modifier = Modifier
                .constrainAs(tonalButton) {
                    top.linkTo(password.bottom, margin = 18.dp)
                    start.linkTo(password.start)
                    end.linkTo(password.end)
                    width = Dimension.fillToConstraints
                },
            textButton = stringResource(R.string.lv_login),
            onClick = {},
        )
        Text(
            modifier = Modifier
                .constrainAs(loginWith) {
                    top.linkTo(tonalButton.bottom, margin = 14.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }, text = stringResource(R.string.lv_login_with)
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(32.dp),
            modifier = Modifier.constrainAs(socialNetworkLogins) {
                top.linkTo(loginWith.bottom, margin = 8.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        ) {
            Box(
                modifier = Modifier
                    .wrapContentSize(align = Alignment.Center)
                    .size(42.dp)
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        shape = RoundedCornerShape(6.dp)
                    )
            ) {
                Icon(
                    modifier = Modifier
                        .padding(2.dp)
                        .clickable {},
                    imageVector = ImageVector.vectorResource(id = googlelogo),
                    contentDescription = null
                )
            }
            Box(
                modifier = Modifier
                    .wrapContentSize(align = Alignment.Center)
                    .size(42.dp)
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        shape = RoundedCornerShape(6.dp)
                    ),
            ) {
                Icon(
                    modifier = Modifier
                        .padding(2.dp)
                        .clickable {},
                    imageVector = ImageVector.vectorResource(id = twitterlogo),
                    contentDescription = null
                )
            }
            Box(
                modifier = Modifier
                    .wrapContentSize(align = Alignment.Center)
                    .size(42.dp)
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        shape = RoundedCornerShape(6.dp)
                    )
            ) {
                Icon(
                    modifier = Modifier
                        .padding(2.dp)
                        .clickable {},
                    imageVector = ImageVector.vectorResource(id = facebooklogo),
                    contentDescription = null
                )
            }
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            modifier = Modifier.constrainAs(registerButton) {
                top.linkTo(socialNetworkLogins.bottom, margin = 24.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom, margin = 10.dp)
            }
        ) {
            Text(text = stringResource(R.string.lv_new_to_leasepert))
            ClickableText(
                text = AnnotatedString(stringResource(R.string.lv_register)),
                onClick = { },
                style = MaterialTheme.typography.labelLarge.copy(
                    color = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    }
}
