package com.iteneum.designsystem.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iteneum.designsystem.theme.Drab
import com.iteneum.designsystem.theme.LPTypography

@Composable
fun LPGenericElevatedCard(
    title: String,
    description: String,
    buttonText: String,
    onButtonClick: () -> Unit
) {
    val colors = MaterialTheme.colorScheme

    Card(
        colors = CardDefaults.cardColors(
            containerColor =  Drab,
        ),
        shape = MaterialTheme.shapes.medium.copy(all = CornerSize(12.dp)),
        modifier = Modifier
            .width(312.dp)
            .height(196.dp)
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(start = 20.dp, top = 20.dp, end = 20.dp, bottom = 10.dp)
        ) {
            Text(
                text = title,
                style = LPTypography.titleMedium,
                color = colors.onPrimary,
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = description,
                style = LPTypography.bodyMedium,
                color = colors.onPrimary,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Justify,
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.height(10.dp))
            Spacer(modifier = Modifier.weight(1f))
            Box(
                modifier = Modifier.background(
                    Color.White.copy(alpha = 0.1f),
                    shape = MaterialTheme.shapes.medium.copy(all = CornerSize(12.dp))
                )
            ) {
                TextButton(
                    onClick = onButtonClick,
                    colors = ButtonDefaults.textButtonColors(
                        contentColor = colors.onPrimary
                    )
                ) {
                    Text(text = buttonText)
                }
            }
        }
    }
}

