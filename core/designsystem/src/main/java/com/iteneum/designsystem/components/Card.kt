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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import com.iteneum.designsystem.R
import com.iteneum.designsystem.theme.*
import com.iteneum.designsystem.utils.TextUtils.ONE
import com.iteneum.designsystem.theme.LeasePertTheme
import java.sql.Timestamp

/**
 * Created [LpGenericCard]
 *
 * @param modifier to modify an specific property of the card
 * @param title as an example 'Current balance'
 * @param details this is the clickable option
 * @param accountNumber the showed String number
 * @param currency if the number represents currency for example current balance
 * @param onTextClick as a high order function
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
    onTextClick: () -> Unit
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
                    text = title,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    style = LPTypography.bodyLarge,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.size(sizes.minorSmallSize))
                Text(
                    modifier = Modifier
                        .clickable(
                            enabled = true,
                            onClick = onTextClick
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
 * @param onCommentClick high order function
 * @param onFavoriteClick high order function
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
    onCommentClick: () -> Unit,
    onFavoriteClick: () -> Unit
) {
    Card(
        modifier = modifier.padding(LeasePertTheme.sizes.smallSize),
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
            Row {
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
                        text = userName,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        fontWeight = FontWeight.Medium,
                        fontSize = 12.sp
                    )
                    Spacer(modifier = Modifier.height(LeasePertTheme.sizes.minorSmallSize))
                    Text(
                        text = timeAgo,
                        color = MaterialTheme.colorScheme.tertiary,
                        fontWeight = FontWeight.Medium,
                        fontSize = 12.sp
                    )
                }
            }
            Text(
                modifier = Modifier.padding(LeasePertTheme.sizes.extraSize10),
                text = messagePost,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                fontSize = 15.sp
            )
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                IconButton(onClick = onCommentClick) {
                    Icon(
                        Icons.Outlined.Comment,
                        "Comment",
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }
                IconButton(onClick = onFavoriteClick) {
                    Icon(
                        Icons.Outlined.Favorite,
                        contentDescription = "Favorite",
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
 * @param onCardClick onClick event when card is clicked
 *
 * @author Jose Guadalupe Rivera
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LpIconTextCard(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    description: String,
    onCardClick: (String) -> Unit
) {
    Card(
        modifier = modifier.padding(LeasePertTheme.sizes.smallerSize),
        border = BorderStroke(LeasePertTheme.sizes.stroke, MaterialTheme.colorScheme.onPrimary),
        shape = RoundedCornerShape(LeasePertTheme.sizes.midSmallSize),
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
 * @param title String to modify the name of the card
 * @param description String to modify the description within the card
 * @param onButtonClick High order function to assign the action that this card will have
 * @param color Set the component background color
 *
 * @author Jesus Lopez Gonzalez
 * @modifyBy Jose Guadalupe Rivera
 */
@Composable
fun LPGenericElevatedCard(
    title: String,
    description: String,
    buttonText: String,
    color: Color = AtomicTangerine,
    onButtonClick: () -> Unit
) {
    val colors = MaterialTheme.colorScheme
    Card(
        colors = CardDefaults.cardColors(
            containerColor = color,
        ),
        shape = MaterialTheme.shapes.medium.copy(all = CornerSize(LeasePertTheme.sizes.midSmallSize)),
        modifier = Modifier
            .width(LeasePertTheme.sizes.extraSize336)
            .height(LeasePertTheme.sizes.extraSize199)
            .padding(all = LeasePertTheme.sizes.smallSize)
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
            )
            Spacer(modifier = Modifier.height(LeasePertTheme.sizes.extraSize6))
            Text(
                text = description,
                style = LPTypography.bodyMedium,
                color = colors.inversePrimary,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Justify,
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.height(LeasePertTheme.sizes.extraSize10))
            Spacer(modifier = Modifier.weight(1f))
            Box(
                modifier = Modifier.background(
                    color = TransparentWhite,
                    shape = MaterialTheme.shapes.medium.copy(all = CornerSize(LeasePertTheme.sizes.midSmallSize))
                )
            ) {
                TextButton(
                    onClick = onButtonClick,
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
 * @param imageUrl String that will be a url to get the image from the internet
 * @param title String to modify the name of the card
 * @param description String to modify the description within the card
 * @param onClick High order function to assign the action that this card will have
 *
 * @author Jesus Lopez Gonzalez
 * @modifyBy Carlos Hernandez
 */
@Composable
fun LPGenericElevatedCardImage(
    imageUrl: String?,
    title: String,
    description: String,
    onClick: () -> Unit
) {
    val dp1 = LeasePertTheme.sizes.stroke
    val dp8 = LeasePertTheme.sizes.smallerSize
    val dp12 = LeasePertTheme.sizes.midSmallSize
    val dp16 = LeasePertTheme.sizes.smallSize
    val dp182 = LeasePertTheme.sizes.extraSize182
    Card(
        border = BorderStroke(width = dp1, color = Drab),
        colors = CardDefaults.cardColors(
            containerColor = Bianca,
        ),
        shape = MaterialTheme.shapes.medium.copy(all = CornerSize(dp12)),
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(all = dp8)
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
                    color = MaterialTheme.colorScheme.onSurface,
                    maxLines = ONE,
                    overflow = TextOverflow.Ellipsis,
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
 *
 * @author Usiel Filiberto Garcia Jimenez
 */
@Composable
fun LpPaymentsRentCard(modifier: Modifier, month: String, quantity: Double, date: Timestamp) {
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
                ),

            ) {
            Text(
                text = stringResource(R.string.rent),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.tertiary
            )
            Column(modifier = Modifier.padding(start = LeasePertTheme.sizes.midLargeSize)) {
                Text(
                    text = "$$quantity",
                    style = MaterialTheme.typography.bodyLarge
                )

                Spacer(modifier = Modifier.height(height = LeasePertTheme.sizes.minorMediumSize))

                Text(
                    text = date.toString(),
                    style = MaterialTheme.typography.bodyLarge
                )

            }
            Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.TopEnd) {
                LpGenericChip(label = stringResource(R.string.pay_now)) {
                    /*TODO With this button the user could pay their rent */
                }
            }
        }
    }
}
