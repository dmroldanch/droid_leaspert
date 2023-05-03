package com.iteneum.profile.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Mail
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material3.Divider
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.iteneum.designsystem.components.LpFloatingActionIconButton
import com.iteneum.designsystem.components.LpOutlinedButton
import com.iteneum.designsystem.theme.LeasePertTheme
import com.iteneum.profile.R

@Composable
fun ProfileView(
    /*TODO expected parameters as navigation and view model*/
) {
    val sizes = LeasePertTheme.sizes

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = sizes.smallerSize)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Box(
                modifier = Modifier.padding(
                    horizontal = sizes.nothingSize,
                    vertical = sizes.midSmallSize
                )
            ) {
                /*TODO here will be a nav component*/
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.75f)
                    .padding(horizontal = sizes.minorSmallSize, vertical = sizes.minorRegularSize)
            ) {
                Text(
                    text = stringResource(id = R.string.profile),
                    fontSize = 22.sp,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
            Column(
                modifier = Modifier.padding(all = sizes.nothingSize),
                horizontalAlignment = Alignment.End
            ) {
                LpFloatingActionIconButton(
                    containerColor = MaterialTheme.colorScheme.inversePrimary,
                    elevation = FloatingActionButtonDefaults.elevation(sizes.nothingSize),
                    icon = Icons.Outlined.Edit,
                    contentDescription = stringResource(R.string.content_description_edit),
                    onClicked = {/*TODO expected change in the values of user's phone number, email or address*/ }
                )
            }
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(horizontal = sizes.smallSize)) {
                Image(
                    painter = painterResource(id = R.drawable.default_user_photo),
                    contentDescription = stringResource(R.string.user_photo),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(sizes.extraSize78)
                        .clip(CircleShape)
                )
            }
            Column {
                Text(
                    text = "Juan Islas",
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    modifier = Modifier.padding(vertical = sizes.midSmallSize)
                )
                Text(
                    text = "Apartment #101",
                    color = MaterialTheme.colorScheme.tertiary,
                    modifier = Modifier.padding(top = sizes.stroke)
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = sizes.regularSize,
                    end = sizes.regularSize,
                    top = sizes.smallSize,
                    bottom = sizes.smallerSize
                )
        ) {
            Icon(
                Icons.Outlined.Phone,
                contentDescription = stringResource(id = R.string.phone_icon),
                modifier = Modifier.padding(end = sizes.minorSmallSize),
                tint = MaterialTheme.colorScheme.tertiary
            )
        }
        Text(
            text = "(404) 979-2400",
            fontWeight = FontWeight.Normal,
            color = MaterialTheme.colorScheme.tertiary
        )

    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = sizes.regularSize, vertical = sizes.smallerSize)
    ) {

        Icon(
            Icons.Outlined.Mail,
            contentDescription = stringResource(id = R.string.mail_icon),
            modifier = Modifier.padding(end = sizes.minorSmallSize),
            tint = MaterialTheme.colorScheme.tertiary
        )
        Text(
            text = "juan.islas@mail.com",
            fontWeight = FontWeight.Normal,
            color = MaterialTheme.colorScheme.tertiary
        )
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = sizes.regularSize,
                end = sizes.regularSize,
                top = sizes.smallerSize,
                bottom = sizes.smallSize
            )
    ) {
        Icon(
            Icons.Outlined.LocationOn,
            contentDescription = stringResource(id = R.string.location_icon),
            modifier = Modifier.padding(end = sizes.minorSmallSize),
            tint = MaterialTheme.colorScheme.tertiary
        )
        Text(
            text = "4950 Gaidrew, Alpharetta, GA, 30022",
            fontWeight = FontWeight.Normal,
            color = MaterialTheme.colorScheme.tertiary
        )
    }
    Divider(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = sizes.minorRegularSize, vertical = sizes.midSmallSize),
        color = MaterialTheme.colorScheme.onPrimary
    )
    LpOutlinedButton(
        modifier = Modifier
            .padding(
                horizontal = sizes.smallSize,
                vertical = sizes.minorSmallSize
            ),
        textButton = stringResource(id = R.string.payment_methods),
        onClicked = { /*TODO high order function for payment methods*/ })
    LpOutlinedButton(
        modifier = Modifier
            .padding(
                horizontal = sizes.smallSize,
                vertical = sizes.minorSmallSize
            ),
        textButton = stringResource(id = R.string.emergency_contacts),
        onClicked = { /*TODO high order function for emergency contacts*/ })
    LpOutlinedButton(
        modifier = Modifier
            .padding(
                horizontal = sizes.smallSize,
                vertical = sizes.minorSmallSize
            ),
        textButton = stringResource(id = R.string.log_out),
        onClicked = { /*TODO log out and return to the login view*/ })
}

