package com.iteneum.community.domain

import androidx.compose.ui.graphics.vector.ImageVector

/**

Data class that represents the model for each button inside the UI view Community, where every instance
will turn into a clickable button. It contains the necessary properties to set the icon of the card button
and the corresponding card type represented by a sealed class called CommunityCardType.
@param icon an Image vector to set the icon of the card button
@param cardType the card type represented by the sealed class CommunityCardType
@see CommunityCardType
This data class is used in a list of communities in the view called CommunityView, where each object
represents a different section. The CommunityCardType sealed class is used to represent the different
types of card buttons available for each section.
@author Irving Gonzalez
 */
data class Community(
    val icon: ImageVector,
    val cardType: CommunityCardType)
