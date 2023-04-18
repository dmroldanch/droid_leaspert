package com.iteneum.communitywall.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.iteneum.communitywall.domain.Post
import com.iteneum.designsystem.components.LpPostCard

@Composable
fun communityWallView(){
    communityWallItemList()
}

@Composable
fun communityWallItemList() {

    //Mock Data

    val list = listOf(
        Post("https://img.favpng.com/25/7/23/computer-icons-user-profile-avatar-image-png-favpng-LFqDyLRhe3PBXM0sx2LufsGFU.jpg","Martin Perroni","10m","This is a post about something"),
        Post("https://img.favpng.com/25/7/23/computer-icons-user-profile-avatar-image-png-favpng-LFqDyLRhe3PBXM0sx2LufsGFU.jpg","Martin Perroni","10m","This is a post about something"),
        Post("https://img.favpng.com/25/7/23/computer-icons-user-profile-avatar-image-png-favpng-LFqDyLRhe3PBXM0sx2LufsGFU.jpg","Martin Perroni","10m","This is a post about something"),
        Post("https://img.favpng.com/25/7/23/computer-icons-user-profile-avatar-image-png-favpng-LFqDyLRhe3PBXM0sx2LufsGFU.jpg","Martin Perroni","10m","This is a post about something"),
    )

    Box(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
    ){
        LazyColumn{
            items(list){
                LpPostCard(modifier = Modifier, it.name, it.img, it.time, it.message, {}, {})
            }
        }
    }
}