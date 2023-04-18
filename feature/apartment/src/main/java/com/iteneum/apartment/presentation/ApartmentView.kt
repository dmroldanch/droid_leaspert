package com.iteneum.apartment.presentation

import androidx.compose.foundation.*
import com.iteneum.designsystem.theme.LeasePertTheme
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
    Column() {
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = stringResource(id = R.string.payments),
                color = MaterialTheme.colorScheme.tertiary,
                fontSize = 20.sp
            )
        }
        Row() {
            cardFormExperimental()
        }
    }
}

@Composable
fun RepairsSection() {
    Column() {
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = stringResource(id = R.string.repairs),
                color = MaterialTheme.colorScheme.tertiary,
                fontSize = 20.sp
            )
        }

        RepairStatusRow(
            modifier = Modifier.fillMaxWidth(),
            titleStatusRepairs = stringResource(id = R.string.open)
        )

        Divider(
            thickness = LeasePertTheme.sizes.stroke,
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.padding(
                start = LeasePertTheme.sizes.middleSize,
                end = LeasePertTheme.sizes.middleSize
            )
        )

        RepairStatusRow(
            modifier = Modifier.fillMaxWidth(),
            titleStatusRepairs = stringResource(id = R.string.in_progress)
        )

        Divider(
            thickness = LeasePertTheme.sizes.stroke,
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.padding(
                start = LeasePertTheme.sizes.middleSize,
                end = LeasePertTheme.sizes.middleSize
            )
        )

        RepairStatusRow(
            modifier = Modifier.fillMaxWidth(),
            titleStatusRepairs = stringResource(id = R.string.closed)
        )

    }
}

@Composable
fun RepairStatusRow(
    modifier: Modifier = Modifier,
    titleStatusRepairs: String,
    quantityStatusRepairs: Int = 0,
) {
    Row(
        modifier = modifier
            .padding(
                start = LeasePertTheme.sizes.minorRegularSize,
                end = LeasePertTheme.sizes.minorRegularSize
            ), horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            modifier = Modifier.padding(top = LeasePertTheme.sizes.smallSize, bottom = 17.dp),
            text = titleStatusRepairs,
            style = MaterialTheme.typography.bodyLarge
        )

        Box(
            modifier = Modifier
                .padding(bottom = LeasePertTheme.sizes.smallerSize, top = 9.dp)
                .size(LeasePertTheme.sizes.largeSize)
                .clip(MaterialTheme.shapes.extraLarge)
                .background(color = MaterialTheme.colorScheme.secondaryContainer),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = quantityStatusRepairs.toString(),
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
    }
}

@Composable
fun InformationSection() {
    Column(modifier = Modifier.padding(top = LeasePertTheme.sizes.midSmallSize)) {
        Text(
            text = stringResource(id = R.string.information),
            color = MaterialTheme.colorScheme.tertiary,
            fontSize = 20.sp
        )

        LpOutlinedButton(
            modifier = Modifier.padding(top = 14.dp),
            textButton = stringResource(id = R.string.leasing_documents)
        ) {

        }

        LpOutlinedButton(
            modifier = Modifier.padding(top = 7.dp),
            textButton = stringResource(id = R.string.apartment_photos)
        ) {

        }

        LpOutlinedButton(
            modifier = Modifier.padding(top = 7.dp),
            textButton = stringResource(id = R.string.current_status)
        ) {

        }
    }
}


@Composable
fun cardFormExperimental() {
    //date: String, quantity: Double
    Row(modifier = Modifier
        .background(color = MaterialTheme.colorScheme.secondaryContainer)
        .fillMaxWidth()) {
        Text(text = "Perros")
    }
}


@Composable
fun roundFormExperimental(quantityStatusRepairs: Int) {
    Box(
        modifier = Modifier
            .padding(bottom = LeasePertTheme.sizes.smallerSize, top = 9.dp)
            .size(LeasePertTheme.sizes.largeSize)
            .clip(MaterialTheme.shapes.extraLarge)
            .background(color = MaterialTheme.colorScheme.secondaryContainer),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = quantityStatusRepairs.toString(),
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}
