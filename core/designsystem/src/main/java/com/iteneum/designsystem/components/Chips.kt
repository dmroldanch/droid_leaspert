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
import androidx.compose.ui.unit.dp
import com.iteneum.designsystem.R

@Composable
fun LpGenericChip(
    modifier: Modifier = Modifier,
    label: String,
    icon: ImageVector? = null,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .padding(end = 5.dp, bottom = 5.dp)
            .clickable { onClick }
    ) {
        Box(
            modifier = modifier
                .clip(RoundedCornerShape(12.dp))
                .background(MaterialTheme.colorScheme.primary)
                .padding(10.dp, 5.dp, 10.dp, 5.dp)
                .defaultMinSize(minWidth = 35.dp, minHeight = 25.dp),
            contentAlignment = Alignment.Center
        ) {
            Row(horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                icon?.let {
                    Icon(
                        imageVector = icon,
                        contentDescription = stringResource(R.string.icon_description),
                        modifier = Modifier.size(ButtonDefaults.IconSize),
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                    Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
                }
                Text(text = label, color = MaterialTheme.colorScheme.onPrimary, fontWeight = FontWeight.Medium)
            }
        }
    }
}