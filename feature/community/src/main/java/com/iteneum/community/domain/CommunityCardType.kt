package com.iteneum.community.domain

/**
This sealed class represents the different sections of the UI view Community,
each object represents a specific section and is used to access string resources and set proper names to card buttons.
Objects:
* Amenities: represents the Amenities section.
* Events: represents the Events section.
* CommunityWall: represents the Community Wall section.
* DoItYourself: represents the Do It Yourself section.
* Services: represents the Services section.
* Usage: Each object of this class is used as a parameter in the Community data class to create a clickable button in the UI view Community.
* Example: Community(Icons.Outlined.Diamond, CommunityCardType.Amenities)
* @author: Irving Gonzalez
 */
sealed class CommunityCardType {
    object Amenities : CommunityCardType()
    object Events : CommunityCardType()
    object CommunityWall : CommunityCardType()
    object DoItYourself : CommunityCardType()
    object Services : CommunityCardType()
}
