package com.iteneum.designsystem.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Comment
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.rememberAsyncImagePainter
import com.iteneum.designsystem.theme.Bianca
import com.iteneum.designsystem.theme.Drab
import com.iteneum.designsystem.theme.LPTypography

/**
 * Created [LpPostCard]
 *
 * @param modifier to modify an specific property of the card
 * @param content as a high order function
 *
 * @author Daniel Roldan
 */
@Composable
fun LpBasicCard(
    modifier: Modifier = Modifier,
    content: @Composable (ColumnScope.() -> Unit)
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
    timeAgo: String,
    messagePost: String,
    sizeWidth: Float  = 1F,
    onCommentClick: () -> Unit,
    onFavoriteClick: () -> Unit
){
    Card(
        modifier = modifier
            .fillMaxWidth(sizeWidth)
            .padding(15.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.onPrimary),
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
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        fontWeight = FontWeight.Medium,
                        fontSize = 12.sp
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = timeAgo,
                        color = MaterialTheme.colorScheme.tertiary,
                        fontWeight = FontWeight.Medium,
                        fontSize = 12.sp
                    )
                }
            }
            Row(modifier = Modifier.padding(10.dp)){
                Text(
                    text = messagePost,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    fontSize = 15.sp
                )
            }
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End){
                IconButton(onClick = onCommentClick) {
                    Icon(
                        Icons.Outlined.Comment,
                        "Comment",
                        modifier = Modifier,
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }
                IconButton(onClick = onFavoriteClick) {
                    Icon(
                        Icons.Outlined.Favorite,
                        contentDescription = "Favorite",
                        modifier = Modifier,
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
        }
    }
}

/**
 * This function create a card with an icon and description
 *
 * @param icon The icon to be displayed
 * @param description Description to be displayed below the icon
 * @param onCardClick onClick event when card is clicked
 *
 * @author Jose Guadalupe Rivera
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LpIconTextCard(
    icon: ImageVector,
    description: String,
    onCardClick: (String) -> Unit
) {
    Card(
        modifier = Modifier
            .height(120.dp)
            .heightIn(120.dp, 250.dp)
            .padding(8.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.onPrimary),
        shape = RoundedCornerShape(12.dp),
        onClick = { onCardClick(description) },
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.Center,

            ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = description,
                    tint = MaterialTheme.colorScheme.onPrimary
                )
                Text(
                    text = description,
                    style = LPTypography.bodyLarge,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    }
}

/**
 * [LPGenericElevatedCard] it's a card to show in the Dashboard screen
 *
 * @param title String to modify the name of the card
 * @param description String to modify the description within the card
 * @param onButtonClick High order function to assign the action that this card will have
 *
 * @author Jesus Lopez Gonzalez
 */
@Composable
fun LPGenericElevatedCard(
    title: String,
    description: String,
    buttonText: String,
    onButtonClick: () -> Unit
) {
    val colors = MaterialTheme.colorScheme
    Card(
        colors = CardDefaults.cardColors(
            containerColor =  Drab,
        ),
        shape = MaterialTheme.shapes.medium.copy(all = CornerSize(12.dp)),
        modifier = Modifier
            .width(312.dp)
            .height(196.dp)
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(start = 20.dp, top = 20.dp, end = 20.dp, bottom = 10.dp)
        ) {
            Text(
                text = title,
                style = LPTypography.titleMedium,
                color = colors.onPrimary,
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = description,
                style = LPTypography.bodyMedium,
                color = colors.onPrimary,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Justify,
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.height(10.dp))
            Spacer(modifier = Modifier.weight(1f))
            Box(
                modifier = Modifier.background(
                    Color.White.copy(alpha = 0.1f),
                    shape = MaterialTheme.shapes.medium.copy(all = CornerSize(12.dp))
                )
            ) {
                TextButton(
                    onClick = onButtonClick,
                    colors = ButtonDefaults.textButtonColors(
                        contentColor = colors.onPrimary
                    )
                ) {
                    Text(text = buttonText)
                }
            }
        }
    }
}

/**
 * [LPGenericElevatedCardImage] it's a card to show in the Community List screen
 *
 * @param imageUrl String that will be a url to get the image from the internet
 * @param title String to modify the name of the card
 * @param description String to modify the description within the card
 * @param onClick High order function to assign the action that this card will have
 *
 * @author Jesus Lopez Gonzalez
 */
@Composable
fun LPGenericElevatedCardImage(
    imageUrl: String,
    title: String,
    description: String,
    onClick: () -> Unit
) {
    Card(
        shape = MaterialTheme.shapes.medium.copy(all = CornerSize(12.dp)),
        colors = CardDefaults.cardColors(
            containerColor = Drab,
        ),
        modifier = Modifier.padding(all = 10.dp)
    ) {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = Bianca,
            ),
            shape = MaterialTheme.shapes.medium.copy(all = CornerSize(11.dp)),
            modifier = Modifier
                .width(177.dp)
                .height(245.dp)
                .clickable(onClick = onClick)
                .padding(all = 1.2.dp)
        ) {
            Column {
                Image(
                    painter = rememberAsyncImagePainter(imageUrl),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(169.dp),
                    contentScale = ContentScale.Crop
                )
                Box(modifier = Modifier.padding(all = 12.dp)) {
                    ConstraintLayout {
                        val (titleText, descriptionText) = createRefs()

                        Text(
                            text = title,
                            style = MaterialTheme.typography.titleLarge,
                            color = MaterialTheme.colorScheme.onSurface,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.constrainAs(titleText) {
                                top.linkTo(parent.top)
                            }
                        )
                        Text(
                            text = description,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurface,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.constrainAs(descriptionText) {
                                top.linkTo(titleText.bottom)
                            }
                        )
                    }
                }
            }
        }
    }
}