package com.iteneum.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.iteneum.designsystem.R
import com.iteneum.designsystem.theme.LeasePertTheme

@Composable
fun LpGenericChip(
    modifier: Modifier = Modifier,
    label: String,
    icon: ImageVector? = null,
    onClick: () -> Unit
) {
    val sizes = LeasePertTheme.sizes
    Box(
        modifier = modifier
            .padding(end = sizes.minorSmallSize, bottom = sizes.minorSmallSize)
            .clickable { onClick }
    ) {
        Box(
            modifier = modifier
                .clip(RoundedCornerShape(sizes.midSmallSize))
                .background(MaterialTheme.colorScheme.primary)
                .padding(
                    start = sizes.smallerSize,
                    top = sizes.minorSmallSize,
                    end = sizes.smallerSize,
                    bottom = sizes.minorSmallSize
                )
                .defaultMinSize(minWidth = sizes.extraSize36, minHeight = sizes.regularSize),
            contentAlignment = Alignment.Center
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                icon?.let {
                    Icon(
                        imageVector = icon,
                        contentDescription = stringResource(R.string.icon_description),
                        modifier = Modifier.size(ButtonDefaults.IconSize),
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                    Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
                }
                Text(
                    text = label,
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}