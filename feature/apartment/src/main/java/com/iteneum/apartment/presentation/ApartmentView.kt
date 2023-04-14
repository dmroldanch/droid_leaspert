package com.iteneum.apartment.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import com.iteneum.designsystem.theme.LeasePertTheme
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iteneum.apartment.R
import com.iteneum.designsystem.components.LpOutlinedButton

@Composable
@Preview
fun ApartmentView() {
    ApartmentContainer()
}

@Composable
fun ApartmentContainer() {
    val dp12 = LeasePertTheme.sizes.midSmallSize
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = dp12, end = dp12)
            .verticalScroll(state = rememberScrollState())
    ) {
        Column {
            PaymentsSection()
            RepairsSection()
            InformationSection()
        }
    }
}

@Composable
fun PaymentsSection() {

}

@Composable
fun RepairsSection() {
    val dp8 = LeasePertTheme.sizes.smallerSize
    val dp16 = LeasePertTheme.sizes.middleSize
    val dp20 = LeasePertTheme.sizes.minorRegularSize
    val onPrimary = MaterialTheme.colorScheme.onPrimary

    Column() {
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = stringResource(id = R.string.repairs),
                color = MaterialTheme.colorScheme.tertiary,
                fontSize = 20.sp
            )
        }

        RepairStatusRow(modifier = Modifier.fillMaxWidth(), title = stringResource(id = R.string.open))

        Divider(
            thickness = 1.dp,
            color = onPrimary,
            modifier = Modifier.padding(start = dp16, end = dp16)
        )

        RepairStatusRow(modifier = Modifier.fillMaxWidth(), title = stringResource(id = R.string.in_progress))


        Divider(
            thickness = 1.dp,
            color = onPrimary,
            modifier = Modifier.padding(start = dp16, end = dp16)
        )

        RepairStatusRow(modifier = Modifier.fillMaxWidth(), title = stringResource(id = R.string.closed))

    }
}

@Composable
fun RepairStatusRow(modifier: Modifier = Modifier, title: String, quantity: Int = 0){
    Row(modifier = modifier
        .padding(start = LeasePertTheme.sizes.minorRegularSize,
            end = LeasePertTheme.sizes.minorRegularSize,
            top = LeasePertTheme.sizes.smallerSize,
            bottom = LeasePertTheme.sizes.smallerSize)
        , horizontalArrangement = Arrangement.SpaceBetween) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodyLarge
        )

        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(MaterialTheme.shapes.extraLarge)
                .background(color = MaterialTheme.colorScheme.secondaryContainer),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = quantity.toString(),
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
    }
}


@Composable
fun InformationSection() {
    Column(modifier = Modifier.padding(top = 12.dp)) {
        Text(
            text = stringResource(id = R.string.information),
            color = MaterialTheme.colorScheme.tertiary,
            fontSize = 20.sp
        )

        LpOutlinedButton(
            modifier = Modifier,
            textButton = stringResource(id = R.string.leasing_documents)
        ) {

        }

        LpOutlinedButton(
            modifier = Modifier,
            textButton = stringResource(id = R.string.apartment_photos)
        ) {

        }

        LpOutlinedButton(
            modifier = Modifier,
            textButton = stringResource(id = R.string.current_status)
        ) {

        }
    }
}

@Composable
fun roundFormExperimental(quantity: Int) {
    /*
    FilledTonalIconButton(enabled = false, onClick = { /*TODO*/ }) {
        Text(
            text = "1",
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
*/

    Box(
        modifier = Modifier
            .size(40.dp)
            .clip(CircleShape)
            .background(color = MaterialTheme.colorScheme.secondaryContainer),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = quantity.toString(),
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}

/*TODO Crear tarea para desarrollar input chip y asignarla a juan*/
