package com.iteneum.designsystem.components

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.iteneum.designsystem.theme.Boulder
import com.iteneum.designsystem.theme.LPTypography

@Composable
fun LPTitleLarge(
    modifier: Modifier = Modifier,
    label: String,
    color: Color,
    textAlign: TextAlign? = TextAlign.Center
) {
    Text(
        text = label,
        color = color,
        style = LPTypography.titleLarge,
        modifier = modifier, textAlign = textAlign)
}

@Composable
fun LPTitleMedium(
    modifier: Modifier = Modifier,
    label: String,
    color: Color,
    textAlign: TextAlign? = TextAlign.Center
) {
    Text(
        text = label,
        color = color,
        style = LPTypography.titleMedium,
        modifier = modifier, textAlign = textAlign)
}

@Composable
fun LPTitleSmall(
    modifier: Modifier = Modifier,
    label: String,
    color: Color,
    textAlign: TextAlign? = TextAlign.Center
){
    Text(
        text = label,
        color = color,
        style = LPTypography.titleSmall,
        modifier = modifier, textAlign = textAlign)
}

@Composable
fun LPBodyLarge(
    modifier: Modifier = Modifier,
    label: String,
    color: Color,
    onClick: (() -> Unit)? = null
) {
    Text(
        text = label,
        color = color,
        style = LPTypography.bodyLarge,
        modifier = modifier.clickable { onClick?.invoke() })
}

@Composable
fun LPBodyMedium(
    modifier: Modifier = Modifier,
    label: String,
    color: Color,
    onClick: (() -> Unit)? = null
) {
    Text(
        text = label,
        color = color,
        style = LPTypography.bodyMedium,
        modifier = modifier.clickable { onClick?.invoke() })
}

@Composable
fun LPBodySmall(
    modifier: Modifier = Modifier,
    label: String,
    color: Color,
    onClick: (() -> Unit)? = null
) {
    Text(
        text = label,
        color = color,
        style = LPTypography.bodySmall,
        modifier = modifier.clickable { onClick?.invoke() })
}

@Composable
fun LPSubTitleLarge(
    modifier: Modifier = Modifier,
    label: String,
    color: Color,
    onClick: (() -> Unit)? = null
){
    Text(
        text = label,
        color = color,
        style = LPTypography.bodySmall,
        modifier = modifier.clickable { onClick?.invoke() })
}

@Composable
fun LPSubTitleMedium(
    modifier: Modifier = Modifier,
    label: String,
    color: Color,
    onClick: (() -> Unit)? = null
){
    Text(
        text = label,
        color = color,
        style = LPTypography.bodySmall,
        modifier = modifier.clickable { onClick?.invoke() })
}

@Composable
fun LPSubTitleSmall(
    modifier: Modifier = Modifier,
    label: String,
    color: Color,
    onClick: (() -> Unit)? = null
){
    Text(
        text = label,
        color = color,
        style = LPTypography.bodySmall,
        modifier = modifier.clickable { onClick?.invoke() })
}