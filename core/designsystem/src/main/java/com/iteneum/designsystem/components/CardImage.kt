package com.iteneum.designsystem.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.rememberAsyncImagePainter
import com.iteneum.designsystem.theme.Bianca
import com.iteneum.designsystem.theme.Drab

@Composable
fun LPGenericElevatedCardImage(
    imageUrl: String,
    title: String,
    description: String,
    onClick: () -> Unit
) {
    Card(
        shape = MaterialTheme.shapes.medium.copy(all = CornerSize(12.dp)),
        colors = CardDefaults.cardColors(
            containerColor = Drab,
        ),
        modifier = Modifier.padding(10.dp)
    ) {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = Bianca,
            ),
            shape = MaterialTheme.shapes.medium.copy(all = CornerSize(11.dp)),
            modifier = Modifier
                .width(177.dp)
                .height(245.dp)
                .clickable(onClick = onClick)
                .padding(1.2.dp)
        ) {
            Column {
                Image(
                    painter = rememberAsyncImagePainter(imageUrl),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(169.dp),
                    contentScale = ContentScale.Crop
                )
                Box(modifier = Modifier.padding(12.dp)) {
                    ConstraintLayout {
                        val (titleText, descriptionText) = createRefs()

                        Text(
                            text = title,
                            style = MaterialTheme.typography.titleLarge,
                            color = MaterialTheme.colorScheme.onSurface,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.constrainAs(titleText) {
                                top.linkTo(parent.top)
                            }
                        )
                        Text(
                            text = description,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurface,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.constrainAs(descriptionText) {
                                top.linkTo(titleText.bottom)
                            }
                        )
                    }
                }
            }
        }
    }
}