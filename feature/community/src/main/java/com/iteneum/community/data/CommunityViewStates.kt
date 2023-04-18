package com.iteneum.community.data

data class CommunityViewStates(
    var isLoading: Boolean = false,
    var ammenities: Boolean = false,
    var events: Boolean = false,
    var communityWall: Boolean = false,
    var doItYourself: Boolean = false,
    var services: Boolean = false
)