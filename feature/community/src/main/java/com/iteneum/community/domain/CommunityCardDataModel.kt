package com.iteneum.community.domain

import androidx.compose.ui.graphics.vector.ImageVector

/**
 * this Data class represents the model for each button inside UI view Community
 * where every instance will turn into a clickable button
 * @param icon needs an Image vector to set the icon of the card Button
 * @param cardName  uses the Enum list to set the propper name for the Card Button
 *
 * @author Andrés Ivan Medina Herrera
 */
data class CommunityCardDataModel(val icon: ImageVector, val cardName: CommunitySectionList)
