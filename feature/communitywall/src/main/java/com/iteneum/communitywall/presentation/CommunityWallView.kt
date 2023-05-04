package com.iteneum.communitywall.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.iteneum.communitywall.domain.Post
import com.iteneum.designsystem.components.LpPostCard
import com.iteneum.designsystem.theme.LeasePertTheme


/**
[CommunityWallView]
is a composable function that represents a view for displaying a list of posts
in a community or feed in an Android application. It uses the [CommunityWallItemList]
function to retrieve a list of mock data for the posts and displays them using
the [LazyColumn] composable.

@Composable
fun communityWallView()

This function does not accept any parameters and does not return any values.
It simply calls the [CommunityWallItemList] function to retrieve the list
of posts and displays them in a vertically scrolling list.
 **/

@Composable
fun CommunityWallView() {
    CommunityWallItemList()
}

/**

[CommunityWallItemList] is a composable function that represents a list of posts in
a community or feed in an Android application. It retrieves a list of mock data
for the posts and displays them using the [LazyColumn] composable.

@Composable
fun CommunityWallItemList()

This function retrieves a list of mock data for the posts using the [listOf] function,
which contains instances of the [Post] data class. It then creates a [LazyColumn]
composable, which is a vertically scrolling list, and uses the [items] function
to iterate through the list of posts and create a [LpPostCard] composable for
each post. The [LpPostCard] composable is customized with the post's name,
image URL, time, and message using the properties of the [Post] data class.
It also takes optional modifiers, onClick events, and other parameters as needed.

This function is typically used as a UI component to display a list of posts in a
community or feed screen in an Android application, and it can be customized with
different data sources, UI styles, and behavior depending on the requirements of
the application.
 **/
@Composable
fun CommunityWallItemList() {

    val size = LeasePertTheme.sizes

    val postList = listOf(
        Post(
            "https://img.favpng.com/25/7/23/computer-icons-user-profile-avatar-image-png-favpng-LFqDyLRhe3PBXM0sx2LufsGFU.jpg",
            "Martin Perroni",
            "10m",
            "This is a post about something"
        ),
        Post(
            "https://img.favpng.com/25/7/23/computer-icons-user-profile-avatar-image-png-favpng-LFqDyLRhe3PBXM0sx2LufsGFU.jpg",
            "Martin Perroni",
            "10m",
            "This is a post about something"
        ),
        Post(
            "https://img.favpng.com/25/7/23/computer-icons-user-profile-avatar-image-png-favpng-LFqDyLRhe3PBXM0sx2LufsGFU.jpg",
            "Martin Perroni",
            "10m",
            "This is a post about something"
        ),
        Post(
            "https://img.favpng.com/25/7/23/computer-icons-user-profile-avatar-image-png-favpng-LFqDyLRhe3PBXM0sx2LufsGFU.jpg",
            "Martin Perroni",
            "10m",
            "This is a post about something"
        ),
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        LazyColumn {
            items(postList) {
                LpPostCard(
                    modifier = Modifier.padding(size.smallerSize),
                    it.name,
                    it.img,
                    it.time,
                    it.message,
                    {},
                    {})
            }
        }
    }
}