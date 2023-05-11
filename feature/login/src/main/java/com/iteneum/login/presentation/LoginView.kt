package com.iteneum.login.presentation

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.AnnotatedString
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
import com.iteneum.designsystem.R.drawable.facebook_logo
import com.iteneum.designsystem.R.drawable.google_logo
import com.iteneum.designsystem.R.drawable.leasepert_logo
import com.iteneum.designsystem.R.drawable.twitter_logo
import com.iteneum.designsystem.components.LpFilledTonalButton
import com.iteneum.designsystem.components.LpOutlinedTextFieldMail
import com.iteneum.designsystem.components.LpOutlinedTextFieldPassword
import com.iteneum.designsystem.theme.LeasePertTheme
import com.iteneum.login.R

/**
 * Function that creates [LoginView] compose. This screen is used by the user to login on their account
 * User will require to fill the correspondent information, such as email or password, or login
 * with a social network
 *
 * @author Jesus Lopez
 */
@Composable
fun LoginView(
    navigationToDashboard: () -> Unit,
    loginViewModel: LoginViewModel = hiltViewModel()
) {

    LaunchedEffect(loginViewModel.isSuccess) {
        if (loginViewModel.isSuccess) {
            navigationToDashboard()
        }
    }

    val sizes = LeasePertTheme.sizes

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        val (logo, emailField, passwordField, loginButton, loginWith, socialNetworkLogins, registerButton) = createRefs()
        val focusRequester = remember { FocusRequester() }

        Image(
            painter = painterResource(id = leasepert_logo),
            contentDescription = stringResource(R.string.lv_logo),
            modifier = Modifier
                .size(sizes.extraSize142)
                .constrainAs(logo) {
                    top.linkTo(parent.top, margin = sizes.extraSize100)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
        LpOutlinedTextFieldMail(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = sizes.extraSize36, end = sizes.extraSize36)
                .constrainAs(emailField) {
                    top.linkTo(
                        logo.bottom,
                        goneMargin = sizes.extraSize100,
                        margin = sizes.extraSize100
                    )
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            label = stringResource(R.string.lv_email),
            placeholder = stringResource(R.string.lv_example_email),
            isValid = loginViewModel.isEmailError,
            onImeActionPerformed = { focusRequester.requestFocus() },
            supportTextError = stringResource(R.string.lv_valid_email_error),
            value = loginViewModel.email.value,
            onValueChanged = { newEmail ->
                loginViewModel.onEmailChanged(newEmail)
            }
        )
        LpOutlinedTextFieldPassword(
            modifier = Modifier
                .fillMaxWidth()
                .focusRequester(focusRequester)
                .padding(start = sizes.extraSize36, end = sizes.extraSize36)
                .constrainAs(passwordField) {
                    top.linkTo(emailField.bottom, margin = sizes.middleSize)
                    start.linkTo(emailField.start)
                    end.linkTo(emailField.end)
                },
            onPasswordChanged = { loginViewModel.onPasswordChanged(it) },
            supportTextError = stringResource(R.string.lv_support_text_error),
            isValid = loginViewModel.isPasswordError,
            labelText = stringResource(R.string.lv_password),
            passwordVisible = loginViewModel.passwordVisible,
            value = loginViewModel.password.value,
            onPasswordVisibilityChanged = { loginViewModel.onPasswordVisibilityChanged() }
        )
        LpFilledTonalButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = sizes.extraSize36, end = sizes.extraSize36)
                .constrainAs(loginButton) {
                    top.linkTo(passwordField.bottom, margin = sizes.extraSize18)
                    start.linkTo(passwordField.start)
                    end.linkTo(passwordField.end)
                    width = Dimension.fillToConstraints
                },
            textButton = stringResource(R.string.lv_login),
            onClicked = {
                loginViewModel.onLoginClicked()
            },
        )
        Text(
            modifier = Modifier
                .constrainAs(loginWith) {
                    top.linkTo(loginButton.bottom, margin = sizes.extraSize14)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            text = stringResource(R.string.lv_login_with),
            style = MaterialTheme.typography.bodyMedium
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(space = sizes.mediumSize),
            modifier = Modifier.constrainAs(socialNetworkLogins) {
                top.linkTo(loginWith.bottom, margin = sizes.smallerSize)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        ) {
            Box(
                modifier = Modifier
                    .wrapContentSize(align = Alignment.Center)
                    .size(sizes.extraSize42)
                    .border(
                        width = sizes.stroke,
                        color = MaterialTheme.colorScheme.onPrimary,
                        shape = RoundedCornerShape(sizes.extraSize6)
                    )
            ) {
                Icon(
                    modifier = Modifier
                        .padding(sizes.extraSize6)
                        .clickable { /*TODO("Will start the logging in process with Google")*/ },
                    imageVector = ImageVector.vectorResource(id = google_logo),
                    contentDescription = stringResource(R.string.lv_google_logo_description),
                    tint = Color.Unspecified
                )
            }
            Box(
                modifier = Modifier
                    .wrapContentSize(align = Alignment.Center)
                    .size(sizes.extraSize42)
                    .border(
                        width = sizes.stroke,
                        color = MaterialTheme.colorScheme.onPrimary,
                        shape = RoundedCornerShape(sizes.extraSize6)
                    ),
            ) {
                Icon(
                    modifier = Modifier
                        .padding(sizes.extraSize6)
                        .clickable { /*TODO("Will start the logging in process with twitter")*/ },
                    imageVector = ImageVector.vectorResource(id = twitter_logo),
                    contentDescription = stringResource(R.string.lv_twitter_logo_description),
                    tint = Color.Unspecified
                )
            }
            Box(
                modifier = Modifier
                    .wrapContentSize(align = Alignment.Center)
                    .size(sizes.extraSize42)
                    .border(
                        width = sizes.stroke,
                        color = MaterialTheme.colorScheme.onPrimary,
                        shape = RoundedCornerShape(sizes.extraSize6)
                    )
            ) {
                Icon(
                    modifier = Modifier
                        .padding(sizes.extraSize6)
                        .clickable { /*TODO("Will start the logging in process with facebook")*/ },
                    imageVector = ImageVector.vectorResource(id = facebook_logo),
                    contentDescription = stringResource(R.string.lv_facebook_logo_description),
                    tint = Color.Unspecified
                )
            }
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(sizes.minorSmallSize),
            modifier = Modifier.constrainAs(registerButton) {
                top.linkTo(socialNetworkLogins.bottom, margin = sizes.regularSize)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom, margin = sizes.extraSize10)
            }
        ) {
            Text(
                text = stringResource(R.string.lv_new_to_leasepert),
                style = MaterialTheme.typography.bodyMedium
            )
            ClickableText(
                text = AnnotatedString(stringResource(R.string.lv_register)),
                onClick = { /*TODO("Will open a register account window or screen")*/ },
                style = MaterialTheme.typography.labelLarge.copy(
                    color = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    }
}
