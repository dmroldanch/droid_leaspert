package com.iteneum.profile.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
import com.iteneum.designsystem.theme.Drab
import com.iteneum.profile.R

@Composable
fun ProfileView(){
    val userPhoto = painterResource(id = R.drawable.gato)
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(all = 7.dp)) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Box(modifier = Modifier.padding(horizontal = 0.dp, vertical = 10.dp)) {
                FilledIconButton(
                    onClick = { /*TODO*/ },
                    colors = IconButtonDefaults.filledIconButtonColors(MaterialTheme.colorScheme.inversePrimary)
                ) {
                    Icon(
                        Icons.Filled.ArrowBack,
                        contentDescription = "back button",
                        tint = Drab
                    )
                }
            }
            Box(modifier = Modifier
                .fillMaxWidth(0.75f)
                .padding(horizontal = 5.dp, vertical = 20.dp)) {
                Text(text = "Profile", fontSize = 22.sp, color = MaterialTheme.colorScheme.onPrimaryContainer)
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
                    Text(text = "Juan Islas", fontWeight = FontWeight.Medium, fontSize = 18.sp, color = MaterialTheme.colorScheme.onPrimaryContainer)
                }
                Box(modifier = Modifier.padding(vertical = 5.dp)) {
                    Text(text = "Apartment #101", color = MaterialTheme.colorScheme.tertiary)
                }
            }
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            Icon(
                Icons.Filled.ArrowBack,
                contentDescription = "back button",
                tint = Drab
            )
            Text(text = "(404) 979-2400")
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            Icon(
                Icons.Filled.ArrowBack,
                contentDescription = "back button",
                tint = Drab
            )
            Text(text = "juan.islas@mail.com")
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            Icon(
                Icons.Filled.ArrowBack,
                contentDescription = "back button",
                tint = Drab
            )
            Text(text = "4950 Gaidrew, Alpharetta, GA, 30022")
        }
    }
}
