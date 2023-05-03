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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import com.iteneum.designsystem.R
import com.iteneum.designsystem.theme.*
import com.iteneum.designsystem.utils.TextUtils.ONE
import java.sql.Timestamp

/**
 * Created [LpGenericCard]
 *
 * @param modifier to modify an specific property of the card
 * @param title as an example 'Current balance'
 * @param details this is the clickable option
 * @param accountNumber the showed String number
 * @param currency if the number represents currency for example current balance
 * @param onTextClicked as a high order function
 *
 * @author Daniel Roldan
 * @modifyBy Jose Guadalupe Rivera
 */
@Composable
fun LpGenericCard(
    modifier: Modifier = Modifier,
    title: String,
    details: String,
    accountNumber: String,
    currency: Boolean = false,
    onTextClicked: () -> Unit
) {
    val sizes = LeasePertTheme.sizes
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background
        ),
        border = BorderStroke(sizes.stroke, MaterialTheme.colorScheme.onPrimary),
        elevation = CardDefaults.cardElevation(sizes.stroke),
    )
    {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .padding(all = sizes.smallSize)
            ) {
                Text(
                    modifier = Modifier.padding(bottom = LeasePertTheme.sizes.extraSize6),
                    text = title,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    style = LPTypography.bodyLarge,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    modifier = Modifier
                        .clickable(
                            enabled = true,
                            onClick = onTextClicked
                        ),
                    text = details,
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontWeight = FontWeight.Medium,
                    style = LPTypography.titleSmall
                )
            }
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = sizes.regularSize),
                text = if (currency)
                    "$$accountNumber" else accountNumber,
                color = MaterialTheme.colorScheme.tertiary,
                style = LPTypography.headlineSmall,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.End,
                maxLines = 1
            )
        }
    }
}

/**
 * Create [LpPostCard] compose for user's posts
 *
 * @param modifier to modify an specific property of the card
 * @param userName a String value of the user name
 * @param userPhoto a painter assigned to the user
 * @param timeAgo the float value of the minutes of the post
 * @param messagePost the string of the post
 * @param onCommentClicked high order function
 * @param onFavoriteClicked high order function
 *
 * @author Juan Ramon Islas Huesca
 */
