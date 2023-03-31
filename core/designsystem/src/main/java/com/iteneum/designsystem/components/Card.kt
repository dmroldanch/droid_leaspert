package com.iteneum.designsystem.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Comment
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LpBasicCard(
    modifier: Modifier = Modifier,
    content: @Composable() (ColumnScope.() -> Unit)
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.tertiary
        ),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.onPrimary),
        elevation = CardDefaults.cardElevation(1.dp),
        content = content
    )
}

/**
 * Create [LpPostCard] compose for user's posts
 *
 * @param modifier to modify an specific property of the card
 * @param userName a String value of the user name
 * @param userPhoto a painter assigned to the user
 * @param timeAgo the float value of the minutes of the post
 * @param messagePost the string of the post
 * @param sizeWidth the desire width of the card between 0 (0%) to 1 (100%)
 * @param onCommentClick high order function
 * @param onFavoriteClick high order function
 *
 * @author Juan Ramon Islas Huesca
 */
@Composable
fun LpPostCard(
    modifier: Modifier,
    userName: String,
    userPhoto: Painter,
    timeAgo: Float,
    messagePost: String,
    sizeWidth: Float  = 1F,
    onCommentClick: () -> Unit,
    onFavoriteClick: () -> Unit
){
    Card(
        modifier = modifier
            .fillMaxWidth(sizeWidth)
            .padding(15.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.onSurface),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.secondary),
        elevation = CardDefaults.cardElevation(1.dp),
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp, 15.dp, 15.dp, 5.dp)
        ){
            Row {
                Column {
                    Box(modifier = Modifier
                        .fillMaxWidth(0.20f)
                        .padding(0.dp)) {
                        Image(
                            painter = userPhoto,
                            contentDescription = "userPhoto",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(50.dp)
                                .clip(CircleShape)
                        )
                    }
                }
                Column {
                    Text(
                        text = userName,
                        color = MaterialTheme.colorScheme.background,
                        fontWeight = FontWeight.Medium,
                        fontSize = 12.sp
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    if (timeAgo >= 1) {
                        Text(
                            text = timeAgo.toInt().toString() + "m",
                            color = MaterialTheme.colorScheme.tertiary,
                            fontWeight = FontWeight.Medium,
                            fontSize = 12.sp
                        )
                    }
                    else{
                        Text(
                            text = "a few moments ago",
                            color = MaterialTheme.colorScheme.tertiary,
                            fontWeight = FontWeight.Medium,
                            fontSize = 12.sp)
                    }
                }
            }
            Row(modifier = Modifier.padding(10.dp)){
                Text(
                    text = messagePost,
                    color = MaterialTheme.colorScheme.background,
                    fontSize = 15.sp
                )
            }
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End){
                IconButton(onClick = onCommentClick) {
                    Icon(
                        Icons.Outlined.Comment,
                        "Comment",
                        modifier = Modifier,
                        tint = MaterialTheme.colorScheme.secondary
                    )
                }
                IconButton(onClick = onFavoriteClick) {
                    Icon(
                        Icons.Outlined.Favorite,
                        contentDescription = "Favorite",
                        modifier = Modifier,
                        tint = MaterialTheme.colorScheme.secondary
                    )
                }
            }
        }
    }
}