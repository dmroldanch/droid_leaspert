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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import com.iteneum.designsystem.components.LPBodyLarge
import com.iteneum.designsystem.components.LPTitleLarge
import com.iteneum.designsystem.components.LPTitleMedium
import com.iteneum.designsystem.components.LpFloatingActionIconButton
import com.iteneum.designsystem.components.LpOutlinedButton
import com.iteneum.designsystem.theme.LeasePertTheme
import com.iteneum.profile.domain.Profile
import com.iteneum.profile.R
import com.iteneum.designsystem.R as R_DS

/**
 * Function that creates [ProfileView] compose, to visualize user's profile.
 * It will contain the personal user's data and more options related to profile.
 * @param backToDashBoard - high order function to return to previous view when clicking on up button
 * @param profileViewModel - to obtain the model view instance
 *
 * @author Juan Islas
 * @modifiedBy Jose Miguel Garcia Reyes
 */

@Composable
fun ProfileView(
    backToDashBoard: () -> Unit /* TODO - ProfileView - use when back arrow component is implemented */ ,
    profileViewModel: ProfileViewModel = hiltViewModel()
) {
    LaunchedEffect(true) {
        profileViewModel.getInformation()
    }
    ProfileContainer(
        profile = profileViewModel.profileModelMutable,
        onClickEditProfileButton = { profileViewModel.onClickEditProfileButton() },
        onClickPaymentMethodsButton = { profileViewModel.onClickPaymentMethodsButton() },
        onClickEmergencyContactsButton = { profileViewModel.onClickEmergencyContactsButton() },
        onClickLogOutButton = { profileViewModel.onClickLogOutButton() }
    )
}

/**
 * Function [ProfileContainer] contains the actual view of ProfileView.
 * It will generate the composable elements to create the user's profile.
 * @param profile - to get profile values passed from View Model
 * @param onClickEditProfileButton - high order function to handle action when clicking on Edit button
 * @param onClickPaymentMethodsButton - high order function to handle action when clicking on Payment Method button
 * @param onClickEmergencyContactsButton - high order function to handle action when clicking on Emergency button
 * @param onClickLogOutButton - high order function to handle action when clicking on Log Out button
 *
 * @author Juan Islas
 * @modifiedBy Jose Miguel Garcia Reyes
 */

@Composable
fun ProfileContainer(
    profile: Profile,
    onClickEditProfileButton: () -> Unit,
    onClickPaymentMethodsButton: () -> Unit,
    onClickEmergencyContactsButton: () -> Unit,
    onClickLogOutButton: () -> Unit
) {
    val sizes = LeasePertTheme.sizes
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = sizes.smallerSize)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .padding(
                        horizontal = sizes.nothingSize,
                        vertical = sizes.midSmallSize
                    )
            ) {
                /*TODO - ProfileView on ProfileContainer() - to add the backToDashBoard() call when implemented*/
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.75f)
                    .padding(
                        horizontal = sizes.minorSmallSize,
                        vertical = sizes.minorRegularSize
                    )
            ) {
                LPTitleLarge(
                    label = stringResource(id = R.string.profile),
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    weight = FontWeight.Bold
                )
            }
            Column(
                modifier = Modifier
                    .padding(
                        all = sizes.nothingSize
                    ),
                horizontalAlignment = Alignment.End
            ) {
                LpFloatingActionIconButton(
                    containerColor = MaterialTheme.colorScheme.inversePrimary,
                    elevation = FloatingActionButtonDefaults.elevation(sizes.nothingSize),
                    icon = Icons.Outlined.Edit,
                    contentDescription = stringResource(R.string.content_description_edit)
                ) {
                    onClickEditProfileButton()
                }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(modifier = Modifier
                .padding(
                    horizontal = sizes.smallSize
                )
            ) {
                Image(
                    painter = painterResource(id = R_DS.drawable.default_user_photo),
                    contentDescription = stringResource(R.string.user_photo),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(sizes.extraSize78)
                        .clip(CircleShape)
                )
            }
            Column {
                LPTitleLarge(
                    label = profile.name,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    weight = FontWeight.Medium
                )
                LPTitleMedium(
                    label = profile.apartment,
                    color = MaterialTheme.colorScheme.tertiary,
                    weight = FontWeight.Medium
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
            LPBodyLarge(
                label = profile.phoneNumber,
                color = MaterialTheme.colorScheme.tertiary,
                weight = FontWeight.Normal
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = sizes.regularSize,
                    vertical = sizes.smallerSize
                )
        ) {
            Icon(
                Icons.Outlined.Mail,
                contentDescription = stringResource(id = R.string.mail_icon),
                modifier = Modifier.padding(end = sizes.minorSmallSize),
                tint = MaterialTheme.colorScheme.tertiary
            )
            LPBodyLarge(
                label = profile.email,
                color = MaterialTheme.colorScheme.tertiary,
                weight = FontWeight.Normal
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
            LPBodyLarge(
                label = profile.address,
                color = MaterialTheme.colorScheme.tertiary,
                weight = FontWeight.Normal
            )
        }
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = sizes.minorRegularSize,
                    vertical = sizes.midSmallSize
                ),
            color = MaterialTheme.colorScheme.onPrimary
        )
        LpOutlinedButton(
            modifier = Modifier
                .padding(
                    horizontal = sizes.smallSize,
                    vertical = sizes.minorSmallSize
                ),
            textButton = stringResource(id = R.string.payment_methods),
            onClicked = { onClickPaymentMethodsButton() }
        )
        LpOutlinedButton(
            modifier = Modifier
                .padding(
                    horizontal = sizes.smallSize,
                    vertical = sizes.minorSmallSize
                ),
            textButton = stringResource(id = R.string.emergency_contacts),
            onClicked = { onClickEmergencyContactsButton() }
        )
        LpOutlinedButton(
            modifier = Modifier
                .padding(
                    horizontal = sizes.smallSize,
                    vertical = sizes.minorSmallSize
                ),
            textButton = stringResource(id = R.string.log_out),
            onClicked = { onClickLogOutButton() }
        )
    }
}
