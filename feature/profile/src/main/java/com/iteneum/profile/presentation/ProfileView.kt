package com.iteneum.profile.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Mail
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iteneum.designsystem.components.LpEditFloatingActionButton
import com.iteneum.designsystem.components.LpOutlinedButton
import com.iteneum.profile.R

@Composable
fun ProfileView(

) {
    val userPhoto = painterResource(id = R.drawable.gato)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 7.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Box(modifier = Modifier.padding(horizontal = 0.dp, vertical = 10.dp)) {
                FilledIconButton(
                    onClick = { /*TODO*/ },
                    colors = IconButtonDefaults.filledIconButtonColors(MaterialTheme.colorScheme.inversePrimary)
                ) {
                    Icon(
                        Icons.Filled.ArrowBack,
                        contentDescription = "back button",
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.75f)
                    .padding(horizontal = 5.dp, vertical = 20.dp)
            ) {
                Text(
                    text = "Profile",
                    fontSize = 22.sp,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
            Column(
                modifier = Modifier.padding(all = 0.dp),
                horizontalAlignment = Alignment.End
            ) {
                LpEditFloatingActionButton(
                    color = MaterialTheme.colorScheme.inversePrimary,
                    colors = MaterialTheme.colorScheme.inversePrimary,
                    //elevation = FloatingActionButtonDefaults.elevation(0.dp),
                ) {}
            }
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(horizontal = 15.dp)) {
                Image(
                    painter = userPhoto,
                    contentDescription = "userPhoto",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                )
            }
            Column() {
                Box(modifier = Modifier.padding(vertical = 10.dp)) {
                    Text(
                        text = "Juan Islas",
                        fontWeight = FontWeight.Medium,
                        fontSize = 18.sp,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
                Box(modifier = Modifier.padding(top = 1.dp)) {
                    Text(text = "Apartment #101", color = MaterialTheme.colorScheme.tertiary)
                }
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 25.dp, end = 25.dp, top = 15.dp, bottom = 7.dp)
        ) {
            Icon(
                Icons.Outlined.Phone,
                contentDescription = "phone icon",
                modifier = Modifier.padding(end = 5.dp),
                tint = MaterialTheme.colorScheme.tertiary
            )
            Text(
                text = "(404) 979-2400",
                fontWeight = FontWeight.Normal,
                color = MaterialTheme.colorScheme.tertiary
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp, vertical = 7.dp)
        ) {
            Icon(
                Icons.Outlined.Mail,
                contentDescription = "mail icon",
                modifier = Modifier.padding(end = 5.dp),
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
                .padding(start = 25.dp, end = 25.dp, top = 7.dp, bottom = 15.dp)
        ) {
            Icon(
                Icons.Outlined.LocationOn,
                contentDescription = "location icon",
                modifier = Modifier.padding(end = 5.dp),
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
                .padding(horizontal = 25.dp, vertical = 10.dp),
            color = MaterialTheme.colorScheme.onPrimary
        )
        LpOutlinedButton(
            modifier = Modifier.padding(horizontal = 15.dp),
            textButton = "Payment Methods",
            //borderColor = MaterialTheme.colorScheme.onPrimary,
            //containerColor = MaterialTheme.colorScheme.primaryContainer,
            onClick = {})
        LpOutlinedButton(
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 0.dp),
            textButton = "Emergency Contacts",
            //borderColor = MaterialTheme.colorScheme.onPrimary,
            //containerColor = MaterialTheme.colorScheme.primaryContainer,
            onClick = {})
        LpOutlinedButton(
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 0.dp),
            textButton = "Log Out",
            //borderColor = MaterialTheme.colorScheme.onPrimary,
            //containerColor = MaterialTheme.colorScheme.primaryContainer,
            onClick = {})
    }
}