@Composable
fun LpPostCard(
    modifier: Modifier,
    userName: String,
    userPhoto: String,
    timeAgo: String,
    messagePost: String,
    onCommentClicked: () -> Unit,
    onFavoriteClicked: () -> Unit
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
        border = BorderStroke(LeasePertTheme.sizes.stroke, MaterialTheme.colorScheme.onPrimary),
        elevation = CardDefaults.cardElevation(LeasePertTheme.sizes.stroke),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = LeasePertTheme.sizes.smallSize,
                    top = LeasePertTheme.sizes.smallSize,
                    end = LeasePertTheme.sizes.smallSize,
                    bottom = LeasePertTheme.sizes.extraSize6
                )
        ) {
            Row(modifier = Modifier.padding(bottom = LeasePertTheme.sizes.minorSmallSize)) {
                SubcomposeAsyncImage(
                    modifier = Modifier
                        .size(LeasePertTheme.sizes.extraSize48)
                        .clip(CircleShape),
                    model = userPhoto,
                    contentScale = ContentScale.Crop,
                    contentDescription = userName
                )
                Column(modifier = Modifier.padding(start = LeasePertTheme.sizes.smallerSize)) {
                    Text(
                        modifier = Modifier.padding(bottom = LeasePertTheme.sizes.minorSmallSize),
                        text = userName,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        fontWeight = FontWeight.Medium,
                        fontSize = 12.sp
                    )
                    Text(
                        text = timeAgo,
                        color = MaterialTheme.colorScheme.tertiary,
                        fontWeight = FontWeight.Medium,
                        fontSize = 12.sp
                    )
                }
            }
            Text(
                text = messagePost,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                fontSize = 15.sp
            )
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                IconButton(onClick = onCommentClicked) {
                    Icon(
                        imageVector = Icons.Outlined.Comment,
                        contentDescription = stringResource(R.string.content_description_comment),
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }
                IconButton(onClick = onFavoriteClicked) {
                    Icon(
                        imageVector = Icons.Outlined.Favorite,
                        contentDescription = stringResource(R.string.content_description_favorite),
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
 * @param modifier component modifier.
 * @param icon The icon to be displayed
 * @param description Description to be displayed below the icon
 * @param onCardClicked onClick event when card is clicked
 *
 * @author Jose Guadalupe Rivera
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LpIconTextCard(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    description: String,
    onCardClicked: (String) -> Unit
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        border = BorderStroke(LeasePertTheme.sizes.stroke, MaterialTheme.colorScheme.onPrimary),
        shape = RoundedCornerShape(LeasePertTheme.sizes.midSmallSize),
        onClick = { onCardClicked(description) },
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    modifier = Modifier.padding(bottom = LeasePertTheme.sizes.minorSmallSize),
                    imageVector = icon,
                    contentDescription = description,
                    tint = MaterialTheme.colorScheme.onPrimary
                )
                Text(
                    text = description,
                    style = LPTypography.bodyLarge,
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

/**
 * [LPGenericElevatedCard] it's a card to show in the Dashboard screen
 *
 * @param modifier Modifier to add the params needed to the whole component's modifier
 * @param title String to modify the name of the card
 * @param description String to modify the description within the card
 * @param buttonText Text button
 * @param onButtonClicked High order function to assign the action that this card will have
 * @param color Set the component background color
 *
 * @author Jesus Lopez Gonzalez
 * @modifyBy Jose Guadalupe Rivera
 */
@Composable
fun LPGenericElevatedCard(
    modifier: Modifier,
    title: String,
    description: String,
    buttonText: String,
    color: Color = AtomicTangerine,
    onButtonClicked: () -> Unit
) {
    val colors = MaterialTheme.colorScheme
    val sizes = LeasePertTheme.sizes
    Card(
        colors = CardDefaults.cardColors(
            containerColor = color,
        ),
        shape = MaterialTheme.shapes.medium.copy(all = CornerSize(LeasePertTheme.sizes.midSmallSize)),
        modifier = modifier
            .widthIn(sizes.extraSize48, sizes.extraSize336)
    ) {
        Column(
            modifier = Modifier.padding(
                start = LeasePertTheme.sizes.minorRegularSize,
                top = LeasePertTheme.sizes.minorRegularSize,
                end = LeasePertTheme.sizes.minorRegularSize,
                bottom = LeasePertTheme.sizes.extraSize10
            )
        ) {
            Text(
                text = title,
                style = LPTypography.titleMedium,
                color = colors.inversePrimary,
                modifier = Modifier.padding(bottom = LeasePertTheme.sizes.extraSize6)
            )
            Text(
                text = description,
                style = LPTypography.bodyMedium,
                color = colors.inversePrimary,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Justify,
                modifier = Modifier.padding(bottom = LeasePertTheme.sizes.extraSize14)
            )
            Box(
                modifier = Modifier.background(
                    color = TransparentWhite,
                    shape = MaterialTheme.shapes.medium.copy(all = CornerSize(LeasePertTheme.sizes.midSmallSize))
                )
            ) {
                TextButton(
                    onClick = onButtonClicked,
                    colors = ButtonDefaults.textButtonColors(
                        contentColor = colors.inversePrimary
                    )
                ) {
                    Text(text = buttonText)
                }
            }
        }
    }
}

/* TODO change function location to the view-model, this function
*   shouldn't be here.*/
fun getRandomColor(random: Int): Color {
    val colorList = listOf(AtomicTangerine, DenimBlue, RedSalsa)
    return colorList[random]
}

/**
 * [LPGenericElevatedCardImage] it's a card to show in the Community List screen
 *
 * @param modifier Modifier to add the needed attributes to this component's modifier.
 * @param imageUrl String that will be a url to get the image from the internet
 * @param title String to modify the name of the card
 * @param description String to modify the description within the card
 * @param onClicked High order function to assign the action that this card will have
 *
 * @author Jesus Lopez Gonzalez
 * @modifyBy Carlos Hernandez
 */
@Composable
fun LPGenericElevatedCardImage(
    modifier: Modifier,
    imageUrl: String?,
    title: String,
    description: String,
    onClicked: () -> Unit
) {
    val dp1 = LeasePertTheme.sizes.stroke
    val dp12 = LeasePertTheme.sizes.midSmallSize
    val dp16 = LeasePertTheme.sizes.smallSize
    val dp182 = LeasePertTheme.sizes.extraSize182
    Card(
        border = BorderStroke(width = dp1, color = Drab),
        colors = CardDefaults.cardColors(
            containerColor = Bianca,
        ),
        shape = MaterialTheme.shapes.medium.copy(all = CornerSize(dp12)),
        modifier = modifier
            .clickable(onClick = onClicked)
    ) {
        Column {
            if (imageUrl != null) {
                SubcomposeAsyncImage(
                    modifier = Modifier
                        .fillMaxSize()
                        .height(dp182),
                    model = imageUrl,
                    contentScale = ContentScale.Crop,
                    contentDescription = null,
                    loading = {
                        CircularProgressIndicator()
                    }
                )
            } else {
                Image(
                    painter = painterResource(id = R.drawable.image_default),
                    contentDescription = stringResource(R.string.image_default),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(all = dp16)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Black,
                    maxLines = ONE,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(bottom = LeasePertTheme.sizes.middleSize)
                )
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface,
                    maxLines = ONE,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        }
    }
}

/**
 * [LpPaymentsRentCard] is a button for show in the UI and this button can have icon depending of the use
 *
 * @param modifier Modifier is for specify style and params of the card, like for example the width of the component.
 * @param month is the month what this component shown at the user for indicate what month is must to pay
 * @param quantity is the quantity what the user have to pay
 * @param date is the limit date where it have to pay their rent
 * @param onButtonClicked high order function to call the function clicked.
 *
 * @author Usiel Filiberto Garcia Jimenez
 */
@Composable
fun LpPaymentsRentCard(
    modifier: Modifier,
    month: String,
    quantity: Double,
    date: Timestamp,
    onButtonClicked: () -> Unit
) {
    OutlinedCard(
        modifier = modifier
            .fillMaxWidth(),
        colors = CardDefaults
            .cardColors(
                containerColor = Color.Transparent
            ),
        border = BorderStroke(
            width = LeasePertTheme.sizes.stroke,
            color = MaterialTheme.colorScheme.onPrimary
        )
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(
                    start = LeasePertTheme.sizes.midMediumSize,
                    top = LeasePertTheme.sizes.midMediumSize,
                    bottom = LeasePertTheme.sizes.minorMediumSize
                )
        ) {
            Text(
                text = month,
                style = MaterialTheme.typography.bodyLarge
            )
        }
        Row(
            Modifier
                .fillMaxWidth()
                .padding(
                    start = LeasePertTheme.sizes.midMediumSize,
                    bottom = LeasePertTheme.sizes.midMediumSize,
                    end = LeasePertTheme.sizes.midMediumSize
                )
        ) {
            Text(
                text = stringResource(R.string.rent),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.tertiary
            )
            Column(modifier = Modifier.padding(start = LeasePertTheme.sizes.midLargeSize)) {
                Text(
                    text = "$$quantity",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(bottom = LeasePertTheme.sizes.minorMediumSize)
                )
                Text(
                    text = date.toString(),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.TopEnd) {
                LpGenericChip(
                    label = stringResource(R.string.pay_now),
                    onClicked = onButtonClicked
                )
            }
        }
    }
}
