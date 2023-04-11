package com.iteneum.apartment.presentation

import android.provider.Settings.Panel
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.iteneum.designsystem.components.LpBasicCard
import com.iteneum.designsystem.components.LpFileButton
import com.iteneum.designsystem.components.LpOutlinedButton

@Composable
@Preview
fun ApartmentView() {
    ApartmentContainer()
}

@Composable
fun ApartmentContainer(){
    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxSize()
        .verticalScroll(state = rememberScrollState())){
        InformationSection()
    }
}

@Composable
fun PaymentsSection(){

}

@Composable
fun RepairsSection(){

}

@Composable
fun InformationSection(){
    Column() {

    }
}
//        Spacer(modifier = Modifier.height(20.dp))