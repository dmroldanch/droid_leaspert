package com.iteneum.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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

/**
 * Created [LpGenericChip]
 *
 * @param modifier to modify an specific property of the chip
 * @param label as an example: 'History', 'Pay Now' or '+ New'
 * @param onClicked this is the clickable option
 * @param icon an optional icon before the label
 *
 * @author Juan Islas
 */
@Composable
fun LpGenericChip(
    modifier: Modifier = Modifier,
    label: String,
    icon: ImageVector? = null,
    onClicked: () -> Unit
) {
    val sizes = LeasePertTheme.sizes
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(sizes.smallSize))
            .background(MaterialTheme.colorScheme.primary)
            .padding(
                all = sizes.midSmallSize,
            )
            .clickable(onClick = onClicked),
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
                    modifier = Modifier
                        .size(ButtonDefaults.IconSize)
                        .padding(horizontal = sizes.stroke),
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
            Text(
                text = label,
                color = MaterialTheme.colorScheme.onPrimary,
                fontWeight = FontWeight.Medium
            )
        }
    }
}